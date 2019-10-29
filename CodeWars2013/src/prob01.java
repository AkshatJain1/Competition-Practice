import java.util.*;
import java.io.*;
public class prob01 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("prob01-set1-in.txt"));
        System.out.println(kb.nextInt()*8 - 95);
    }
}
