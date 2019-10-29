import java.io.File;
import java.util.Scanner;

/**
 * Created by respe on 9/18/2018.
 */
public class Prob11 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("JudgingInputs/Prob11.in.txt"));

        int runs = kb.nextInt(); kb.nextLine();

        for(int y= 0; y<runs; y++) {

            String line = kb.nextLine();

            String[] words = line.split(" ");

            for(int x = 0; x < words.length; x++) {
                String word = words[x];
                String wordWoSpecial = removeSpecial(word);
                String newWord = "";

                for(int c = wordWoSpecial.length()-1; c >= 0 ; c--){
                    if(word.charAt(wordWoSpecial.length()-1-c) >= 'A' && word.charAt(wordWoSpecial.length()-1-c) <= 'Z' ) {
                        word = word.substring(0, wordWoSpecial.length()-1-c) + Character.toUpperCase(wordWoSpecial.charAt(c)) + word.substring(wordWoSpecial.length()-c);
                    }
                    else{
                        word = word.substring(0, wordWoSpecial.length()-1-c) + (Character.toLowerCase(wordWoSpecial.charAt(c))) + word.substring(wordWoSpecial.length()-c);

                    }
                }
                System.out.print(word);
                if(x!=words.length-1){
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }
    public static String removeSpecial(String word){
        String nword = "";
        for(int x = 0; x < word.length() ; x++){
            if(Character.isAlphabetic(word.charAt(x))){
                nword += word.charAt(x);
            }
        }
        return nword;
    }
}
