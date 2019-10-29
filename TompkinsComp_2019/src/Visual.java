import java.io.File;
import java.util.Scanner;

public class Visual {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("visual.test.in"));

        double maxLetter = 0, maxLetterFreq = Integer.MIN_VALUE;
        int totalLetterCount = 0;
        long letterFreq[] = new long[26];

        while(kb.hasNextLine()) {
          String l = kb.nextLine();
            for (int i = 0; i < l.length(); i++) {
                if(Character.isAlphabetic(l.charAt(i))){
                    totalLetterCount++;
                    int c = Character.isUpperCase(l.charAt(i)) ? l.charAt(i) - 'A' : l.charAt(i) - 'a';
                    letterFreq[c]++;
                    if(letterFreq[c] > maxLetterFreq){
                        maxLetterFreq = letterFreq[c];
                        maxLetter = c;
                    }
                }
            }
        }
        System.out.println((char)(maxLetter+'a')+"\n");
        System.out.println("------------");
        long hashtags = Math.round(maxLetterFreq/totalLetterCount*30);
        long baseHashtags = hashtags/3;
        boolean extraHashtagOnOne = hashtags%3!=0, extraHashtagOnTwo = hashtags%3==2;
        long oneHashtags = baseHashtags + (extraHashtagOnOne?1:0), twoHashtags = baseHashtags + (extraHashtagOnTwo?1:0), threeHashtags = baseHashtags;

        System.out.print("|");
        for (long i = 0; i < oneHashtags; i++) {
            System.out.print("#");
        }
        for (long i = 0; i < 10 - oneHashtags; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("|");
        for (long i = 0; i < twoHashtags; i++) {
            System.out.print("#");
        }
        for (long i = 0; i < 10 - twoHashtags; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("|");
        for (long i = 0; i < threeHashtags; i++) {
            System.out.print("#");
        }
        for (long i = 0; i < 10 - threeHashtags; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
        System.out.println("------------");


    }
}
