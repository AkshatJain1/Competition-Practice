import java.io.*;
import java.util.*;

public class Bridge {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("bridge.dat"));

        Map<String, String> m = new HashMap();
        for (int x = 0; x<50; x++) {
            String l = kb.nextLine();
            int inQ = -1;
            for (int i = 0; i < l.length(); i++) {
                if(l.charAt(i) == '?')
                    inQ = i;
            }
            String q = l.substring(0, inQ+1);
            String a = l.substring(inQ+2);
            m.put(q,a);
        }

        int x = Integer.parseInt(kb.nextLine());
        for (int i = 0; i < x; i++) {
            boolean hasAnswer = true;
            for (int i1 = 0; i1<3; i1++) {
                String q = kb.nextLine();
                if (m.get(q) == null) {
                    hasAnswer = false;
                    System.out.println("Sir Robin gets thrust into the pit.");
                }
                else if(hasAnswer){
                    System.out.println(m.get(q)+".");
                }
            }
            if(hasAnswer){
                System.out.println("Sir Robin can cross the bridge.");
            }
            System.out.println();
        }
    }
}
