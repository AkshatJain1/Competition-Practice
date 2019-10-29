import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.io.File;

public class Odd {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("odd.dat"));

        int r = Integer.parseInt(kb.nextLine());

        for (int i = 0; i < r; i++) {
            String shoes = kb.nextLine();
            ArrayList<Character> alpha = new ArrayList<>();

            for (int i1 = 0; i1 < shoes.length(); i1++) {
                alpha.add(shoes.charAt(i1));
            }
            Collections.sort(alpha);
            for (Character character : alpha) {
                System.out.print(character);
            }
            System.out.println();
        }

    }
}
