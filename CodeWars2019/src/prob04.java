import java.io.*;
import java.util.*;

public class prob04 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob04.txt"));
        int inputCount = file.nextInt();
        for (int i = 0; i < inputCount; i++) {
            double rate = file.nextDouble();
            double amount = file.nextDouble();
            double pretaxPrice = amount / (1.0 + (rate / 100));
            double taxAmount = pretaxPrice * (rate / 100);
            System.out.printf("On your $%.2f purchase, the tax amount is $%.2f\n", amount, taxAmount);
        }
    }
}