import java.util.*;
import java.io.*;
public class Rhonda {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("rhonda.dat"));

        int sets = kb.nextInt(); kb.nextLine();
        ArrayList<char[][]> maps = new ArrayList<char[][]>();

        for (int i = 0; i < sets; i++) {
            char[][] m = new char[10][10];
            for (int i1 = 0; i1 < m.length; i1++) {
                m[i1] = kb.nextLine().toCharArray();
            }
            maps.add(m);
            kb.nextLine();
        }

        while(kb.hasNextLine()) {
            String[] l = kb.nextLine().split(" ");
            int[][] m = new int[10][10];
            for (int i = 0; i < m.length; i++) {
                for (int i1 = 0; i1 < m[0].length; i1++) {
                    int val = 0;

                    for (int x = 0; x < l.length; x++) {
                        val += maps.get(Integer.parseInt(l[x]))[i][i1]-'0';
                    }

                    m[i][i1] = val;
                }
            }

            for (int i = 0; i < m.length; i++) {
                for (int i1 = 0; i1 < m[0].length; i1++) {
                    System.out.printf("%02d ", m[i][i1]);
                }
                System.out.println();
            }
            System.out.println();
        }


    }
}