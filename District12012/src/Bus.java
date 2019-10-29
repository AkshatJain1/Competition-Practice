import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Bus {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Judges/bus.dat"));
        int r = Integer.parseInt(kb.nextLine());
        for (int z = 0; z < r; z++) {
            int peopleOnBus = kb.nextInt();
            String stops = "A "; int lowest = peopleOnBus;
            String[] nums = kb.nextLine().substring(1).split(" ");
            char currentStop = 'A';
            for (int i = 0; i < nums.length; i++) {
                currentStop++;
                int numLeft = Integer.parseInt(nums[i++]);
                int numAdd = Integer.parseInt(nums[i]);
                peopleOnBus+= (numAdd+numLeft);


                if(peopleOnBus<lowest) {
                    lowest = peopleOnBus;
                    stops = currentStop + " ";
                }
                else if(peopleOnBus == lowest){
                    stops += currentStop + " ";
                }
            }
            System.out.println(stops + lowest);

        }
    }
}
