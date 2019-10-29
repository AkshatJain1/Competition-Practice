import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HIckory {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Example/hickory.dat"));
        boolean run = true;

        while(kb.hasNextLine()){
            String x = kb.nextLine();
            if(run)
                System.out.println(x);
            run=!run;
        }

    }
}