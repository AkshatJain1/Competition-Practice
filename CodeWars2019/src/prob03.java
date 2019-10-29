import java.io.*;
import java.util.*;

public class prob03 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob03.txt"));
        double l = file.nextInt();
        double area = (l*l*3.14159*3)/4;
        System.out.printf("%.2f",area);
    }
}