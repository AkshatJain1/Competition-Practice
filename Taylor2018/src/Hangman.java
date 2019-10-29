import java.util.*;
import java.io.*;
public class Hangman {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("hang.dat"));

        while(kb.hasNextLine()) {
            String word = kb.next();
            kb.next();
            String[] guesses = (kb.nextLine()).split(" ");
            int wrong = 0;
            for (int i = 0; i < guesses.length; i++) {
                if(!word.contains(guesses[i]))
                    wrong ++;
            }
            System.out.println(word);
            switch (wrong) {
                case 0 :
                    System.out.println("SAFE");
                    System.out.println();
                    break;
                case 1 :
                    System.out.println("  O");
                    System.out.println();
                    break;
                case 2 :
                    System.out.println("  O");
                    System.out.println("+");
                    System.out.println();
                    break;
                case 3 :
                    System.out.println("  O");
                    System.out.println("+=");
                    System.out.println();
                    break;
                case 4 :
                    System.out.println("  O");
                    System.out.println("+=|");
                    System.out.println();
                    break;
                case 5 :
                    System.out.println("  O");
                    System.out.println("+=|=");
                    System.out.println();
                    break;
                case 6 :
                    System.out.println("  O");
                    System.out.println("+=|=+");
                    System.out.println();
                    break;
                case 7 :
                    System.out.println("  O");
                    System.out.println("+=|=+");
                    System.out.println("  |");
                    System.out.println();
                    break;
                case 8 :
                    System.out.println("  O");
                    System.out.println("+=|=+");
                    System.out.println("  |");
                    System.out.println(" /");
                    System.out.println();
                    break;
                default :
                    System.out.println("  O");
                    System.out.println("+=|=+");
                    System.out.println("  |");
                    System.out.println(" / \\");
                    System.out.println();
                    break;
            }
        }
    }
}