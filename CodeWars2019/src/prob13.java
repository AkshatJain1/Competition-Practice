import java.io.*;
import java.util.*;

public class prob13 {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob13.txt"));
        if(!file.hasNextInt())
        {file.nextLine();
            double n1 = file.nextInt();file.nextLine();
            double n2 = file.nextInt();file.nextLine();
            double n3 = file.nextInt();file.nextLine();
            System.out.printf("%.1f",(n2/n3)*n1);
        }
        else
        {
            double n1 = file.nextInt();file.nextLine();
            if(!file.hasNextInt())
            {
                file.nextLine();
                double n2 = file.nextInt();file.nextLine();
                double n3 = file.nextInt();file.nextLine();
                System.out.printf("%.1f",(n1*n3)/n2);
            }
            else
            {
                double n2 = file.nextInt();file.nextLine();
                if(!file.hasNextInt())
                {
                    file.nextLine();
                    double n3 = file.nextInt();file.nextLine();
                    System.out.printf("%.1f", (n1 / n2) * n3);
                }
                else
                {
                    double n3 = file.nextInt();file.nextLine();
                    System.out.printf("%.1f",(n2*n3)/n1);
                }
            }
        }
    }
}