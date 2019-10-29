import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Packing {
    public static ArrayList<ArrayList<Item>> combinations;
    public static int weight;

    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("packing.in"));
        ArrayList<Item> items = new ArrayList<>();
        int count=0;
        int n = kb.nextInt();  weight = kb.nextInt(); kb.nextLine();
        for(int r =0; r<n; r++){
            String[] i =  kb.nextLine().split("\\s+");
            if(Integer.parseInt(i[2]) <= weight) {
                items.add(new Item(i[0], Integer.parseInt(i[1]), Integer.parseInt(i[2])));
                count++;
            }
        }

        combinations = new ArrayList<>();
        printCombination(items.toArray(), items.toArray().length, count);
        int highestValue = -1; int highestValueIndex = -1;

        for (int i = 0; i < combinations.size(); i++) {
            int value = 0;
            for (int i1 = 0; i1 < combinations.get(i).size(); i1++) {
                value+= combinations.get(i).get(i1).value;
            }
            if(value>highestValue) {
                highestValueIndex = i;
                highestValue = value;
            }
        }
        ArrayList<Item> winningCombo = combinations.get(highestValueIndex);
        Collections.sort(winningCombo);
        for (int i = 0; i < winningCombo.size(); i++) {
            System.out.println(winningCombo.get(i));
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
            ArrayList<Item> items = new ArrayList<>(); int w = 0;
            for (int j=0; j<r; j++) {
                items.add((Item) data[j]);
                w+= ((Item)data[j]).weight;
            }
            if(w<=weight)
                combinations.add(items);
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
    static void printCombination(Object arr[], int n, int r)
    {
        if(r==0) {
            return;
        }
        else{
            // A temporary array to store all combination one by one
            Object data[]=new Object[r];

            // Print all combination using temprary array 'data[]'
            combinationUtil(arr, data, 0, n-1, 0, r);

            printCombination(arr, n, r-1);
        }

    }
}

class Item implements Comparable<Item>{
    String name;
    int value;
    int weight;

    public Item(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public String toString() {
        return name + " " + value + " " + weight;
    }

    public int compareTo(Item i){
        return this.name.compareTo(i.name);
    }
}
