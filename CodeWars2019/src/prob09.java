import java.io.*;
import java.util.*;

public class prob09 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob09.txt"));
        String choice1 = file.next();
        String choice2 = file.next();
        if(choice1.equals(choice2))
            System.out.println("TIE, "+choice1.toUpperCase()+" does not affect "+choice2.toUpperCase());
        if(choice1.equals("Scissors"))
        {
            if(choice2.equals("Lizard"))
                System.out.println("SCISSORS WINS, Scissors decapitates Lizard");
            else if(choice2.equals("Paper"))
                System.out.println("SCISSORS WINS, Scissors cuts Paper");
            else if(choice2.equals("Rock"))
                System.out.println("SCISSORS LOSES, Rock crushes Scissors");
            else if(choice2.equals("Spock"))
                System.out.println("SCISSORS LOSES, Spock smashes Scissors");
        }
        else if(choice1.equals("Lizard"))
        {
            if(choice2.equals("Scissors"))
                System.out.println("LIZARD LOSES, Scissors decapitates Lizard");
            else if(choice2.equals("Paper"))
                System.out.println("LIZARD WINS, Lizard eats Paper");
            else if(choice2.equals("Rock"))
                System.out.println("LIZARD LOSES, Rock crushes Lizard");
            else if(choice2.equals("Spock"))
                System.out.println("LIZARD WINS, Lizard poisons Spock");
        }
        else if(choice1.equals("Spock"))
        {
            if(choice2.equals("Scissors"))
                System.out.println("SPOCK WINS, Spock smashes Scissors");
            else if(choice2.equals("Paper"))
                System.out.println("SPOCK LOSES, Paper disproves Spock");
            else if(choice2.equals("Rock"))
                System.out.println("SPOCK WINS, Spock vaporizes Rock");
            else if(choice2.equals("Lizard"))
                System.out.println("SPOCK LOSES, Lizard poisons Spock");
        }
        else if(choice1.equals("Paper"))
        {
            if(choice2.equals("Scissors"))
                System.out.println("PAPER LOSES, Scissors cuts Paper");
            else if(choice2.equals("Spock"))
                System.out.println("PAPER WINS, Paper disproves Spock");
            else if(choice2.equals("Rock"))
                System.out.println("PAPER WINS, Paper covers Rock");
            else if(choice2.equals("Lizard"))
                System.out.println("PAPER LOSES, Lizard eats Paper");
        }
        else if(choice1.equals("Rock"))
        {
            if(choice2.equals("Scissors"))
                System.out.println("ROCK WINS, Rock crushes Scissors");
            else if(choice2.equals("Spock"))
                System.out.println("ROCK LOSES, Spock vaporizes Rock");
            else if(choice2.equals("Paper"))
                System.out.println("ROCK LOSES, Paper covers Rock");
            else if(choice2.equals("Lizard"))
                System.out.println("ROCK WINS, Rock crushes Lizard");
        }
    }
}