import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by respe on 9/18/2018.
 */
public class Prob07 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("JudgingInputs/Prob07.in.txt"));

        int runs = kb.nextInt(); kb.nextLine();

        for(int y= 0; y<runs; y++) {
            String line = kb.next();
            String name = line.split(":")[0];
            System.out.print(name+"=");
            String[] stats = line.split(":")[1].split(",");
            double scores = 0;
            double bats = 0;
            for (int x=0; x<stats.length; x++){
                if(stats[x].equals("K")){
                    bats++;
                }
                if(stats[x].equals("1B")){
                    bats++;
                    scores++;
                }
                if(stats[x].equals("2B")){
                    bats++;
                    scores +=2;
                }
                if(stats[x].equals("3B")){
                    bats++;
                    scores+=3;
                }
                if(stats[x].equals("HR")){
                    bats++;
                    scores+=4;
                }

            }

            double slg = scores/bats;
            if(scores == 0){
                slg = 0;
            }
            slg = Math.round(slg*1000.0)/1000.0;
            System.out.println(slg);
            kb.nextLine();

        }
    }
}
