import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BeanVault {
    static ArrayList<ArrayList<Bean>> combos;

    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("beanvault.dat"));

        int sets = kb.nextInt(); kb.nextLine();
        for (int i = 0; i < sets; i++) {
            combos = new ArrayList<>();
            int max = Integer.parseInt(kb.nextLine());
            String weights = kb.nextLine();
            String vals = kb.nextLine();
            Scanner w = new Scanner(weights);
            Scanner v = new Scanner(vals);
            ArrayList<Bean> beans = new ArrayList<>();
            while(w.hasNextInt()) {
                beans.add(new Bean(w.nextInt(), v.nextInt() ));
            }
            printCombination(beans.toArray(), beans.size());
            int highest = -1;
            for (ArrayList<Bean> combo : combos) {
                int sumVal = 0;
                int sumWi = 0;
                for (Bean bean : combo) {
                    sumVal+= bean.value;
                    sumWi += bean.weight;
                }
//                System.out.println(sumVal);
                if(sumWi<=max && sumVal>highest)
                    highest = sumVal;
            }
            System.out.println(highest);
        }
    }
    /* arr[]  ---> Input Array
 data[] ---> Temporary array to store current combination
 start & end ---> Staring and Ending indexes in arr[]
 index  ---> Current index in data[]
 r ---> Size of a combination to be printed */
    static void combinationUtil(Object arr[], Object data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            ArrayList<Bean> beans = new ArrayList<>();
            for (int j=0; j<r; j++)
                beans.add((Bean)data[j]);
            combos.add(beans);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(Object arr[], int r)
    {
        if(r == 0)
            return;
        // A temporary array to store all combination one by one
        Object data[]=new Object[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, arr.length-1, 0, r);

        printCombination(arr, r-1);
    }
}
class Bean{
    int weight, value;

    public Bean(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    public String toString(){
        return weight+" " +value;
    }
}
