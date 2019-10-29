import java.util.ArrayDeque;
import java.util.Queue;

// queue node used in BFS
class Node
{
    // (x, y) represents matrix cell coordinates
    // dist represent its minimum distance from the source
    int x, y, dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
};

class Util
{


    // Below arrays details all 4 possible movements from a cell
    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    // Function to check if it is possible to go to position (row, col)
    // from current position. The function returns false if (row, col)
    // is not a valid position or has value 0 or it is already visited
    private static boolean isValid(int mat[][], boolean visited[][], int row, int col)
    {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] != '#' && !visited[row][col];
    }

    // Find Shortest Possible Route in a matrix mat from source
    // cell (i, j) to destination cell (x, y)
    private static int BFS(int mat[][], int i, int j, int x, int y)
    {
        // construct a matrix to keep track of visited cells
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        // create an empty queue
        Queue<Node> q = new ArrayDeque<>();

        // mark source cell as visited and enqueue the source node
        visited[i][j] = true;
        q.add(new Node(i, j, 0));

        // stores length of longest path from source to destination
        int min_dist = Integer.MAX_VALUE;

        // run till queue is not empty
        while (!q.isEmpty())
        {
            // pop front node from queue and process it
            Node node = q.poll();

            // (i, j) represents current cell and dist stores its
            // minimum distance from the source
            i = node.x;
            j = node.y;
            int dist = node.dist;

            // if destination is found, update min_dist and stop
            if (i == x && j == y)
            {
                min_dist = dist;
                break;
            }

            // check for all 4 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++)
            {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (isValid(mat, visited, i + row[k], j + col[k]))
                {
                    // mark next cell as visited and enqueue it
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        else {
            return -1;
        }
    }

    // Shortest path in a Maze
    public static void main(String[] args)
    {
        // input maze
        int[][] mat =
                {
                        { 1, 1, 1 },
                        { 0, 1, 1 },
                };

        // Find shortest path from source (0, 0) to
        // destination (7, 5)
        BFS(mat, 0, 0, 7, 5);
    }
}


class Combination {
    //comb
    public int combination(int n, int k)
    {
        return permutation(n) / (permutation(k) * permutation(n - k));
    }
    //permu
    public int permutation(int i)
    {
        if (i == 1)
        {
            return 1;
        }
        return i * permutation(i - 1);
    }

    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
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
    static void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r);
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        printCombination(arr, n, r);
    }
}
