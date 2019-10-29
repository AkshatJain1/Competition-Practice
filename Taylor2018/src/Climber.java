import java.util.*;
import java.io.*;
public class Climber {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("climber.dat"));
        ArrayList<char[]> map = new ArrayList<>();
        
        while (kb.hasNextLine()) {
            map.add(kb.nextLine().toCharArray());
        }
        int greatest = -1;
        for (int i = 0; i < map.get(0).length-1; i++) {
            int firstRowIn = -1, secondRowIn = -1;
            for (int i1 = 0; i1 < map.size(); i1++) {
                if(map.get(i1)[i] == 'C'){
                    firstRowIn = i1;
                    break;
                }
            }
            for (int i1 = 0; i1 < map.size(); i1++) {
                if(map.get(i1)[i+1] == 'C'){
                    secondRowIn = i1;
                    break;
                }
            }

            int dist = Math.abs(firstRowIn - secondRowIn);
            if(dist>greatest)
                greatest = dist;

        }
        System.out.println(greatest + " units of rope are needed for this site.");
    }
}
