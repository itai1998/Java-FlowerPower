import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class MathProblem {
    private int num1;
    private int num2;
    private int answer;
    private String op1;
    private String userInput;
    private int userInputInt = 0;

    MathProblem(){

        //userInput is empty in the beginning
        userInput = "";

        //create random numbers from 0 ~ 12 (13 numbers total)
        num1 = (int)(Math.random()*13);
        num2 = (int)(Math.random()*13);

        //create random operator
        String[] op = {"+","-","*","/"};
        op1 = op[(int)(Math.random()*4)]; // op[0] ~ op[3]

        // var answer will have different result according to the operator
        if(op1.equals(op[0])){
            answer = num1 + num2;

        }

        else if(op1.equals(op[1]) && (num1>=num2)){
            answer = num1 - num2;

        }

        else if(op1.equals(op[2])){
            answer = num1 * num2;
            op1 = "\u00D7";

        }

        else if(op1.equals(op[3]) && num2 !=0){
            answer = num1 / num2;
            op1 = "\u00F7";

        }

        // if num2 > num1 in "-" operator or num2 = 0 in "/" operator
        // change the operator to be "+"  and make num1 + num2

        else {
            op1 = "+";
            answer = num1 + num2;

        }

        //check my answer in terminal
        //System.out.println(num1 + " "+ op1 + " " + num2 + " = " + answer);

    }

    public int receiveInput(KeyEvent ke){
        // if the String input are number between 0 to 9
        // Then convert the Strings to int
        char k = ke.getKeyChar();
        if (userInput.length() < 3){    // Extra credit: the input can only allow 3 characters long
            if( k>='0' && k<= '9'  ) {
                userInput += k;
                userInputInt = Integer.parseInt(userInput);
            }

        }

        // Delete the last number of my input
        if (k == KeyEvent.VK_DELETE || k == KeyEvent.VK_BACK_SPACE){
            if (userInput.length() != 0 ) {
                userInput = userInput.substring(0, userInput.length() - 1);
            }

        }

        // if I press Enter key, compare my input with the correct answer
        if ( k == KeyEvent.VK_ENTER){
            if (userInputInt == answer){
                return Garden.FLOWER;
            } else {
                return Garden.WEED;
            }

        }
        return Garden.CONTINUE;

    }



    public void draw(Graphics g){

        //draw the math question on the window
        g.setColor(Color.WHITE);
        g.drawString(num1 + " "+ op1 + " " + num2 + " = " + userInput,390,300);

    }

}
