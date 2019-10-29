import java.io.File;
import java.util.Scanner;

public class Location {
    public static void main(String[] args) throws Exception{
        Scanner file = new Scanner(new File("location.in"));
        file.nextLine();
        String s = "";
        while(file.hasNextLine()) {
            String[] sentence = file.nextLine().split("\\s+");
            s += (sentence[0] + " " + sentence[sentence.length - 1] + " ");
        }
        System.out.print(s.substring(0,s.length()-1)+".");
    }
}
