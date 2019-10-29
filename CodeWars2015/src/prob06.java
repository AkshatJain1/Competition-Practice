import java.io.File;
import java.util.Scanner;

public class prob06 {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("prob06.txt"));

        double a = Integer.parseInt(kb.nextLine())/3.0;
        double b = Integer.parseInt(kb.nextLine())/3.0;
        double c = Integer.parseInt(kb.nextLine())/3.0;
        System.out.println((int)Math.ceil(a*b*c));

    }
}
