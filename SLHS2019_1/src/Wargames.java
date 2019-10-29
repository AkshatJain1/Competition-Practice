import java.io.File;
import java.util.Scanner;

public class Wargames {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("wargames.in"));
        
        int n = Integer.parseInt(kb.nextLine());
        for (int r = 0; r < n; r++) {
            int matches = Integer.parseInt(kb.nextLine());
            char[][] res = new char[matches][2];

            for (int m = 0; m < matches; m++) {
                String match = kb.nextLine();
                res[m][0] = match.split("\\s+")[0].charAt(0);
                res[m][1] = match.split("\\s+")[1].charAt(0);
            }

            int row = kb.nextInt(); int col = kb.nextInt(); kb.nextLine();
            int wins = 0, loss = 0;

            for(int x =0; x< row; x++) {
                String map = kb.nextLine();
                char rebel = map.charAt(1); char stroud = map.charAt(col-2);

                for (int i = 0; i < res.length; i++) {
                    if(res[i][0] == rebel && res[i][1] == stroud) {
                        wins++;
                        break;
                    }
                    if(res[i][0] == stroud && res[i][1] == rebel) {
                        loss++;
                        break;
                    }
                }
            }

            if(wins == loss)
                System.out.println("The war isn't over");
            else if(wins < loss)
                System.out.println("The empire still stands...");
            else
                System.out.println("The rebels have won!");

        }
    }
}
