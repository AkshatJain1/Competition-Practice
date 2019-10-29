import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class prob07 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob07.txt"));
        while (file.hasNextInt())
        {
            int n = file.nextInt();
            int m = file.nextInt();
            if (n == 0 && m == 0)
            {
                break;
            }

            switch (m)
            {
                case 0:
                    if (n % 2 == 0)
                    {
                        System.out.println(n + 2);
                    }
                    else
                    {
                        System.out.println(n + 1);
                    }
                    break;
                case 1:
                    BigInteger arst = BigInteger.valueOf(n);
                    System.out.println(arst.nextProbablePrime().intValueExact());
                    break;
                case 2:
                    System.out.println((int) Math.pow((int) (Math.sqrt(n)) + 1, 2));
                    break;
                case 3:
                    System.out.println((int) Math.pow((int) (Math.cbrt(n) + 1), 3));
                    break;

            }
        }
    }
}