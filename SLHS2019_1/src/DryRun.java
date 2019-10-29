import java.io.File;
import java.util.Scanner;

public class DryRun {
    public static void main(String[] args) throws Exception {
        Scanner k = new Scanner(new File("dryrun.in"));
        k.nextLine();
        while(k.hasNextLine()) {
            System.out.println("Glory to " + k.nextLine());
        }
    }
}
