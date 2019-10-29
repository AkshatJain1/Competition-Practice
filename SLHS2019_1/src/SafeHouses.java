import java.io.File;
import java.util.Scanner;

public class SafeHouses {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("safehouses.in"));
        kb.nextLine();
        while(kb.hasNextLine()){
            String l = kb.nextLine();
            int x = Integer.parseInt(l.split(" ")[0]);
            if(x%7!=0)
                System.out.println("DANGER!");
            else{
                System.out.println(l);
            }

        }
    }
}
