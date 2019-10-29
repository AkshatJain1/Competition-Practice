import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.io.File;

public class Championship {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("championship.dat"));

        int r = Integer.parseInt(kb.nextLine());
//        int[] lanePrefBack = {8,1,7,2,6,3,5,4};
          int[] lanePrefBack = {4,5,3,6,2,7,1,8};

        for (int i = 0; i < r; i++) {
            ArrayList<Swimmer> swimmers = new ArrayList<>();
            String contest = kb.nextLine();
            int numSwimmers = Integer.parseInt(kb.nextLine());
            for (int i1 = 0; i1 < numSwimmers; i1++) {
                String s = kb.nextLine();
                if( s.split(" ")[2].equals("DQ") == false)
                    swimmers.add(new Swimmer(s.split(" ")[0], s.split(" ")[1], s.split(" ")[2]));
            }
            Collections.sort(swimmers);
            String[] lanesChamp = new String[8];
            String[] lanesCons = new String[8];

            for (int i1 = 0; i1 < swimmers.size() && i1<8; i1++) {
                int lane = lanePrefBack[i1];
                swimmers.get(i1).lane = lane;

                lanesChamp[lane-1] = swimmers.get(i1).toString();
            }
            for (int i1 = 8; (i1 < swimmers.size() && i1<16); i1++) {
                    int lane = lanePrefBack[i1-8];
                    swimmers.get(i1).lane = lane;

                    lanesCons[lane - 1] = swimmers.get(i1).toString();

            }

            System.out.println(contest + " Consolation Finals".toUpperCase());
            for (int i1 = 0; i1 < lanesCons.length; i1++) {
                if(lanesCons[i1]!=null)
                    System.out.println(lanesCons[i1]);

            }
            System.out.println();
            System.out.println(contest + " Championship Finals".toUpperCase());
            for (int i1 = 0; i1 < lanesChamp.length; i1++) {
                if(lanesChamp[i1]!=null)
                    System.out.println(lanesChamp[i1]);
            }
            System.out.println();


        }


    }
}

class Swimmer implements Comparable<Swimmer> {
   String firstName, lastName, time;
   int lane;

    public Swimmer(String firstName, String lastName, String time) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.time = time;
    }

    public int getTime(){
        int min = Integer.parseInt(time.split(":")[0]);
        double sec = Double.parseDouble(time.split(":")[1]);

        return (int)(min*60*100 + sec*100);

    }

    public int compareTo(Swimmer s) {
        return -s.getTime() + this.getTime();
    }

    public String toString() {
        return lane + " " + lastName + ", " + firstName + " "+time;
    }
}
