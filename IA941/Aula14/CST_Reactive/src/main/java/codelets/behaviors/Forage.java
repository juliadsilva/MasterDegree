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
package codelets.behaviors;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import java.util.List;
import memory.CreatureInnerSense;
import org.json.JSONException;
import org.json.JSONObject;
import ws3dproxy.model.Thing;

/**
 *
 * @author klaus
 *
 *
 */
public class Forage extends Codelet {

    private Memory knownFoodsMO;
    private Memory knownJewelsMO;
    private Memory visionMO;
    private Memory legsMO;
    private Memory innerSenseMO;
    private List<Thing> knownFoods;
    private List<Thing> vision;
    private List<Thing> knownJewels;
    

    /**
     * Default constructor
     */
    public Forage() {
    }

    @Override
    public void proc() {
        knownFoods = (List<Thing>) knownFoodsMO.getI();
        knownJewels = (List<Thing>) knownJewelsMO.getI();
        vision = (List<Thing>) visionMO.getI();
        CreatureInnerSense creatureInnerSense = (CreatureInnerSense) innerSenseMO.getI();

        if ( !creatureInnerSense.isLeafletReady() && (vision.size() == 0 || (knownJewels.size() == 0 && knownFoods.size() == 0))) {
            JSONObject message = new JSONObject();
            try {
                message.put("ACTION", "FORAGE");
                legsMO.setI(message.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void accessMemoryObjects() {
        knownJewelsMO = (MemoryObject) this.getInput("KNOWN_JEWELS");
        knownFoodsMO = (MemoryObject) this.getInput("KNOWN_FOODS");
        visionMO = (MemoryObject)  this.getInput("VISION");
        legsMO = (MemoryObject) this.getOutput("LEGS");
        innerSenseMO = (MemoryObject) this.getInput("INNER");
        // TODO Auto-generated method stub
    }

    @Override
    public void calculateActivation() {

    }

}