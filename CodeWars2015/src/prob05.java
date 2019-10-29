import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by respe on 9/21/2018.
 */
public class prob05 {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("prob05.txt"));

        int a = Integer.parseInt(kb.nextLine());
        int b = Integer.parseInt(kb.nextLine());
        int c = Integer.parseInt(kb.nextLine());

        System.out.println(a + " x (" + b + " + "+ c + ") = " + a + " x " + b + " + " + a + " x " + c);

        System.out.println(a + " x " + (b+c) + " = " + (a*b) + " + " + (a*c) );

        System.out.println(a*(b+c) + " = " + a*(b+c));

    }
}
