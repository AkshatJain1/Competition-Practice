import java.io.File;
import java.util.Scanner;

public class BeanTransformations {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("beantransformations.dat"));
        int sets = kb.nextInt(); kb.nextLine();
        for (int i = 0; i < sets; i++) {
            String bin = Long.toBinaryString(Long.parseLong(kb.nextLine()));
            int sig = 1, count = 0;
            for (int c = bin.length() - 1; c >= 0; c--) {
                int num = 0;
                if(c>=0 && bin.charAt(c--) == '1')
                    num++;
                if(c>=0 && bin.charAt(c--) == '1')
                    num++;
                if(c>=0 && bin.charAt(c--) == '1')
                    num++;
                if(c>=0 && bin.charAt(c) == '1')
                    num++;
                count+=sig*num;
                sig*=10;
            }
            System.out.println(Integer.parseInt(count+"",16));
        }
    }
}