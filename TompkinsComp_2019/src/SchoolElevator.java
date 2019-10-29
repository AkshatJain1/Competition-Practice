import java.io.File;
import java.util.Scanner;

public class SchoolElevator {
    public static void main(String... args) throws Exception {
        Scanner kb = new Scanner(new File("elev.in"));
        int lv1 = 10, pp1 = 0, lv2 = 0, pp2 = 0;
        kb.nextLine();
        while(kb.hasNextLine()){
            int l1 = kb.nextInt(), p1 = kb.nextInt(), l2 = kb.nextInt(), p2 = kb.nextInt(); kb.nextLine();
            if(Math.abs(lv1-l1) < Math.abs(lv2-l1) ) {
                lv1 = l2;
                pp1 = pp1+p1-p2;
                if(pp1+p2>=12){
                    pp1=Integer.MAX_VALUE;
                    lv1 = Integer.MAX_VALUE;
                }
                System.out.println(lv1+" " + pp1+" at " + l1+" " + l2);
            }
            else{
                lv2 = l2;
                pp2 = pp2+p1-p2;
                if(pp2+p2>=12){
                    pp2=Integer.MAX_VALUE;
                    lv2 = Integer.MAX_VALUE;
                }
            }
        }
        if(lv1==Integer.MAX_VALUE)
            System.out.println("SHUT DOWN");
        else
            System.out.println("Elevator 1: Level " + lv1+", "+ pp1 + " people");
        if(lv2==Integer.MAX_VALUE)
            System.out.println("SHUT DOWN");
        else
            System.out.println("Elevator 2: Level " + lv2+", "+ pp2 + " people");
    }
}
