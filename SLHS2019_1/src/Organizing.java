import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Organizing {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("organizing.in"));
        ArrayList<Tool> tools = new ArrayList<>();
        int x = Integer.parseInt(kb.nextLine());
        for(int i = 0; i < x; i++){
            String n = kb.next();
            int u = kb.nextInt();
            int w = kb.nextInt();
            int c = kb.nextInt();
            tools.add(new Tool(n, u,w,c));
        }
        Collections.sort(tools);
        for (int i = 0; i < tools.size() -1 ; i++) {
            System.out.print(tools.get(i) +", ");
        }
        System.out.print(tools.get(tools.size()-1));
    }
}
class Tool implements Comparable<Tool>{
    String t;
    int u,w,c;

    public Tool(String t, int u, int w, int c) {
        this.t = t;
        this.u = u;
        this.w = w;
        this.c = c;
    }

    public int compareTo(Tool tt){
        if(u-tt.u!=0){
            return -u+tt.u;
        }
        if(w-tt.w!=0){
            return -tt.w+w;
        }
        return -tt.c+c;
    }
    public String toString(){
        return this.t;
    }
}

//
//import java.io.*;
//        import java.util.*;
//
//public class Organizing {
//    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(new File("organizing.in"));
//
//        int cases = in.nextInt();
//
//        Item[] items = new Item[cases];
//
//        for(int i = 0; i < cases; i++) {
//            items[i] = new Item(in.next(), in.nextInt(), in.nextInt(), in.nextInt());
//        }
//        Arrays.sort(items);
//
//        System.out.println(Arrays.toString(items).replaceAll("[\\[\\] ]+", " ").trim());
//    }
//
//    public static class Item implements Comparable<Item> {
//        public int utility , weight, cost;
//        public String name;
//
//        public Item(String name, int utility , int weight, int cost) {
//            this.utility  = utility ;
//            this.weight = weight;
//            this.cost = cost;
//            this.name = name;
//        }
//
//        public int compareTo(Item i) {
//            int valComp = Integer.compare(i.utility , utility );
//            if(valComp != 0)
//                return valComp;
//
//            int weiComp = Integer.compare(weight, i.weight);
//            if(valComp != 0)
//                return valComp;
//
//            int cosComp = Integer.compare(i.cost, cost);
//            return cosComp;
//        }
//
//        public String toString() {
//            return name;
//        }
//    }
//}
