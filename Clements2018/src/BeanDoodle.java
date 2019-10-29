import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class BeanDoodle {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("beandoodle.dat"));
        int sets = kb.nextInt();
        kb.nextLine();
        for (int i = 0; i < sets; i++) {
            int num = Integer.parseInt(kb.nextLine());
            char[][] map;
            if(num%2==0)
                 map = new char[num*num+1][num*num+1];
            else
                map = new char[num*num][num*num];
            //put it all on outside
            //move row and column in one to fill up
            int curr_ring = 1;
            int row_off = 0;
            int col_off = 0;
            while(curr_ring!=num+1) {
                for (int r = row_off; r < map.length-row_off; r++) {
                    map[r][0+col_off] = '#';
                    map[r][map[0].length-col_off-1] = '#';
                }
                for (int c = col_off; c < map[0].length-col_off; c++) {
                    map[0+row_off][c] = '#';
                    map[map.length-row_off-1][c] = '#';
                }
                row_off+=2;
                col_off+=2;
                curr_ring++;
            }
            for (char[] chars : map) {
                for (int i1 = 0; i1 < chars.length; i1++) {
                    System.out.print(chars[i1]=='#'?"#":" ");
                }
                System.out.println();
            }
            if(kb.hasNextLine())
                System.out.println();
        }
    }
}