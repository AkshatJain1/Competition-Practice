import java.io.*;
import java.util.*;

public class prob17 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob17.txt"));
        String line = file.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : line.toCharArray())
        {
            map.merge(c, 1, Integer::sum);
        }
        TreeSet<Character> tenPlus = new TreeSet<>();
        List<Character> minusTen = new ArrayList<>();
        for (char c : map.keySet())
        {
            if (map.get(c) >= 10)
            {
                tenPlus.add(c);
            }
            else
            {
                minusTen.add(c);
            }
        }
        Collections.sort(minusTen);
        Collections.reverse(minusTen);
        for (char c : minusTen)
        {
            char a = (c == ' ') ? '_' : c;
            System.out.printf("%c[%d]",a, map.get(c));
        }
        System.out.print(";");
        for (char c : tenPlus)
        {
            char a = (c == ' ') ? '_' : c;
            System.out.printf("%c[%d]",a, map.get(c));
        }
    }
}