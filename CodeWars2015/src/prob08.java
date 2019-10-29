import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class prob08 {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("prob08-2-in.txt"));
        ArrayList<Integer> takenCubes = new ArrayList<>();
        ArrayList<Integer> duplicateCubes = new ArrayList<>();
        int empty = 0;
        int noCube = 0;
        int n = kb.nextInt(); kb.nextLine();
        for (int i = 0; i < n; i++) {
            String e = kb.next(); int cubeNum = kb.nextInt(); if(kb.hasNextLine()) kb.nextLine();

            if(e.equals("NA"))
                empty++;
            else if(cubeNum == 0)
                noCube++;
            else if(takenCubes.contains(cubeNum) && !duplicateCubes.contains(cubeNum))
                duplicateCubes.add(cubeNum);
            else
                takenCubes.add(cubeNum);
        }
        System.out.println("Empty Cubes: " + empty);
        System.out.println("Duplicate Cube Assignments: " + duplicateCubes.size());
        System.out.println("Employees without Cube: " + noCube);



    }
}