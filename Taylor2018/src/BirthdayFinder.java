import java.util.*;
import java.io.*;
public class BirthdayFinder {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("birthdayfinder.dat"));

        while(kb.hasNextLine()) {
            String l = kb.nextLine();
            String date = l.split(" - ")[0];
            int month = Integer.parseInt(date.split("/")[0]);
            int day = Integer.parseInt(date.split("/")[1]);
            int year = Integer.parseInt(date.split("/")[2]);

            int daysOld = Integer.parseInt(l.split(" - ")[1]);

            for (int i = daysOld; i > 0; i--) {
                day--;
                if(day == 0) {
                  if(month == 1) {
                      month=12;
                      year--;
                      day = 31;
                  }
                  else if(month == 2) {
                      month=1;
                      day = 31;
                  }
                  else if(month == 3) {
                      month=2;
                      if(year%4==0 || (year%100 == 0 && year%400!=0))
                         day = 29;
                      else
                          day = 28;
                  }
                  else if(month == 4) {
                      month=3;
                      day = 31;
                  }
                  else if(month == 5) {
                      month=4;
                      day = 30;
                  }
                  else if(month == 6) {
                      month=5;
                      day = 31;
                  }
                  else if(month == 7) {
                      month=6;
                      day = 30;
                  }
                  else if(month == 8) {
                      month=7;
                      day = 31;
                  }
                  else if(month == 9) {
                      month=8;
                      day = 31;
                  }
                  else if(month == 10) {
                      month=9;
                      day = 30;
                  }
                  else if(month == 11) {
                      month=10;
                      day = 31;
                  }
                  else if(month == 12) {
                      month=11;
                      day = 30;
                  }
                }

            }

            System.out.printf("%02d/%02d/%04d",month,day,year);
            System.out.println();

        }

    }
}