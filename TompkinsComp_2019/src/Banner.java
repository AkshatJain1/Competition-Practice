import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class Banner {
    public static void main (String [] args) throws IOException {
        Scanner scan = new Scanner (new File ("banner.test.in"));

        int numWords = Integer.parseInt(scan.nextLine());
        String msg = scan.nextLine().toUpperCase();
        scan.close();
        String [] words = msg.split(" ");
        int numRows = 0;
        for (int i = 0; i < words.length; i++) {
            numRows = Math.max(numRows, i + words[i].length());
        }
        ArrayList<String[]> ban = new ArrayList<String[]>();
        int sizeRow = 1;
        for (int i = 0; i < numRows; i++) {
            ban.add(new String[sizeRow]);
            sizeRow += 2;
        }

        int start = 0, rowInd = 0;
        while (start < words.length) {
            for (int i = start; i < start + words[start].length(); i++) {
                ban.get(i)[rowInd] = words[start].substring(i - start, i - start + 1);
                rowInd += 2;
            }
            rowInd = 0;
            start++;
        }


        for (int i = 0; i < ban.size(); i++)
            for (int j = 0; j < ban.get(i).length; j++) {
                if (ban.get(i)[j] == null) {
                    ban.get(i)[j] = " ";
                }
            }
        for (String [] a : ban) {
            for (String b : a)
                out.print(b);
            out.println();
        }
    }
}