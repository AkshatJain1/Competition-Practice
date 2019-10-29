import java.util.*;
import java.io.*;
public class prob04 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("prob04-set1-in.txt"));
        double v = kb.nextDouble(); kb.nextLine();
        double angle = kb.nextDouble(); kb.nextLine();
        System.out.println(Math.pow(v,2) * Math.sin(2*Math.toRadians(angle))/9.80665);
    }
}
