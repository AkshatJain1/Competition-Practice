import java.util.Scanner;

import java.io.File;

public class Multiplication {

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Judges/multiplication.dat"));

        int r = Integer.parseInt(kb.nextLine());

        for (int i = 0; i < r; i++) {
            long first = kb.nextLong(); String sec = kb.nextLine().substring(1);

            for (int i1 = sec.length() -1; i1 >= 0; i1--) {
                System.out.print(first*(sec.charAt(i1) - '0')+" ");
            }
            long m = first*Long.parseLong(sec);
            System.out.println(m);
        }
    }
}