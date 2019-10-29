import java.io.*;
import java.util.*;

public class prob14 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob14.txt"));
        int n1 = file.nextInt(); file.nextLine();
        int n2 = file.nextInt(); file.nextLine();
        int n3 = file.nextInt(); file.nextLine();
        System.out.print(n1+","+n2);
        int nCurr = n2;
        int nPrev = n1;
        int nTemp = 0;

        for(int x = 2;x<n3;x++)
        {
            System.out.print(",");
            nTemp = nCurr;
            nCurr = nCurr + nPrev;
            nPrev = nTemp;
            System.out.print(nCurr);
        }
    }
}