import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/*

PROG: gift1
LANG: JAVA

 */
public class gift1 {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("gift1.in"));
        PrintWriter writer = new PrintWriter("gift1.out", "UTF-8");
        ArrayList<String> acc = new ArrayList<>();

        Map<String, Integer> accounts = new HashMap<>();
        int numPeople = Integer.parseInt(kb.nextLine());

        for(int x  = 0; x < numPeople; x++) {
            String pers = kb.nextLine();
            accounts.put(pers, 0);
            acc.add(pers);
        }

        while(kb.hasNextLine()) {
            String giftGiver = kb.nextLine();
            int money = kb.nextInt();

            int numPeopleGifts = kb.nextInt();
            if(numPeopleGifts==0 && !kb.hasNextLine()){
                break;
            }
            kb.nextLine();

            if(numPeopleGifts!=0) {
                accounts.put(giftGiver, accounts.get(giftGiver) - money + (money % numPeopleGifts));
                money = money / numPeopleGifts;

                for (int x = 0; x < numPeopleGifts; x++) {
                    String pers = kb.nextLine();
                    accounts.put(pers, accounts.get(pers) + money);
                }
            }
        }

        for(int x =0; x < acc.size(); x++){
            writer.println(acc.get(x) + " " + accounts.get(acc.get(x)));
        }

        writer.close();

    }
}
