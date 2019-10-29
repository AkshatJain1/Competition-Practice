import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Office {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("office-1.dat"));
        int r = kb.nextInt(); kb.nextLine();
        for (int ru = 0; ru < r; ru++) {
            int ppl = kb.nextInt(); kb.nextLine();
            ArrayList<Person> people = new ArrayList<>();
            for (int i = 0; i < ppl; i++) {
                String n = kb.next();
                int budget = kb.nextInt();
                people.add(new Person(n,budget));
                String pays = kb.nextLine();
                String[] pay = {};
                if(!pays.isEmpty())
                     pay = pays.substring(1).split("\\s+");
                for (String s : pay) {
                    people.get(i).addPay(s);
                }
            }
            for (Person p : people) {
                for (String pName : p.payNames) {
                    for(Person paid : people){
                        if(pName.equals(paid.name)) {

                            paid.net += p.budget/p.payNames.size();
                            break;
                        }
                    }
                }
            }
            Collections.sort(people);
            for (Person person : people) {
                System.out.println(person);
            }
            System.out.println();
        }
    }
}

class Person implements Comparable<Person>{
    double net;
    double budget;
    String name;
    ArrayList<String> payNames;

    public Person( String name, double budget) {
        this.net = -budget;
        this.name = name;
        this.budget = budget;
        payNames = new ArrayList<>();
    }
    public void addPay(String name) {
        payNames.add(name);
    }
    public String toString() {
        return String.format("%s %.2f",name,net);
    }
    public int compareTo(Person p) {
        return this.name.compareTo(p.name);
    }
}
