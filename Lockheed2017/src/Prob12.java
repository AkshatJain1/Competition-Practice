import java.io.File;
import java.util.Scanner;

/**
 * Created by respe on 9/18/2018.
 */
public class Prob12 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("JudgingInputs/Prob12.in.txt"));

        int runs = kb.nextInt(); kb.nextLine();

        for(int y= 0; y<runs; y++) {
            int days = kb.nextInt(); kb.nextLine();
            double balance = 0;
            double totalBalance = 0;
            for(int x = 0; x < days; x++){
                String line = kb.nextLine()+" ";
                double purchases, payments;
                String[] lspaced = line.split(",");

                if(lspaced[1].isEmpty() || lspaced[1].equals(" ")){
                    lspaced[1] = "0";
                }
                if(lspaced[2].isEmpty() || lspaced[2].equals(" ")){
                    lspaced[2] = "0";
                }
                purchases = Double.parseDouble(lspaced[1]);
                payments = Double.parseDouble(lspaced[2]);

                balance += purchases - payments;
                totalBalance+=balance;
            }
            double calc = (totalBalance/days) * (0.18/12);

            String cost = "$"+Math.round(calc*100.0)/100.0;
            if(cost.substring(cost.indexOf("."),cost.length()).length() == 1){
                cost+="00";
            }
            if(cost.substring(cost.indexOf("."),cost.length()).length() == 2){
                cost+="0";
            }

            System.out.println(cost);


        }
    }
}
