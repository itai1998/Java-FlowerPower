import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Flower extends Plant {

    public Flower(int x, int y){
        // use super() to inherit the codes from Plant class
        super(x,y);

        // chang the img plant to random flowers' picture
        String[]  arr = {"flower0.png", "flower1.png","flower2.png","flower3.png"}; //Put 4 pictures in array
        Random rand = new Random();  // import Random method
        plant = new ImageIcon(arr[rand.nextInt(4)]); // ImageIcon(arr[0]) ~ ImageIcon(arr[3])

    }

}
