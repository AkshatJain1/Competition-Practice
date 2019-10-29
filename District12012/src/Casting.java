import java.util.Scanner;

import java.io.File;

public class Casting {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("Judges/casting.dat"));

        int r = Integer.parseInt(kb.nextLine());

        for (int c = 0; c < r; c++) {
            String num = (kb.nextLine());
            System.out.println(cast(num,0));
        }
    }
    public static long cast (String n, int times){
        if(n.length()==1)
            return times;

        int sum  = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i)-'0';
        }
        return cast(sum+"", ++times);
    }
}
