import java.io.File;
import java.util.Scanner;

public class prob06 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob06.txt"));
        int n = file.nextInt();
        System.out.println((int )(4 * (n / 2.0 * (n - 1))));
    }
}