import java.util.*;
import java.io.*;
public class prob05 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("prob05-set1-in.txt"));
        while (kb.hasNextLine()) {
            int in = kb.nextInt(); kb.nextLine();
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(0);
            nums.add(1);
            nums.add(1);
            if(in==-1)
                break;
            else if(in == 0)
                System.out.println(0);
            else if(in == 1)
                System.out.println(1);
            else if(in == 2)
                System.out.println(1);
            else {
                int t = -1;
                for (int i = 3; i <= in; i++) {
                    t = nums.get(i-1) + nums.get(i-2) + nums.get(i-3);
                    nums.add(t);
                }
                System.out.println(t);
            }
        }
    }
}
