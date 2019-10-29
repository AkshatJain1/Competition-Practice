import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*

PROG: beads
LANG: JAVA

 */
public class beads {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("beads.in"));
//        PrintWriter writer = new PrintWriter("friday.out", "UTF-8");
        int num = kb.nextInt(); kb.nextLine();
        String beads = kb.nextLine();

        beads+=beads;

        int num_br = 0;
        int num_bl = 0;

        int start = num-1;

        while(beads.charAt(start) == beads.charAt(start+1) || beads.charAt(start+1) == 'w') {
            start--;
        }
        System.out.println(start);
        for(int x = start; x >= 1; x-- ) {
            char b = beads.charAt(x);
            if(b == beads.charAt(x-1) || beads.charAt(x-1) == 'w' || b == 'w') {
                num_bl++;
            }
        }
        System.out.println(num_bl);

//        writer.close();
    }
}
