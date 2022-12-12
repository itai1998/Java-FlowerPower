// I Tai Lin
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FlowerPower extends JPanel implements KeyListener {

    Garden myGarden;
    MathProblem test;
    int score = 0;
    String name;

    public static int MAIN_LOOP = 100;
    public static int ENDGAME = 200;
    public static int CURRENT = MAIN_LOOP;


    public FlowerPower() {
        myGarden = new Garden();
        test = new MathProblem();
        addKeyListener(this);

        //Ask players name
        name=JOptionPane.showInputDialog("What is your name?");

    }

    @Override
    public void paintComponent(Graphics g) {
        requestFocusInWindow();

        //draw the sky
        g.setColor(Color.BLUE);
        var w = getWidth();
        var h = getHeight();
        g.fillRect(0,0,w,h);

        //draw the sun
        g.setColor(Color.YELLOW);
        g.fillOval(-50,-50,135,135);

        //draw the grass
        g.setColor(Color.GREEN);
        g.fillRect(0,400,w,h);

        //Plant the flowers and weeds
        myGarden.draw(g);

        //display the score
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(3));
        g.drawString("The Score is: "+score,90,30);

        //display the name
        g.drawString("Name: "+ name,650,30);

        //draw the math problem on the window
        if(CURRENT==MAIN_LOOP){
            test.draw(g);
        }

        //Ask if player wants to play again or not by pressing "y" or "n"
        else{
            g.drawString("Game over! Do you want to play again?",320,300);
        }

    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,600);
        window.setContentPane(new FlowerPower());
        window.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {

        int math = test.receiveInput(e);
        //if the answer is correct, draw the flower.
        //Score + 10
        if (math == Garden.FLOWER){
            myGarden.newFlower();
            score+=10;
            if (CURRENT==MAIN_LOOP) {
                test = new MathProblem();  //Ask new question
            }
        }

        // if the answer is incorrect, draw the weed.
        //Score - 5
        else if (math == Garden.WEED){
            myGarden.newWeed();
            score -=5;
            if (CURRENT == MAIN_LOOP) {
                test = new MathProblem(); //Ask new question
            }
        }

        //Ask if player wants to play again or not
        // Pressing "y" play again and pressing "n" end the game
        if(CURRENT == ENDGAME){
            char k = e.getKeyChar();
            //if player press "y", restart the game
            if (k =='y'){
                myGarden.clear();
                CURRENT=MAIN_LOOP;
                score=0;
            }
            // if player press "n", end the game
            else if(k == 'n'){
                System.exit(0);
            }

        }


        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

