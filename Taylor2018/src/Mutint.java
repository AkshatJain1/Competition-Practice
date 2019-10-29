import java.util.*;
import java.io.*;
public class Mutint {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("mutint.dat"));

        while(kb.hasNextLine()) {
            String num = kb.nextLine();
            int largestVal = Integer.MIN_VALUE; int largestDig = Integer.MIN_VALUE;
            for (int i = 0; i < num.length(); i++) {
                int score = num.length() - i;
                score += num.charAt(i) - '0';
                if(score>largestVal) {
                    largestVal = score;
                    largestDig = i;
                }
            }

            int dig = num.charAt(largestDig) - '0';

            if(dig%2!=0)
                dig = 0;
            else if(dig%2 == 0) {
                dig+=4;
                if(dig>9){
                    dig = (dig+"").charAt((dig+"").length()-1) - '0';
                }
            }

            System.out.println(Integer.parseInt(num.substring(0, largestDig) + dig + num.substring(largestDig+1)));
        }
    }
}