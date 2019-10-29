import java.io.*;
import java.util.*;

public class prob12 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob12-1-in.txt"));
        int n = file.nextInt();
        int decimal = file.nextInt();
        double sign = 1;
        double pi = 3;
        for (int i = 2; i <= n * 2; i += 2) {
            pi += sign * (4.0 / i * (i + 1.0) * (i + 2.0));
            System.out.println(sign * (4.0 / i * (i + 1.0) * (i + 2.0)));
            sign = -sign;
        }
        System.out.println(pi);
    }
}