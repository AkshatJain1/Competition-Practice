import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chart {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("chart.in"));
        int dataSets = Integer.parseInt(kb.nextLine());
        //loop through rooms
        for (int i = 0; i < dataSets; i++) {
            //gather data
            ArrayList<Student> students = new ArrayList<>();
            int numStudents = Integer.parseInt(kb.nextLine());

            for (int i1 = 0; i1 < numStudents; i1++) {
                String name = (kb.next().charAt(0)) + "" + kb.next().charAt(0);
                int number = Integer.parseInt(kb.nextLine().substring(1));

                students.add(new Student(number, name));
            }

            //determine the number of columns
            int nums = numStudents;
            int columns = 0;
            while(nums>0) {
                if(columns%2==0)
                    nums -= 4;
                else
                    nums -= 3;
                columns++;
            }

            //create initial seating array
            Student[][] seats = createSeating(columns, students);
            boolean check = true;

            while(check) {
                check = false;
              int n = 0;
                for (int c = 0; c < seats[0].length; c++) {
                    for (int r = c%2; r < seats.length; r+=2) {
                        if(!check && r-1!=-1 && n+1!=students.size()){
                            if(c-1!=-1 && seats[r][c].teamNum == seats[r-1][c-1].teamNum)
                                check = true;
                            if(c+1!=seats[0].length && seats[r][c].teamNum == seats[r-1][c+1].teamNum)
                                check = true;

                            if(check){
                                Student temp = students.get(n);
                                students.set(n, students.get(n+1));
                                students.set(n+1, temp);
                                break;
                            }
                        }
                        n++;
                    }
                }
                seats = createSeating(columns, students);
            }

            for(Student[] s:seats){
                for (int a = 0; a < s.length; a++) {
                    System.out.print(s[a] +" ");
                }
                System.out.println();
            }

            System.out.println();
        }
    }

    public static Student[][] createSeating(int columns, ArrayList<Student> students){
        Student[][] seats = new Student[7][columns];
        for (int i1 = 0; i1 < seats[0].length; i1++) {
            for (int i2 = 0; i2 < seats.length; i2++) {
                seats[i2][i1] = new Student(-1, "EE");
            }
        }

        int n = 0;
        for (int i1 = 0; i1 < seats[0].length; i1++) {
            for (int i2 = i1%2; i2 < seats.length; i2+=2) {
                if(n < students.size())
                    seats[i2][i1] = students.get(n++);
            }
        }
        return seats;
    }
}

class Student{
    public int teamNum;
    public String name;

    public Student(int teamNum, String name) {
        this.teamNum = teamNum;
        this.name = name;
    }
    public String toString(){
        if(teamNum==-1)
            return "<>";
        return ""+teamNum;
    }
}