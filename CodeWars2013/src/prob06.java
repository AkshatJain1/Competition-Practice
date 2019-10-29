import java.util.*;
import java.io.*;
public class prob06 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("prob06-set1-in.txt"));
        while (kb.hasNextLine()){
            double x1 = kb.nextDouble(), y1 = kb.nextDouble(), x2 = kb.nextDouble(), y2 = kb.nextDouble(), x3 = kb.nextDouble(), y3 = kb.nextDouble();
            if(x1==0 && x2==0 && y1==0 && y2==0 && x3==0 && y3 == 0)
                break;
            double a = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2)), b = Math.sqrt(Math.pow(x2-x3,2) + Math.pow(y2-y3,2)), c = Math.sqrt(Math.pow(x3-x1,2) + Math.pow(y3-y1,2));
            double angle = Math.acos((Math.pow(a,2) + Math.pow(b,2) - Math.pow(c,2))/(2*a*b));
            System.out.println(a*b*Math.sin(angle)/2);

        }

    }
}
