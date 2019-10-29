import java.io.File;
import java.util.Scanner;

public class PowerConsumption {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("power.in"));
        long x = Long.parseLong(kb.nextLine());

        for (int i = 0; i < x; i++) {
            double maxVoltage = Double.parseDouble(kb.nextLine());
            long computers =Long.parseLong(kb.nextLine());
            long phones = Long.parseLong(kb.nextLine());
            long servers = Long.parseLong(kb.nextLine());
            double cw = Double.parseDouble(kb.nextLine());
            double pw = Double.parseDouble(kb.nextLine());
            double sw = Double.parseDouble(kb.nextLine());

            double power = computers*cw + phones*pw + servers*sw;
            System.out.printf("%.1f\n",power);

            if(power>maxVoltage) {
                System.out.println("Competition is gone");
            }
            else {
                System.out.println("Competition");
            }
        }


    }
}
