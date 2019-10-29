import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Cheese {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("cheese.dat"));
        while(kb.hasNextLine()) {
            String l = kb.nextLine();
            String d1 = l.split(" ")[0];
            String d2 = l.split(" ")[1];

            Date d = new Date(Integer.parseInt(d1.substring(4,6)),Integer.parseInt(d1.substring(0,2)),Integer.parseInt(d1.substring(2,4)), Integer.parseInt(d1.substring(6,8)), Integer.parseInt(d1.substring(8,10)), Integer.parseInt(d1.substring(10,12)));
            Date dl = new Date(Integer.parseInt(d2.substring(4,6)),Integer.parseInt(d2.substring(0,2)),Integer.parseInt(d2.substring(2,4)), Integer.parseInt(d2.substring(6,8)), Integer.parseInt(d2.substring(8,10)), Integer.parseInt(d2.substring(10,12)));

            System.out.printf("%d:%02d:%02d:%02d",getDateDiff(d,dl,TimeUnit.DAYS), getDateDiff(d,dl,TimeUnit.HOURS)%24, getDateDiff(d,dl,TimeUnit.MINUTES)%60, getDateDiff(d,dl,TimeUnit.SECONDS)%60);
            System.out.println();
        }
    }
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return Math.abs(timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS));
    }
}