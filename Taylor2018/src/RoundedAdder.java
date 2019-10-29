import java.util.*;
import java.io.*;
public class RoundedAdder {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("roundedadder.dat"));
        int dec = kb.nextInt(); kb.nextLine();
        double sum = 0;
        while(kb.hasNextLine()) {
            String num = String.format("%."+dec+"f",Double.parseDouble(kb.nextLine()));
            sum+=Double.parseDouble(num);
        }
        System.out.printf("%."+dec+"f", sum);

    }
}