import java.util.Scanner;

import java.io.File;

public class Decreasing {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Judges/decreasing.dat"));

        int r = Integer.parseInt(kb.nextLine());

        for (int c = 0; c < r; c++) {
            int x = kb.nextInt(); kb.nextLine();
            int origNum = x;
            int mult = 2;
            boolean increasing = true;
            while(increasing){

                x = origNum * mult;
                String num = x+"";
                if(num.length()==1)
                    increasing = false;
                else{
                    increasing = false;
                    for (int i = 0; i < num.length()-1; i++) {
                        if(num.charAt(i+1) > num.charAt(i)) {
                            increasing = true;
                            break;
                        }
                    }
                }
                mult++;
            }
            System.out.println(x);
        }
    }
}