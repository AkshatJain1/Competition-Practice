import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class BeanGame {
    static boolean weightReached;
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("beangame.dat"));
        int sets = kb.nextInt(); kb.nextLine();

        for (int i = 0; i < sets; i++) {
            int beans = kb.nextInt(); int w = Integer.parseInt(kb.nextLine().substring(1));
            weightReached = false;
            int[] b = new int[beans];
            for (int i1 = 0; i1 < beans; i1++) {
                b[i1] = kb.nextInt();
            }
            if(kb.hasNextLine())
                kb.nextLine();
            printCombination(b,b.length, w);
            System.out.println(weightReached ? "FOUND" : "NOT FOUND");
        }
    }
    /* arr[]  ---> Input Array
   data[] ---> Temporary array to store current combination
   start & end ---> Staring and Ending indexes in arr[]
   index  ---> Current index in data[]
   r ---> Size of a combination to be printed */
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r, int weight)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            int sum = 0;
            for (int j=0; j<r; j++)
                sum+=data[j];
            if(sum == weight)
                weightReached = true;
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r, weight);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int r, int weight)
    {
        if(r == 0)
            return;
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, arr.length-1, 0, r, weight);

        printCombination(arr, r-1, weight);
    }

}
