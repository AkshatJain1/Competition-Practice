import java.io.File;
import java.util.Scanner;

public class Inflation {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("inflation.in"));
        kb.nextLine();
        while(kb.hasNextLine()) {
            float p;

            int c = kb.nextInt();
            double r = kb.nextDouble();

            int t = kb.nextInt();

            double n = kb.nextDouble();
            kb.nextLine();
            int assets = kb.nextInt(); kb.nextLine();
            int sum_ass  = 0;
            for (int i = assets; i > 0; i--) {
                    sum_ass+=Integer.parseInt(kb.nextLine());
            }

            p = (float)Math.sqrt(((c+sum_ass)*Math.pow(2-r,0.5)*Math.log10(t)/Math.pow(n,1.5)));
            System.out.println(p);

        }
    }
}
