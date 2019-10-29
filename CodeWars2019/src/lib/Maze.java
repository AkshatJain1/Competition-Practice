package lib;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Position {
    int row, col;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public String toString() {
        return row+" "+col;
    }
}
// queue node used in BFS
class Node
{
    // (x, y) represents matrix cell coordinates
    // dist represent its minimum distance from the source
    int x, y, dist;
    ArrayList<Character> pathTaken;
    ArrayList<Position> positions;

    Node(int x, int y, int dist,ArrayList<Character> pathTaken, ArrayList<Position> positions) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.pathTaken = pathTaken;
        this.positions = positions;
    }

    public boolean visited(int r, int c) {
        for (int i = 0; i < positions.size(); i++) {
            if(positions.get(i).row == r && positions.get(i).col == c)
                return true;
        }
        return false;
    }

}

class Util
{


    // Below arrays details all 4 possible movements from a cell
    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    public static boolean isValid(char mat[][], Node n, int row, int col)
    {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] != '#' && !n.visited(row, col);
    }
    // Find Shortest Possible Route in a matrix mat from source
    // cell (i, j) to destination cell (x, y)
    public static int BFS(char mat[][], int i, int j, int x, int y)
    {

        // create an empty queue
        Queue<Node> q = new ArrayDeque<>();

        ArrayList<Character> path = new ArrayList();
        // mark source cell as visited and enqueue the source node


        q.add(new Node(i, j, 0 ,new ArrayList<>(), new ArrayList<>()));

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


            node.pathTaken.add(mat[i][j]);
            node.positions.add(new Position(i,j));

            // if destination is found, update min_dist and stop
            if (i == x && j == y)
            {
                if(dist<min_dist) {
                    min_dist = dist;
                    path = node.pathTaken;
                }
            }

            // check for all 4 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++)
            {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (isValid(mat, node, i + row[k], j + col[k]))
                {
                    int d = 1;

                    //other distances here

//                    switch (mat[i][j]) {
//                        case 'T':
//                            d = 3;
//                            break;
//                        case 'W':
//                            d = 8;
//                            break;
//                        case 'O':
//                            d = 12;
//                            break;
//                        case 'S':
//                            d = 20;
//                            break;
//                    }

                    q.add(new Node(i + row[k], j + col[k], dist+d, (ArrayList<Character>)node.pathTaken.clone(), (ArrayList<Position>)node.positions.clone()));
                }
            }
        }
        //remove start and end
        if(path.size()>1){
            path.remove(0);
            path.remove(path.size()-1);
        }
        //return path or min_dist
        return min_dist == Integer.MAX_VALUE ? -1 : min_dist;
    }

    // Shortest path in a Maze
    public static void main(String[] args)
    {
        // input maze
        char[][] mat =
                {
                        { '1', '1', '1' },
                        { '0', '1', '1' },
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

        private static List<String> combineTwoLists(List<String> list1, List<String> list2)
        {
            List<String> result = new ArrayList<String>();
            StringBuilder sb = new StringBuilder();
            for(String s1 : list1)
            {
                for(String s2: list2)
                {
                    sb.setLength(0);
                    sb.append(s1).append("lol").append(s2);
                    result.add(sb.toString());
                }
            }
            return result;
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
            System.out.println();
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
        if(r==0)
            return;

        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r);

        printCombination(arr, n, r-1);
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        printCombination(arr, n, r);
    }
}

class ShortestPath
{
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V=9;
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" tt "+dist[i]);
    }

    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
        printSolution(dist, V);
    }

    // Driver method
    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        ShortestPath t = new ShortestPath();
        //outputs distances from each source to verticie
        t.dijkstra(graph, 0);
    }
}