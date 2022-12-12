import java.awt.*;
import java.util.ArrayList;

public class Garden {
    public static final int CONTINUE = 0;
    public static final int FLOWER = 1;
    public static final int WEED = 2;


    private ArrayList<Plant> plants;
    private int x;
    private int y;


    //place the flowers and weeds on the right position
    //there is no plants in the beginning
    public Garden(){
        plants = new ArrayList<>();
        x = 0;
        y = 0;

    }

    // Plant the flower in the right position by adding it to ArrayList plans
    public void newFlower(){
        if(plants.size() <16) {
            plants.add(new Flower(x, y));
            x += 48;
            y += 30;
            if (y == 60) {
                y = 0;
            }
        }
        //stop adding the flower if there are 16 plants
        if (plants.size()==16){
            FlowerPower.CURRENT = 200;
        }


    }

    // Plant the weed in the right position by adding it to ArrayList plans
    public void newWeed(){
        if(plants.size()<16) {

            plants.add(new Weed(x, y));
            x += 48;
            y += 30;
            if (y == 60) {
                y = 0;
            }
        }

        //stop adding the weed if there are 16 plants
        if (plants.size()==16){
            FlowerPower.CURRENT = 200;
        }

    }

    //Clear the Garden
    public void clear(){
        plants.clear();
        x=0;
        y=0;
    }

    //show the flowers and weeds on the window
    public void draw(Graphics g) {
        for (var s: plants ){
            s.draw(g);
        }
    }
}
