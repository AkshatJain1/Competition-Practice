import java.io.File;
import java.util.Scanner;

/**
 * Created by respe on 9/18/2018.
 */
public class Prob08 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("JudgingInputs/Prob08.in.txt"));

        int runs = kb.nextInt(); kb.nextLine();

        for(int y= 0; y<runs; y++) {
            double dist = kb.nextDouble() * Math.pow(10,6);
            double rate = kb.nextDouble();

            double time = dist/rate;

            int tdays = (int)(time/24);
            int thour = (int)(time%24);
            int tmin = (int)((time*60 - tdays *24*60 - thour*60));
            int tsec = (int)Math.round(time*60*60 - tdays*24*60*60 - thour*60*60 - tmin*60);
            if(tsec == 60){
                tsec = 0;
                tmin++;
            }
            if(tmin==60){
                tmin =0;
                thour++;
            }
            if(thour == 24){
                thour = 0;
                tdays++;
            }
            System.out.println("Time to Mars: " + tdays + " days, " + thour + " hours, " + tmin + " minutes, " + tsec + " seconds");

            kb.nextLine();

        }
    }
}
