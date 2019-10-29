import java.io.File;
import java.util.*;

public class prob09 {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("prob09-2-in.txt"));

        ArrayList<Team> teams = new ArrayList<>();
        int p = Integer.parseInt(kb.next()); Integer l = kb.nextInt();
        while(p!=0 && l!=0) {
            if(teams.contains(new Team(p,l))){
                teams.get(teams.indexOf(new Team(p,l))).addPoints(l);
            }
            else {
                teams.add(new Team(p, l));
            }

             p = Integer.parseInt(kb.next());  l = kb.nextInt();
             if(kb.hasNextLine())
                 kb.nextLine();
        }
        Collections.sort(teams);

        for (int i = 0; i < 5; i++) {
            System.out.println(i+1 + " "+ teams.get(i));
        }



    }
}

class Team implements Comparable<Team>{
    public int teamNumber;
    public Integer teamPoints;

    public Team(int teamNumber, Integer teamPoints) {
        this.teamNumber = teamNumber;
        this.teamPoints = teamPoints;
    }

    public void addPoints(int numPoints){
        this.teamPoints = (int)(this.teamPoints) + numPoints;

    }

    public int compareTo(Team o) {
        return o.teamPoints.compareTo(this.teamPoints);
    }
    public boolean equals(Object obj) {
        if(obj instanceof Team) {
            return ((Team) obj).teamNumber == this.teamNumber;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return teamNumber + " " + teamPoints;
    }
}