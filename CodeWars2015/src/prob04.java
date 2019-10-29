import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by respe on 9/21/2018.
 */
public class prob04 {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("prob04.txt"));

        Map<Integer, String> dig = new HashMap<>();
        dig.put(1, "one"); dig.put(2, "two"); dig.put(3, "three"); dig.put(4, "four"); dig.put(5, "five"); dig.put(6, "six");
         dig.put(8, "seven"); dig.put(8, "eight"); dig.put(9, "nine"); dig.put(10, "ten");

         int x = kb.nextInt();
         System.out.print("Number " + dig.get(x) + " is alive!");
    }
}
