import java.awt.*;
import java.io.*;
import java.util.*;

public class prob22 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob22.txt"));
        ArrayList <Country> countries = new ArrayList<Country>();
        ArrayList <Person> people = new ArrayList<Person>();
        ArrayList <Person> unknown = new ArrayList<Person>();


        String line = file.nextLine();

        while(file.hasNextLine()) {
            if(line.contains("~~~~~~")) {
                break;
            }

            String name = line.substring(0,line.indexOf("|"));
            String coord = line.substring(line.indexOf("|") + 2, line.length() - 1);



            Point p = new Point((int) (Double.parseDouble(coord.split(",")[0]) * 100), (int) (Double.parseDouble(coord.split(",")[1]) * 100));

            people.add(new Person(name, p));
            line = file.nextLine();
        }

        while(file.hasNextLine()) {
            line = file.nextLine();

            String name = line.split(":")[0];

            String[] boundaries = line.split(":")[1].replaceAll("\\s+", "").split(";");
            String p1 = boundaries[0].substring(1, boundaries[0].length() - 1);

            int p1x = Integer.parseInt(p1.split(",")[0]);
            int p1y = Integer.parseInt(p1.split(",")[1]);
            String p4 = boundaries[3].substring(1, boundaries[3].length() - 1);

            int p4x = Integer.parseInt(p4.split(",")[0]);
            int p4y = Integer.parseInt(p4.split(",")[1]);

            countries.add(new Country(p1x, p1y, p4x - p1x, p4y - p1y, name));
        }

        Collections.sort(countries);

        for (int i = 0; i < people.size(); i++) {
            boolean un = true;
            for (int i1 = 0; i1 < countries.size(); i1++) {

                if(countries.get(i1).inside(people.get(i))) {
                    countries.get(i1).residents.add(people.get(i));
                    un = false;

                    break;
                }
            }
            if(un) {
                unknown.add(people.get(i));
            }
        }

        for (int i = 0; i < countries.size(); i++) {
            if(countries.get(i).residents.size() > 0) {
                System.out.println("["+countries.get(i).name+"]");
                ArrayList<Person> ppl = (countries.get(i).residents);

                for (int i1 = 0; i1 < ppl.size(); i1++) {
                    System.out.println("-" + ppl.get(i1).name);
                }
            }
        }
        System.out.println("[Unknown]");
        for (int i1 = 0; i1 < unknown.size(); i1++) {
            System.out.println("-" + unknown.get(i1).name);
        }

    }

}

class Country implements Comparable<Country> {
    String name;
    Rectangle boundaries;
    ArrayList<Person> residents;

    public Country(int x1, int y1, int width, int height, String name) {
        this.name = name;
        this.residents = new ArrayList<>();
        this.boundaries = new Rectangle(x1 * 100,y1 * 100,width * 100,height * 100);
    }

    public boolean inside(Person person) {
        if(boundaries.contains(person.p)) {
            return true;
        }
        else {
            if(person.p.x <= boundaries.x+boundaries.width && person.p.x >= boundaries.x && person.p.y <= boundaries.y + boundaries.height && person.p.y >= boundaries.y){
                return true;
            }
            return false;
        }
    }
    public int compareTo(Country c) {
        return this.name.compareTo(c.name);
    }

    public String toString(){
        return boundaries.toString();
    }
}
class Person {
    String name;
    Point p;

    public Person(String name, Point p) {
        this.name = name;
        this.p = p;
    }
    public String toString() {
        return name;
    }
}