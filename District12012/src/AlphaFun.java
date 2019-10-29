import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AlphaFun {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Judges/alphafun.dat"));
        ArrayList<Word> words = new ArrayList<>();
        while(kb.hasNextLine()) {
            String w = kb.nextLine();
            words.add(new Word(w));
        }
        Collections.sort(words);
        for (Word word : words) {
            System.out.println(word);
        }
    }
}

class Word implements Comparable <Word> {
    String word;

    public Word(String word) {
        this.word = word;
    }

    public int compareTo(Word w) {
        String w2 = w.word, w1 = this.word;
        char fourthLetter_w2 = w2.length()>3 ? w2.charAt(3) : ' ',  fourthLetter_w1 = w1.length()>3 ? w1.charAt(3) : ' ';

        if(w2.charAt(1) != w1.charAt(1))
            return w1.charAt(1) - w2.charAt(1);
        else if(fourthLetter_w1 != fourthLetter_w2)
            return fourthLetter_w1 - fourthLetter_w2;
        else if(w2.charAt(w2.length()-1)!= w1.charAt(w1.length()-1))
            return w1.charAt(w1.length()-1) - w2.charAt(w2.length()-1);
        else if(w2.charAt(0)!= w1.charAt(0))
            return w1.charAt(0) - w2.charAt(0);
        else
            return w1.compareTo(w2);

    }
    public String toString(){
        return this.word;
    }
}
