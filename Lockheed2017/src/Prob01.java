import java.io.File;
import java.util.Scanner;

/**
 * Created by respe on 9/18/2018.
 */
public class Prob01 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("Prob01.txt"));

        int runs = kb.nextInt(); kb.nextLine();

        for(int y= 0; y<runs; y++){
            String x = kb.nextLine();
            System.out.println(x);
            System.out.println(x);

        }
    }
}
