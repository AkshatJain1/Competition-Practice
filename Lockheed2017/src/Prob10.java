import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by respe on 9/18/2018.
 */
public class Prob10 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("JudgingInputs/Prob10.in.txt"));

        int runs = kb.nextInt(); kb.nextLine();

        for(int y= 0; y<runs; y++){
            int lines = kb.nextInt(); kb.nextLine();
            boolean caps = false;
            for(int x =0; x<lines; x++){
                String newLine = "";
                String l = kb.nextLine();
                for(int z = 0; z<l.length();z++){
                    char letter = l.charAt(z);
                    if(caps){
                        if(Character.isAlphabetic(letter) && letter >= 'a'){
                            letter -= 32;
                        }
                        else if(Character.isAlphabetic(letter)){
                            letter += 32;
                        }
                    }
                    String newLetter = getLet(letter);
                    if(newLetter.equals("CL")){
                        caps = caps?false:true;
                    }else{
                        newLine += newLetter;
                    }
                }
                System.out.println(newLine);

            }
        }
    }
    public static String getLet(char c) {
        Map<String,String> shiftRight = new HashMap<>();
        shiftRight.put("Q","    "); shiftRight.put("W","Q"); shiftRight.put("E","W"); shiftRight.put("R","E"); shiftRight.put("T","R");
        shiftRight.put("Y","T"); shiftRight.put("U","Y"); shiftRight.put("I","U"); shiftRight.put("O","I"); shiftRight.put("P","O");
        shiftRight.put("A","CL"); shiftRight.put("S","A"); shiftRight.put("D","S"); shiftRight.put("F","D"); shiftRight.put("G","F");
        shiftRight.put("H","G"); shiftRight.put("J","H"); shiftRight.put("K","J"); shiftRight.put("L","K"); shiftRight.put("Z","");
        shiftRight.put("X","Z"); shiftRight.put("C","X"); shiftRight.put("V","C"); shiftRight.put("B","V"); shiftRight.put("N","B");
        shiftRight.put("M","N"); shiftRight.put(",","m"); shiftRight.put(".",","); shiftRight.put(" ", " ");

        if(Character.isAlphabetic(c) && c >= 'a'){
            c-=32;
            String newletter = shiftRight.get(c+"");
            if(c!='A'&& c!='Q'){
                char newl = newletter.charAt(0);
                newl = (char)((int)newl+32);
                return newl+"";
            }
            return newletter;
        }
        else{
            return shiftRight.get(c+"");
        }
    }
}
