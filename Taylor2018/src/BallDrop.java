import java.util.*;
import java.io.*;
public class BallDrop {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("balldrop.dat"));
        while (kb.hasNextLine()){
            double i = Double.parseDouble(kb.nextLine());
            System.out.printf("%.2f second(s)",Math.sqrt(2*i/9.8));
            System.out.println();
        }
    }
}