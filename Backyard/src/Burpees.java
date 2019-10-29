import java.util.Scanner;

import java.io.File;

public class Burpees {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("burpees.dat"));

        int r = Integer.parseInt(kb.nextLine());

        for (int i = 0; i < r; i++) {
            int days = Integer.parseInt(kb.nextLine());
            System.out.println(burp(days));
        }

    }
    public static int burp(int days){
        if(days == 0)
            return 0;
        return days + burp(days-1);
    }
}
