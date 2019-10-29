import java.io.*;
import java.util.*;

public class prob15 {
    public static int count;

    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("prob15-1-in.txt"));

        String l = "";
        int b = file.nextInt();
        int c = file.nextInt();

        for (int i = 0; i < b; i++) {
            l+="B";
        }
        for (int i = 0; i < c; i++) {
            l+="C";
        }
        printCombination(l.split("|"),2);

        printCombination(l.split("|"),4);

        printCombination(l.split("|"),3);



        System.out.println(count);


    }
    /* arr[]  ---> Input Array
        data[] ---> Temporary array to store current combination
        start & end ---> Staring and Ending indexes in arr[]
        index  ---> Current index in data[]
        r ---> Size of a combination to be printed */
    public static void combinationUtil(String arr[], String data[], int start,
                                       int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            String combo = String.join("",data);

            if(combo.contains("B") && combo.contains("C")) {
                count++;
            }
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining postitions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    public static void printCombination(String arr[],  int r)
    {
        if(r==0)
            return;

        // A temporary array to store all combination one by one
        String data[]=new String[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, arr.length-1, 0, r);

    }
}
