import java.util.*;
import java.io.*;
public class Comp {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("comp.dat"));
        while(kb.hasNextLine()) {
            String l = kb.nextLine();
            printBin(Integer.parseInt(l.split(" ")[0]), Integer.parseInt(l.split(" ")[1]));
        }
    }
    public static void printBin(int num1, int num2) {
        System.out.print(num1 + " = " );
        System.out.printf("%08d",Integer.parseInt(Integer.toBinaryString(num1)));
        System.out.println();

        System.out.print(num2 + " = " );
        System.out.printf("%08d", Integer.parseInt(Integer.toBinaryString(num2)));
        System.out.println();

        System.out.print(-num1 + " = " );
        String negNum1 = Integer.toBinaryString(-num1);
        System.out.print(negNum1.substring(negNum1.length()-8,negNum1.length()));
        System.out.println();

        System.out.print(-num2 + " = " );
        String negNum2 = Integer.toBinaryString(-num2);
        System.out.print(negNum2.substring(negNum2.length()-8,negNum2.length()));
        System.out.println();

        int m = num1-num2;
        if(m >= 0) {
            System.out.print(m + " = " );
            System.out.printf("%08d",Integer.parseInt(Integer.toBinaryString(m)));
            System.out.println();
        }
        else{
            System.out.print(m + " = " );
            String negNumm = Integer.toBinaryString(m);
            System.out.print(negNumm.substring(negNumm.length()-8,negNumm.length()));
            System.out.println();
        }


        System.out.println();

    }
}