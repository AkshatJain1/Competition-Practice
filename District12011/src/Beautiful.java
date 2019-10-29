import java.io.File;
import java.util.Scanner;

public class Beautiful {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Example/beautiful.dat"));
        
        int r = kb.nextInt(); kb.nextLine();
        double sum = 0;
        for (int i = 0; i < r; i++) {
            kb.next(); double money = kb.nextDouble(); kb.nextLine();
            sum+=money;
        }
        System.out.printf("$%.2f",sum);
    }
}
