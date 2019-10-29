import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/*

PROG: ride
LANG: JAVA

 */
public class ride {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("ride.in"));
        String w1 = kb.nextLine(); String w2 = kb.nextLine();

        int calc = 0;
        int prod = 1;
        for(int x =0; x <w1.length(); x++){
            prod *= (w1.charAt(x)-'A' + 1);
        }
        prod%=47;

        int prod2 = 1;
        for(int x =0; x <w2.length(); x++){
            prod2 *= (w2.charAt(x)-'A' + 1);
        }
        prod2%=47;
        PrintWriter writer = new PrintWriter("ride.out", "UTF-8");


        if(prod==prod2){
            writer.println("GO");
        }
        else{
            writer.println("STAY");
        }

        writer.close();
    }
}
