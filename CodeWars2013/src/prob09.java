import java.util.*;
import java.io.*;
public class prob09 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("prob09-set1-in.txt"));
        int n = Integer.parseInt(kb.nextLine());
        while(n!=-1) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                String num = String.valueOf(i);
                for (int i1 = 0; i1 < num.length(); i1++) {
                    if(num.charAt(i1) == '1')
                        count++;
                }
            }
            System.out.println(count);

            n = Integer.parseInt(kb.nextLine());
        }
    }
}
