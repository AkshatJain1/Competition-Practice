import java.util.*;
import java.io.*;
public class shrubbery {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("shrubbery.dat"));
        kb.nextLine();
        while (kb.hasNextLine()) {
            int n = Integer.parseInt(kb.nextLine());
            ArrayList<Shrub> shrubs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                shrubs.add(new Shrub(kb.next(), kb.nextInt(), kb.nextDouble(), Double.parseDouble(kb.nextLine())));
            }
            Shrub.sort = kb.nextLine();
            Collections.sort(shrubs);
            for (Shrub shrub : shrubs) {
                System.out.println(shrub);
            }
            System.out.println();
        }
    }
}
class Shrub implements Comparable<Shrub>{
    static String sort;
    int nice;
    double price,size;
    String name;

    public Shrub(String name, int nice, double price, double size) {
        this.nice = nice;
        this.price = price;
        this.size = size;
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Shrub s){
        if(sort.equals("NICE")) {
            return -this.nice + s.nice;
        }
        else if(sort.equals("PRICE")) {
            return (int)((-s.price + this.price)*100000);
        }
        else if(sort.equals("SIZE")) {
            return (int)((-this.size + s.size) * 100000);
        }
        return -1;
    }


}