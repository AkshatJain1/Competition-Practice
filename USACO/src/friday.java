import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*

PROG: friday
LANG: JAVA

 */
public class friday {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("friday.in"));
        Map<String, Integer> freq = new HashMap<>();
        PrintWriter writer = new PrintWriter("friday.out", "UTF-8");

        freq.put("Monday", 0); freq.put("Tuesday", 0); freq.put("Wednesday", 0); freq.put("Thursday", 0); freq.put("Friday", 0); freq.put("Saturday", 0); freq.put("Sunday", 0);
        int years = kb.nextInt();
        int day = 0; //Monday
        for(int x = 1900; x < 1900+years; x++) {
            for(int y = 1; y<=12; y++){
                for(int z =1; z <= numDays(y,x); z++) {
                    day++;

                    if(day == 8)
                        day = 1;
                    if(z == 13) {
                        switch (day) {
                            case 1: freq.put("Monday", freq.get("Monday")+1);
                                    break;
                            case 2: freq.put("Tuesday", freq.get("Tuesday")+1);
                                break;
                            case 3: freq.put("Wednesday", freq.get("Wednesday")+1);
                                break;
                            case 4: freq.put("Thursday", freq.get("Thursday")+1);
                                break;
                            case 5: freq.put("Friday", freq.get("Friday")+1);
                                break;
                            case 6: freq.put("Saturday", freq.get("Saturday")+1);
                                break;
                            case 7: freq.put("Sunday", freq.get("Sunday")+1);
                                break;
                        }
                    }
                }
            }
        }

        writer.println(freq.get("Saturday") + " " +freq.get("Sunday") + " " +freq.get("Monday") + " " +freq.get("Tuesday") + " " +freq.get("Wednesday") + " " +freq.get("Thursday") + " " +freq.get("Friday"));
        writer.close();

    }
    public static boolean isLeapYear(int year) {
        if(year%4 == 0 && (year%400==0 || year%100!=0)){
            return true;
        }
        return false;
    }
    public static int numDays(int month, int year){
        if(month == 4||month == 6||month == 9||month == 11){
            return 30;
        }
        else if(month == 2){
            if(isLeapYear((year)))
                return 29;
            else
                return 28;
        }
        else{
            return 31;
        }
    }
}
