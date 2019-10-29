import java.io.*;
import java.util.*;

public class prob21 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob21-1-in.txt"));
        String date = file.nextLine();
        int yr = Integer.parseInt(date.split("-")[0]) - 1900;

        int month = Integer.parseInt(date.split("-")[1]) - 1;
        int day = Integer.parseInt(date.split("-")[2]);

        ArrayList<String> chineseZodiac = new ArrayList<String>();
        chineseZodiac.add("Rat");
        chineseZodiac.add("Ox");
        chineseZodiac.add("Tiger");
        chineseZodiac.add("Rabbit");
        chineseZodiac.add("Dragon");
        chineseZodiac.add("Snake");
        chineseZodiac.add("Horse");
        chineseZodiac.add("Sheep");
        chineseZodiac.add("Monkey");
        chineseZodiac.add("Rooster");
        chineseZodiac.add("Dog");
        chineseZodiac.add("Pig");


        ArrayList<Zodiac> zodiacs = new ArrayList<>();

        zodiacs.add( new Zodiac("Aries", new Date(yr, 3 ,21), new Date(yr, 4, 19)));
        zodiacs.add( new Zodiac("Taurus", new Date(yr, 4 ,20), new Date(yr, 5, 20)));
        zodiacs.add( new Zodiac("Gemini", new Date(yr, 5 ,21), new Date(yr, 6, 20)));
        zodiacs.add( new Zodiac("Cancer", new Date(yr, 6 ,21), new Date(yr, 7, 22)));
        zodiacs.add( new Zodiac("Leo", new Date(yr, 7 ,23), new Date(yr, 8, 22)));
        zodiacs.add( new Zodiac("Virgo", new Date(yr, 8 ,23), new Date(yr, 9, 22)));
        zodiacs.add( new Zodiac("Libra", new Date(yr, 9 ,23), new Date(yr, 10, 22)));
        zodiacs.add( new Zodiac("Scorpio", new Date(yr, 10 ,23), new Date(yr, 11, 21)));
        zodiacs.add( new Zodiac("Sagittarius", new Date(yr, 11 ,22), new Date(yr, 12, 21)));
        zodiacs.add( new Zodiac("Capricorn", new Date(yr, 12 ,22), new Date(yr, 12, 31)));
        zodiacs.add( new Zodiac("Capricorn", new Date(yr, 1 ,1), new Date(yr, 1, 19)));

        zodiacs.add( new Zodiac("Aquarius", new Date(yr, 1 ,20), new Date(yr, 2, 18)));
        zodiacs.add( new Zodiac("Pisces", new Date(yr, 1 ,19), new Date(yr, 2, 20)));
        
        String zodiac = "";
        Date birth = new Date(yr, month, day);

        for (int i = 0; i < zodiacs.size(); i++) {
            if(zodiacs.get(i).between(birth)) {
                zodiac = zodiacs.get(i).sign;
            }
        }
        
        String chi = chineseZodiac.get(Math.abs(yr+1900-2008)%12);

    }
}

class Zodiac {
    String sign;
    Date start;
    Date end;

    public Zodiac(String sign, Date start, Date end) {
        this.sign = sign;
        this.start = start;
        this.end = end;
    }
    public boolean between(Date d) {

        if(d.after(start) && d.before(end)) {
            return true;
        }
        return false;
    }
}