import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Plant {
    protected ImageIcon plant;
    protected Point pos;

    public Plant(int x,int y){
        plant = new ImageIcon("weed.png"); //store weed picture in var weed
        pos = new Point(x,y);  //pos.x and pos.y change base on my input (int x, int y)


    }

    //place plant on the window
    public void draw(Graphics g){
        plant.paintIcon(null,g,pos.x+10,pos.y+400);
    }

}
