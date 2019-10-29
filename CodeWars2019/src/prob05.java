import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class prob05 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob05.txt"));
        int height = file.nextInt();
        BigInteger cubes = BigInteger.ZERO;
        for (long i = 0; i <= height; i++) {
            cubes = cubes.add(BigInteger.valueOf(i * i));
        }
        System.out.println(cubes);
    }
}
