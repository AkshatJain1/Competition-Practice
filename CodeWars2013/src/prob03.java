import java.util.*;
import java.io.*;
public class prob03 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("prob03-set1-in.txt"));
        String line = kb.nextLine();
        while(!line.equals("END 0 0 0")) {

            String[] d = line.split(" ");
            System.out.println("On " + d[2] + ", " + d[0] + " would weigh " + Double.parseDouble(d[1]) * Double.parseDouble(d[3])+" pounds.");

            line = kb.nextLine();
        }
    }
}
