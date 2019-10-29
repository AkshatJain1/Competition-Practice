import java.io.File;
import java.util.Scanner;

public class prob12 {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("prob12-1-in.txt"));

        int r = kb.nextInt(); kb.nextLine();

        double[][] grid = new double[r][r];

        for (int i = 0; i < r; i++) {
            String[] l = kb.nextLine().split("\\s+");
            for (int i1 = 0; i1 < l.length; i1++) {
                grid[i][i1] = Double.parseDouble(l[i1]);
            }
        }

        double maxAngle = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[0].length; i1++) {
                for (int i3 = 0; i3 < grid.length; i3++) {
                    for (int i4 = 0; i4 < grid[0].length; i4++) {
                        double h = Math.abs(grid[i][i1] - grid[i3][i4]);
                        double w = Math.abs(i3-i1);

                        double sl = deg(h,w);

                        maxAngle = maxAngle>sl ? maxAngle : sl;
                        if(sl==maxAngle){
                            System.out.println(h+" and " +w);
                            System.out.println(grid[i][i1] +" or "+ grid[i3][i4]);
                        }

                    }
                }
            }
        }
        System.out.println("maxAngle = " + maxAngle);


    }
    public static double deg(double a, double b) {

        if(b!=0)
            return Math.asin(a/b)*180/Math.PI;
        else
            return -1;
    }
}
