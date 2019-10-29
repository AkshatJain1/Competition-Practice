import java.io.File;
import java.util.Scanner;

public class prob03 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("prob03.txt"));
        int c = kb.nextInt(); kb.nextLine();
        int p = kb.nextInt();

        System.out.println(c*p);

    }
}
