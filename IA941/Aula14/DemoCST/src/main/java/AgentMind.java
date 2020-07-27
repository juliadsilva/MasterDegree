
/** ***************************************************************************
 * Copyright 2007-2015 DCA-FEEC-UNICAMP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *    Klaus Raizer, Andre Paraense, Ricardo Ribeiro Gudwin
 **************************************************************************** */

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.Mind;
import codelets.behaviors.EatClosestApple;
import codelets.behaviors.Forage;
import codelets.behaviors.GetClosestDesiredJewel;
import codelets.behaviors.GoToClosestApple;
import codelets.behaviors.GoToClosestDesiredJewel;
import codelets.motor.HandsActionCodelet;
import codelets.motor.LegsActionCodelet;
import codelets.perception.AppleDetector;
import codelets.perception.ClosestAppleDetector;
import codelets.perception.ClosestJewelDetector;
import codelets.perception.JewelDetector;
import codelets.sensors.InnerSense;
import codelets.sensors.Vision;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import memory.CreatureInnerSense;
import support.MindView;
import ws3dproxy.model.Thing;

/**
 *
 * @author rgudwin
 */
public class AgentMind extends Mind {

    private static int creatureBasicSpeed = 3;
    private static int reachDistance = 50;

    public AgentMind(Environment env) {
        super();

        // Declare Memory Objects
        Memory legsMO;
        Memory handsMO;
        Memory visionMO;
        Memory innerSenseMO;
        Memory closestAppleMO;
        Memory knownApplesMO;
        Memory closestJewelsMO;
        Memory knownJewelsMO;

        //Initialize Memory Objects
        legsMO = createMemoryObject("LEGS", "");
        handsMO = createMemoryObject("HANDS", "");
        List<Thing> vision_list = Collections.synchronizedList(new ArrayList<Thing>());
        visionMO = createMemoryObject("VISION", vision_list);
        
        CreatureInnerSense cis = new CreatureInnerSense();
        innerSenseMO = createMemoryObject("INNER", cis);
        
        Thing closestApple = null;
        closestAppleMO = createMemoryObject("CLOSEST_APPLE", closestApple);
        List<Thing> knownApples = Collections.synchronizedList(new ArrayList<Thing>());
        knownApplesMO = createMemoryObject("KNOWN_APPLES", knownApples);
        
        Thing closestJewel = null;
        closestJewelsMO= createMemoryObject("CLOSEST_JEWEL", closestJewel);
        List<Thing> knownJewels = Collections.synchronizedList(new ArrayList<Thing>());
        knownJewelsMO = createMemoryObject("KNOWN_JEWELS", knownJewels);

        // Create and Populate MindViewer
        MindView mv = new MindView("MindView");
        mv.addMO(knownApplesMO);
        mv.addMO(knownJewelsMO);
        mv.addMO(visionMO);
        mv.addMO(closestAppleMO);
        mv.addMO(innerSenseMO);
        mv.addMO(handsMO);
        mv.addMO(legsMO);
        mv.StartTimer();
        mv.setVisible(true);

        // Create Sensor Codelets	
        Codelet vision = new Vision(env.creature);
        vision.addOutput(visionMO);
        insertCodelet(vision); //Creates a vision sensor

        Codelet innerSense = new InnerSense(env.creature);
        innerSense.addOutput(innerSenseMO);
        insertCodelet(innerSense); //A sensor for the inner state of the creature

        // Create Actuator Codelets
        Codelet legs = new LegsActionCodelet(env.creature);
        legs.addInput(legsMO);
        insertCodelet(legs);

        Codelet hands = new HandsActionCodelet(env.creature);
        hands.addInput(handsMO);
        insertCodelet(hands);

        // Create Perception Codelets
        Codelet appleDetector = new AppleDetector();
        appleDetector.addInput(visionMO);
        appleDetector.addOutput(knownApplesMO);
        insertCodelet(appleDetector);

        Codelet closestAppleDetector = new ClosestAppleDetector();
        closestAppleDetector.addInput(knownApplesMO);
        closestAppleDetector.addInput(innerSenseMO);
        closestAppleDetector.addOutput(closestAppleMO);
        insertCodelet(closestAppleDetector);
        
         Codelet jewelDetector = new JewelDetector();
         jewelDetector.addInput(visionMO);
         jewelDetector.addOutput(knownJewelsMO);
         insertCodelet(jewelDetector);
        
         Codelet closestJewelDetector = new ClosestJewelDetector();
         closestJewelDetector.addInput(knownJewelsMO);
         closestJewelDetector.addInput(innerSenseMO);
         closestJewelDetector.addOutput(closestJewelsMO);
         insertCodelet(closestJewelDetector);

        // Create Behavior Codelets
        Codelet goToClosestApple = new GoToClosestApple(creatureBasicSpeed, reachDistance);
        goToClosestApple.addInput(closestAppleMO);
        goToClosestApple.addInput(innerSenseMO);
        goToClosestApple.addOutput(legsMO);
        insertCodelet(goToClosestApple);
        
        // Codelet goToClosestDesiredJewel = new GoToClosestDesiredJewel(creatureBasicSpeed, reachDistance);
        // goToClosestDesiredJewel.addInput(closestJewelsMO);
        // goToClosestDesiredJewel.addInput(innerSenseMO);
        // goToClosestDesiredJewel.addOutput(legsMO);
        // insertCodelet(goToClosestDesiredJewel);

        Codelet eatApple = new EatClosestApple(reachDistance);
        eatApple.addInput(closestAppleMO);
        eatApple.addInput(innerSenseMO);
        eatApple.addOutput(handsMO);
        eatApple.addOutput(knownApplesMO);
        insertCodelet(eatApple);
        
         Codelet getDesiredJewel = new GetClosestDesiredJewel(reachDistance);
         getDesiredJewel.addInput(closestJewelsMO);
         getDesiredJewel.addInput(innerSenseMO);
         getDesiredJewel.addOutput(handsMO);
         getDesiredJewel.addOutput(knownJewelsMO);
         insertCodelet(getDesiredJewel);

        Codelet forage = new Forage();
        forage.addInput(knownApplesMO);
        forage.addInput(knownJewelsMO);
        forage.addOutput(legsMO);
        insertCodelet(forage);

        // sets a time step for running the codelets to avoid heating too much your machine
        for (Codelet codelet : this.getCodeRack().getAllCodelets()) {
            codelet.setTimeStep(200);
        }

        // Start Cognitive Cycle
        start();
    }

}
