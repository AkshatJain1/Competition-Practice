import java.util.Scanner;

import java.io.File;

public class Landscape {
    public static final int  ROWS = 10;
    public static final int COLS = 15;
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Judges/landscape.dat"));

        int r = Integer.parseInt(kb.nextLine());

        for (int i = 0; i < r; i++) {
            char[][] pic = new char[COLS][ROWS];
            for (int i1 = 0; i1 < ROWS; i1++) {
                char[] x = kb.nextLine().toCharArray();
                for (int i2 = 0; i2 < x.length; i2++) {
                    pic[COLS - 1 - i2][i1] = x[i2];
                }
            }

            for (int i1 = 0; i1 < pic.length; i1++) {
                for (int i2 = 0; i2 < pic[0].length; i2++) {
                    System.out.print(pic[i1][i2]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}