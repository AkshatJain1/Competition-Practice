import org.jetbrains.annotations.NotNull;

import javax.swing.text.Position;
import java.util.*;
import java.io.*;
public class ShapeRotation {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("shaperotation.dat"));
        while(kb.hasNextLine()) {
            String l = kb.nextLine();
            int wid = Integer.parseInt(l.substring(0,l.indexOf('x'))),
                    len = Integer.parseInt(l.substring(l.indexOf('x')+1, l.indexOf('x')+2)),
                    rot = Integer.parseInt(l.split(" - ")[1]);

            char[][] map = new char[len][wid];

            for (int i = 0; i < map.length; i++) {
                map[i] = kb.nextLine().toCharArray();
            }

            if(rot == 90)
                map = rotate90(map);
            else if(rot == 180)
                map = rotate180(map);
            else if(rot == 270){
                map = rotate180(map);
                map = rotate90(map);
            }


            for (int i = 0; i < map.length; i++) {
                for (int i1 = 0; i1 < map[0].length; i1++) {
                    System.out.print(map[i][i1] + "");
                }
                System.out.println();
            }
            System.out.println();

        }
    }
    public static char[][] rotate90(char[][] map) {
        char[][] nmap = new char[map[0].length][map.length];
        for (int i = 0; i < nmap.length; i++) {
            char[] nr = new char[nmap[0].length];
            for (int i1 = 0; i1 < map.length; i1++) {
                nr[map.length - 1 - i1] = map[i1][i];
            }

            nmap[i] = nr;
        }
        return nmap;
    }
    public static char[][] rotate180(char[][] map) {
        char[][] nmap = new char[map.length][map[0].length];
        for (int i = 0; i < nmap.length; i++) {
            nmap[i] = map[nmap.length - i - 1];
        }

        for (int i = 0; i < nmap.length; i++) {
            char[] nr = new char[nmap[0].length];
            for (int i1 = nmap[0].length - 1; i1 >= 0; i1--) {
                nr[nmap[0].length - 1-i1] = nmap[i][i1];
            }
            nmap[i] = nr;
        }
        return nmap;
    }
}