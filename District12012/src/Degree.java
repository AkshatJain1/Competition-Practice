import java.util.Scanner;

import java.io.File;

public class Degree {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("Judges/degree.dat"));

        int r  = kb.nextInt(); kb.nextLine();
        for (int c = r; c > 0; c--) {
            String[] line = kb.nextLine().split(" ");
            int degree = 0;
            for (int i = 0; i < line.length; i++) {
                int value = Integer.parseInt(line[i]);
                int sub = 0;
                for (int i1 = i; i1 < line.length; i1++) {
                    int newVal = Integer.parseInt(line[i1]);
                    if(newVal < value)
                        sub++;
                }
                degree+=sub;
            }
            System.out.println(degree);
        }
    }
}
