import java.util.*;
import java.io.*;
public class FinalGrade {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("finalgrade.dat"));

        while(kb.hasNextLine()) {
            String[] s= kb.nextLine().split(", ");
            double first = Double.parseDouble(s[0]);
            double second = Double.parseDouble(s[1]);
            double third = Double.parseDouble(s[2]);

            double avg = (first+second+third)/3;

            System.out.printf("%.2f", (90-avg*0.75)*4);
            System.out.println();

        }
    }
}