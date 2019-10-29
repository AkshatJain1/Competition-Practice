import java.util.*;
import java.io.*;

public class Semmy {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("semmy.dat"));
        Map<Character, String> m = new HashMap();
        Map<String, Character> m1 = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String l = kb.nextLine();
            char k = l.charAt(0);
            String val = l.substring(1);
            m.put(k,val);
            m1.put(val, k);
        }
        m.put(' ', "#");
        m1.put("#",' ');

        int d = kb.nextInt(); kb.nextLine();
        for (int i = 0; i < d; i++) {
            String a =  "";
            String l = kb.nextLine();
            for (int i1 = 0; i1 < l.length(); i1++) {
                if(l.charAt(i1) == '#') {
                    a+=" ";
                }
                else {
                    String t = l.substring(i1, i1 + 2);
                    if (m1.get(t) == null) {

                        a += m1.get(l.substring(i1, i1 + 3)) + "";
                        i1++;
                    }
                    else
                        a += m1.get(t) + "";
                    i1++;
                }
            }
            System.out.println(a);
        }

        int d1 = kb.nextInt(); kb.nextLine();
        for (int i = 0; i < d1; i++) {
            String a =  "";
            String l = kb.nextLine();
            for (int i1 = 0; i1 < l.length(); i1++) {
               a+=m.get(l.charAt(i1));
            }
            System.out.println(a);
        }

    }
}