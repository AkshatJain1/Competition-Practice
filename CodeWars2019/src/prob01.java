import java.io.File;
import java.util.Scanner;

public class prob01 {
    public static void main(String[] args) throws Exception{
        Scanner file = new Scanner(new File("prob01.txt"));
        String name = file.nextLine();
        System.out.print("While we seem to disagree on this issue, "+name+", I respect your opinion and look forward to further discussion!");
    }
}
