import java.util.Scanner;
import java.util.Random;

import java.io.File;

public class Duck {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("duck.dat"));

        int games = Integer.parseInt(kb.nextLine());
        long seed = Long.parseLong(kb.nextLine());
        Random r = new Random(seed);
        int level1 = 0, level2 = 0, level3 = 0, level4 = 0;
        for (int i = 0; i < games; i++) {
//            System.out.println(r.nextInt(10));
            int sum = r.nextInt(10) + r.nextInt(10) + r.nextInt(10) + r.nextInt(10) + r.nextInt(10) + 5;

            if(sum<=25)
                level1++;
            else if(sum <=30)
                level2++;
            else if(sum<=35)
                level3++;
            else
                level4++;
        }
        System.out.println("level1 = " + level1);
        System.out.println("level2 = " + level2);
        System.out.println("level3 = " + level3);
        System.out.println("level4 = " + level4);

    }
}
