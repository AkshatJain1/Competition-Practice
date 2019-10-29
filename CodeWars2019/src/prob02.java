import java.io.File;
import java.util.Scanner;

public class prob02 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob02.txt"));
        double num1 = file.nextInt();
        double num2 = file.nextInt();
        double num3 = file.nextInt();
        boolean make = ((num2/num3) <= num1);
        System.out.print((int)num1 + " " + (int)num2 + " " + (int)num3 + ". I will ");
        if(make)
            System.out.print("make it!");
        else
            System.out.print("be late!");

    }
}
