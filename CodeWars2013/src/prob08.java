import java.util.*;
import java.io.*;
public class prob08 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("prob08-set1-in.txt"));
        String w  = kb.nextLine();
        while(!w.equals(".")) {
            String letters = "";
            boolean good = true;
            for (int i = 0; i < w.length(); i++) {
                if(!letters.contains(w.charAt(i)+""))
                    letters+=w.charAt(i)+"";
                else {
                    good = false;
                    break;
                }
            }
            if(good)
                System.out.println(w + " USES DISTINCT LETTERS");
            else
                System.out.println(w + " DOES NOT USES DISTINCT LETTERS");
            w = kb.nextLine();
        }
    }
}
