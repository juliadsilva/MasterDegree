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

import java.awt.Point;
import java.awt.geom.Point2D;

import org.json.JSONException;
import org.json.JSONObject;

import br.unicamp.cst.core.entities.Codelet;
import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;
import memory.CreatureInnerSense;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import ws3dproxy.model.Thing;

public class EatClosestFood extends Codelet {

    private Memory closestFoodMO;
    private Memory innerSenseMO;
    private Memory knownMO;
    private int reachDistance;
    private Memory handsMO;
    Thing closestFood;
    CreatureInnerSense cis;
    List<Thing> known;

    public EatClosestFood(int reachDistance) {
        setTimeStep(100);
        this.reachDistance = reachDistance;
    }

    @Override
    public void accessMemoryObjects() {
        closestFoodMO = (MemoryObject) this.getInput("CLOSEST_FOOD");
        innerSenseMO = (MemoryObject) this.getInput("INNER");
        handsMO = (MemoryObject) this.getOutput("HANDS");
        knownMO = (MemoryObject) this.getOutput("KNOWN_FOODS");
    }

    @Override
    public void proc() {
        String foodName = "";
        closestFood = (Thing) closestFoodMO.getI();
        cis = (CreatureInnerSense) innerSenseMO.getI();
        known = (List<Thing>) knownMO.getI();
        //Find distance between closest food and self
        //If closer than reachDistance, eat the food

        if (closestFood != null) {
            double foodX = 0;
            double foodY = 0;
            try {
                foodX = closestFood.getX1();
                foodY = closestFood.getY1();
                foodName = closestFood.getName();

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            double selfX = cis.position.getX();
            double selfY = cis.position.getY();

            Point2D pFood = new Point();
            pFood.setLocation(foodX, foodY);

            Point2D pSelf = new Point();
            pSelf.setLocation(selfX, selfY);

            double distance = pSelf.distance(pFood);
            JSONObject message = new JSONObject();
            try {
                if (distance < reachDistance + 20) { //eat it						
                    message.put("OBJECT", closestFood);
                    message.put("ACTION", "EATIT");
                    handsMO.setI(message.toString());
                    DestroyClosestApple();
                } else {
                    handsMO.setI("");	//nothing
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            handsMO.setI("");	//nothing
        }
    }

    @Override
    public void calculateActivation() {

    }

    public void DestroyClosestApple() {
        int r = -1;
        int i = 0;
        synchronized (known) {
            CopyOnWriteArrayList<Thing> myknown = new CopyOnWriteArrayList<>(known);
            for (Thing t : known) {
                if (closestFood != null) {
                    if (t.getName().equals(closestFood.getName())) {
                        r = i;
                    }
                }
                i++;
            }
            if (r != -1) known.remove(r);
            closestFood = null;
            
        }
    }

}
