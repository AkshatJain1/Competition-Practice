import java.util.Scanner;

import java.io.File;

public class Backyard {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("backyard.dat"));

        int r = Integer.parseInt(kb.nextLine());

        for (int i = 0; i < r; i++) {
            int fence_len = Integer.parseInt(kb.nextLine());
            int numBoards = (int)(Math.ceil(fence_len/3.0));
            int numPickets = (int)(Math.floor((fence_len*12)/(1.75+.125)) + Math.ceil(fence_len/10.0));
            System.out.println(numBoards+" " + numPickets);
        }

    }
}
