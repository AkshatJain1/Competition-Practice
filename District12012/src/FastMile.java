import java.util.*;

import java.io.File;

public class FastMile {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Judges/fastmile.dat"));
        int r  = kb.nextInt(); kb.nextLine();
        for (int c = 0; c < r; c++) {
            String[] x = kb.nextLine().split(" ");
            String name = x[0];
            ArrayList<Time> times = new ArrayList<>();
            for (int i = 1; i < x.length; i++) {
                times.add(new Time(x[i]));
            }
            Collections.sort(times);
            System.out.println(name + " " +times.get(0));

        }
    }
}

class Time implements Comparable<Time>{
    String time;
    int hunSec;

    public Time(String time) {
        this.time = time;
        this.hunSec = Integer.parseInt(this.time.split(":")[0])*60*100 + (int)(Double.parseDouble(this.time.split(":")[1])*100);
    }

    @Override
    public int compareTo(Time o) {
        return this.hunSec - o.hunSec;
    }


    @Override
    public String toString() {
        return time;
    }
}
