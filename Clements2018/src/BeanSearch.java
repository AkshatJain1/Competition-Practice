import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class BeanSearch {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("beansearch.dat"));
        int sets = kb.nextInt();
        for (int i = 0; i < sets; i++) {
            int rows = kb.nextInt();
            int cols = Integer.parseInt(kb.nextLine().substring(1));
            char[][] m = new char[rows][cols];
            for (int i1 = 0; i1 < rows; i1++) {
                m[i1] = kb.nextLine().toCharArray();
            }
            for (char[] chars : m) {
                System.out.println(Arrays.toString(chars));
            }
            int num = kb.nextInt(); kb.nextLine();
            String[] words = new String[num];
            for (int i1 = 0; i1 < num; i1++) {
                words[i1] = kb.nextLine();
            }
            for (int i1 = 0; i1 < words.length; i1++) {
                System.out.println(found(words[i1],m)?"FOUND":"NOT FOUND");
            }
        }
    }
    public static boolean found(String word, char[][] map) {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if(horizontalFor(map, r,c,word))
                    return true;
                if(verticalDown(map, r,c,word))
                    return true;
                if(diagRight(map, r,c,word))
                    return true;
                if(diagLeft(map, r,c,word))
                    return true;
            }
        }
        return false;
    }
    public static boolean horizontalFor(char[][] map, int r, int c, String word) {
        String str = "";
        for (int i = c; i < map[0].length && (i-c)<word.length(); i++) {
            if(map[r][i] != word.charAt(i-c)) {
                return false;
            }
            else{
                str+=map[r][i]+"";
            }
        }
        return str.equals(word);
    }

    public static boolean verticalDown(char[][] map, int r, int c, String word) {
        String str = "";
        for (int i = r; i < map.length && (i-r) < word.length(); i++) {
            if(map[i][c] != word.charAt(i-r)) {
                return false;
            }
            else{
                str+=map[i][c]+"";
            }
        }
        return str.equals(word);
    }

    public static boolean diagRight(char[][] map, int r, int c, String word) {
        String str = "";
        for (int i = r; i-r+c < map[0].length && i < map.length && (i-r) < word.length(); i++) {
            if(map[i][i-r+c] != word.charAt(i-r)) {
                return false;
            }
            else{
                str+=map[i][(i-r)+c]+"";
            }
        }
        return str.equals(word);
    }
    public static boolean diagLeft(char[][] map, int r, int c, String word) {
        String str = "";
        for (int i = r; c-(i-r) >= 0 && i < map.length && (i-r) < word.length(); i++) {
            if(map[i][c-(i-r)] != word.charAt(i-r)) {
                return false;
            }
            else{
                str+=map[i][c-(i-r)]+"";
            }
        }
        return str.equals(word);
    }
}
