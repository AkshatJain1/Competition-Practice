import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Elevator {
    public static final int MAX_WEIGHT = 2000;
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Example/elevator.dat"));

        int r = kb.nextInt();
        kb.nextLine();
        for (int i = 0; i < r; i++) {
            ArrayList<Integer> weights = new ArrayList<>();
            String[] x = kb.nextLine().split(" ");
            for (int i1 = 0; i1 < x.length; i1++) {
                weights.add(Integer.parseInt(x[i1]));
            }
            Collections.sort(weights);
            int sum = 0;
            int maxPeople = -1;
            for (int i1 = 0; i1 < weights.size(); i1++) {
                sum+=weights.get(i1);
                System.out.println(sum  );
                if(sum>MAX_WEIGHT) {
                    maxPeople = i1-1;
                    break;
                }
                else if(i1 == weights.size()-1)
                    maxPeople = i1+1;
            }
            System.out.println(maxPeople);


        }
    }
}