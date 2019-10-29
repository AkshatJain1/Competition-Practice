import java.io.File;
import java.util.Scanner;

//Seven Lakes Code - Blake
public class Encrypter {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("encrypter.in"));
        kb.nextLine();
        while(kb.hasNextLine()){
            String sentence = kb.nextLine();
            String key = kb.nextLine();
            String n = "";
            int i =0;
                for(int x = 0;x<sentence.length();x++){
                    char b = sentence.charAt(x);
                    if(b>='A'&&b<='Z'){
                        b -= 'A';
                        b += (key.charAt(i%3))-'a';
                        b%=26;
                        b+='A';
                        i++;
                    }
                    else if(b>='a'&&b<='z'){
                        b-='a';
                        b += (key.charAt(i%key.length()))-'a';
                        b%=26;
                        b+='a';
                        i++;
                    }
                    n+=b;
                }
                n+=" ";
            n = n.substring(0,n.length()-1);
            System.out.println(n);
        }
    }
}

//Akshat Code
//public class Encrypter{
//    public static void main(String[] args) throws Exception {
//        Scanner kb = new Scanner(new File("encrypter.in"));
//
//        kb.nextLine();
//        while(kb.hasNextLine()) {
//            String message = kb.nextLine(); char[] letters = message.toCharArray();
//            String passkey = kb.nextLine();
//            passkey = passkey.replaceAll("\\s+", "");
//
//
//            int alphaCounter = 0;
//            for(int x =0; x < letters.length; x ++) {
//                if(Character.isAlphabetic(letters[x])) {
//                    int newLetter;
//                    if(Character.isUpperCase(letters[x])) {
//                        newLetter = (letters[x] - 'A');
//                    }
//                    else{
//                        newLetter = letters[x] - 'a';
//                    }
////                    System.out.println(letters[x]);
//                    char passkeyLetter = passkey.charAt(alphaCounter%passkey.length());
//                    if(Character.isUpperCase(passkeyLetter)) {
//                        newLetter += (passkeyLetter - 'A');
//                    }
//                    else{
////                        System.out.println("newLetter1 = " + newLetter);
////                        System.out.println("passkeyLetter = " + passkeyLetter);
//                        newLetter += passkeyLetter - 'a';
//                    }
//
////                    System.out.println("newLetter2 = " + newLetter);
//                    newLetter %= 26;
//
//
//                    if(Character.isUpperCase(letters[x])) {
//                        newLetter = newLetter + 'A';
//                    }
//                    else{
//                        newLetter = newLetter + 'a';
//                    }
//
//                    letters[x] = (char)newLetter;
//                    alphaCounter++;
//                }
//            }
//
//            for (int i = 0; i < letters.length; i++) {
//                System.out.print(letters[i]);
//            }
//            System.out.println();
//
//        }
//    }
//}

//TEST SOLUTION
//Decho Nkrcz!
//Dclv yhfz zw lh jbtvqiy hymk fjgjeyx.
//Skdgnu wf gn fbhkvgfovv xwtuse.
//Dhpofw kfgr bp wcqsytpw!

//JUDGE SOLUTION
//ceicnbKw.bcec@23geqn[]wy
//prcfdouvcktruvtscyuvtscyuoljdtp./';[]\1234567890-=oldzovrtsau.
//t
//I al a bad oersom - Vinz Rmith
//cid'l kicm psek josecw gbkl c i  r   g    o     l
//s. h. afwhsw. OSKKAFW; zSTgKlIjwCRFyMaGkA     chwt
//123129;+12313
//12

//Solution Code
//import java.io.*;
//
//public class Encrypter {
//
//    public static void main(String[] args) throws IOException{
//        Scanner sc= new Scanner(new File("encrypter.in"));
//
//        //System.out.println(sc.next());
//        int cases = sc.nextInt();
//        sc.nextLine();
//        for(int i = 0; i < cases; i++) {
//            String message = sc.nextLine();
//            String key = sc.nextLine().toLowerCase();
//            String encrypted = "";
//            int keyspot = 0;
//            for(int c = 0; c < message.length(); c++) {
//                char let = message.charAt(c);
//                if(Character.isLetter(let)) {
//                    if(Character.isUpperCase(let)) {
//                        encrypted += (char) ((((int)let - 65)+((int)key.charAt(keyspot++%key.length()))-97)%26+65);
//                    }
//                    else if(Character.isLowerCase(let)) {
//                        encrypted += (char)((((int)let -  97)+((int)key.charAt(keyspot++%key.length()))-97)%26+97);
//                    }
//                }else
//                    encrypted+=let;
//            }
//            System.out.println(encrypted);
//        }
//    }
//
//}