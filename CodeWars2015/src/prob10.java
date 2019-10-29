import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by respe on 9/21/2018.
 */
public class prob10 {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("prob10-2-in.txt"));

        int lines = kb.nextInt(); kb.nextLine();

        while(kb.hasNextLine()){
            String w = kb.nextLine();
            String[] letters = w.split(" ");
            String nw = "";

            for (int i = 1; i < letters.length; i++) {
                nw+=convert(letters[i]);
            }
            System.out.println(nw);
        }
    }
    public static String convert(String letter){
        Map<String, String> a = new HashMap<>();
        a.put("81", "a"); a.put("82", "b"); a.put("83", "c"); a.put("84", "d"); a.put("85", "e"); a.put("86", "f");
        a.put("87", "g"); a.put("88", "h"); a.put("89", "i"); a.put("91", "j"); a.put("92", "k"); a.put("93", "l"); a.put("94", "m");
        a.put("95", "n"); a.put("96", "o"); a.put("97", "p"); a.put("98", "q"); a.put("99", "r"); a.put("A2", "s"); a.put("A3", "t");
        a.put("A4", "u"); a.put("A5", "v"); a.put("A6", "w"); a.put("A7", "x"); a.put("A8", "y"); a.put("A9", "z");
        a.put("C1", "A");a.put("C2", "B"); a.put("C3", "C"); a.put("C4", "D"); a.put("C5", "E"); a.put("C6", "F"); a.put("C7", "G"); a.put("C8", "H");
        a.put("C9", "I");  a.put("D1", "J");a.put("D2", "K"); a.put("D3", "L"); a.put("D4", "M"); a.put("D5", "N"); a.put("D6", "O"); a.put("D7", "P"); a.put("D8", "Q");
        a.put("D9", "R");a.put("E2", "S");a.put("E3", "T"); a.put("E4", "U"); a.put("E5", "V"); a.put("E6", "W"); a.put("E7", "X"); a.put("E8", "Y");
        a.put("E9", "Z"); a.put("40", " "); a.put("4B", "."); a.put("6B", ","); a.put("5A", "!");


        return a.get(letter);

    }
}
