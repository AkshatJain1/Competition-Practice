import java.io.File;
import java.util.Scanner;

public class prob07 {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("prob07.txt"));

        double p = Double.parseDouble(kb.nextLine());

        while(p!=0) {
            System.out.println(Math.pow(p,2.0/3.0));

            p = Double.parseDouble(kb.nextLine());
        }

    }
}