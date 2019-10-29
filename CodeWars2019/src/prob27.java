import java.io.*;
import java.util.*;

public class prob27 {
    static long temp = 0;
    static String owner = "";
    static String name = "";
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob27-1-in.txt"));
        file.next();
        temp = file.nextInt();
        file.next();
        owner = file.next();
        file.next();
        name = file.next();
        file.nextLine();
        while(file.hasNextLine())
        {
            String c = file.nextLine();
            Scanner sent = new Scanner(c);
            if(c.contains("Hey "))
            {
                sent.next();

                sent.next();
                c = sent.nextLine();
                c = c.substring(1);
            }
            c = c.toLowerCase();

            processCommand(c);
        }
    }

    public static void processCommand(String c)
    {
        if(c.contains("Hey "))
            System.out.println("I don't understand you, "+owner);

        else if((c.contains("what's") && c.contains("plus") && c.split(" ").length == 4) || (c.contains("what's") && c.contains("added to") && c.split(" ").length == 5))
        {
            Scanner sent = new Scanner(c.substring(0,c.length()-1));
            while(!sent.hasNextLong())
                sent.next();
            long n1 = sent.nextLong();
            while(!sent.hasNextLong())
                sent.next();

            long n2 = sent.nextLong();
            long sum = n1+n2;
            System.out.println(n1+ " plus "+n2+" is "+sum+", "+owner);
        }
        else if((c.contains("what's") && c.contains("times") && c.split(" ").length == 4) || (c.contains("what's") && c.contains("multiplied by") && c.split(" ").length == 5))
        {
            Scanner sent = new Scanner(c.substring(0,c.length()-1));
            while(!sent.hasNextLong())
                sent.next();
            long n1 = sent.nextLong();
            while(!sent.hasNextLong())
                sent.next();
            long n2 = sent.nextLong();
            long mult = n1*n2;
            System.out.println(n1+ " times "+n2+" is "+mult+", "+owner);
        }
        else if((c.contains("what's") && c.contains("to the") && c.contains("power") && c.split(" ").length == 6) || (c.contains("what's") && c.contains("raised to the") && c.contains("power") && c.split(" ").length == 7))
        {
            c = c.replaceAll("th","");
            c = c.replaceAll("st","");
            c = c.replaceAll("nd","");
            Scanner sent = new Scanner(c.substring(0,c.length()-1));
            while(!sent.hasNextLong())
                sent.next();
            long n1 = sent.nextLong();
            while(!sent.hasNextLong())
                sent.next();
            long n2 = sent.nextLong();
            long res = (long)Math.pow(n1,n2);
            System.out.println(n1+ " to the power of "+n2+" is "+res+", "+owner);
        }
        else if(c.equals("i'm still cold") || c.equals("i'm cold") || c.equals("turn up the heat"))
        {
            temp++;
            System.out.println("Temperature has been raised, "+owner);
        }
        else if(c.equals("i'm still hot") || c.equals("i'm hot") || c.equals("turn up the ac"))
        {
            temp--;
            System.out.println("Temperature has been lowered, "+owner);
        }
        else if(c.equals("what's the current temp?") || c.equals("what's the current temperature?"))
        {
            System.out.println("The current temperature is "+temp+", "+owner);
        }
        else if(c.contains("call me") && c.contains("from now on"))
        {
            Scanner sent = new Scanner(c);
            sent.next();
            sent.next();
            owner = sent.next();
            owner = ((""+owner.charAt(0)).toUpperCase()).charAt(0) + owner.substring(1);
            System.out.println("Okay, I'll call you "+owner+ " from now on");
        }
        else if(c.equals("what's your name?"))
        {
            System.out.println("My name is "+name+", "+owner);
        }
        else if(c.contains("can i call you"))
        {
            Scanner sent = new Scanner(c.substring(0,c.length()-1));
            sent.next();
            sent.next();
            sent.next();
            sent.next();
            name = sent.next();
            name = ((""+name.charAt(0)).toUpperCase()).charAt(0) + name.substring(1);
            System.out.println("Okay, you can call me "+name+" from now on");
        }
        else if(c.equals("tell me a joke"))
        {
            System.out.println("So this guy, a squirrel, and a dog walk into a bar...");
        }
        else if(c.equals("tell me a better joke"))
        {
            System.out.println("No");
        }
        else if(c.equals("open the pod bay doors"))
        {
            System.out.println("I can't do that, "+owner);
        }
        else
            System.out.println("I don't understand you, "+owner);
    }
}