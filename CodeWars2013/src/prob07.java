import java.util.*;
import java.io.*;
public class prob07 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("prob07-set1-in.txt"));
        int min = Integer.parseInt(kb.nextLine());
        while(true){
            if(min == -1)
                break;
            double t = min/5.0;
            int hours = (int)(Math.floor(12-t));
            System.out.printf("%d:%02d",hours,min);
            System.out.println();

            min = Integer.parseInt(kb.nextLine());
        }
    }
}
