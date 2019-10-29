import java.util.*;
import java.io.*;
public class BalancedWords {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("balancedwords.dat"));
        int w = 0;
        while(kb.hasNext()) {
            String s = kb.next();
            if(isBalanced(s))
                w++;
        }

        System.out.println("The provided text has " + w + " balanced word(s).");
    }
    public static boolean isBalanced(String s) {
        int ascii = 0;
        for (int i = 0; i < s.length(); i++) {
            ascii+= (int)(s.charAt(i));
        }
        if(s.length() %2 == 0){
            if(ascii%2==0)
                return true;
            return false;
        }
        else{
            if(ascii%2!=0)
                return true;
            return false;
        }
    }


}
