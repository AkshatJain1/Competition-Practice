public class prob10 {

    public static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
        if (index == r) {
            for(int i  = 0; i < r; i++)
                System.out.print(data[i] + " ");
            System.out.println();

            return;
        }

        for(int i = start; i <= end && end -i +1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index + 1, r);
        }
    }

    public static void printCombination(int arr[], int n, int r) {
        if(r == 0)
            return;

        int data[] = new int[r];

        combinationUtil(arr, data, 0, n-1, 0, r);

        printCombination(arr, n, r-1);
    }
//static void combinationUtil(int arr[], int data[], int start,
//                            int end, int index, int r)
//{
//    // Current combination is ready to be printed, print it
//    if (index == r)
//    {
//        for (int j=0; j<r; j++)
//            System.out.print(data[j]+" ");
//        System.out.println();
//        return;
//    }
//
//    // replace index with all possible elements. The condition
//    // "end-i+1 >= r-index" makes sure that including one element
//    // at index will make a combination with remaining elements
//    // at remaining positions
//    for (int i=start; i<=end && end-i+1 >= r-index; i++)
//    {
//        data[index] = arr[i];
//        combinationUtil(arr, data, i+1, end, index+1, r);
//    }
//}
//
//    // The main function that prints all combinations of size r
//    // in arr[] of size n. This function mainly uses combinationUtil()
//    static void printCombination(int arr[], int n, int r)
//    {
//        if(r==0)
//            return;
//
//        // A temporary array to store all combination one by one
//        int data[]=new int[r];
//
//        // Print all combination using temprary array 'data[]'
//        combinationUtil(arr, data, 0, n-1, 0, r);
//
//        printCombination(arr, n, r-1);
//    }

    public static void main(String[] args) throws Exception {
        int[] d = new int[3];
        d[0] = 1;
        d[1] = 2;
        d[2] = 3;

        printCombination(d, d.length, 3);
    }
}
