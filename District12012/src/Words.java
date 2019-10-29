import java.util.Scanner;

import java.io.File;

public class Words {

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Judges/words.dat"));

        int r = Integer.parseInt(kb.nextLine());

        for (int i = 0; i < r; i++) {
            String[] name = kb.nextLine().split("\\s+");
            System.out.print(name[0] + " ");
            for (int i1 = 1; i1 < name.length; i1++) {
                System.out.print(name[i1].charAt(0) +" ");
            }
            System.out.println();
        }
    }
}