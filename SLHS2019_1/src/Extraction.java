import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Extraction {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("extraction.in"));

        //datasets
        int dataSets = kb.nextInt(); kb.nextLine();

        for(int x =0; x<dataSets;x++) {
            //rows and col
            int rows = kb.nextInt();
            int columns = kb.nextInt();
            int time = kb.nextInt();
            kb.nextLine();

            int r_m = -1, c_m = -1, r_s = -1, c_s = -1, r_j = -1, c_j = -1, r_c = -1, c_c = -1;

            char[][] theMaze = new char[rows][columns];

            //make maze
            for (int i = 0; i < rows; i++) {
                char[] rowi = kb.nextLine().toCharArray();
                for (int i1 = 0; i1 < rowi.length; i1++) {
                    if(rowi[i1] == 'M') {
                        r_m = i; c_m = i1;
                    }
                    if(rowi[i1] == 'S') {
                        r_s = i; c_s = i1;
                    }
                    if(rowi[i1] == 'J') {
                        r_j = i; c_j = i1;
                    }
                    if(rowi[i1] == 'C') {
                        r_c = i; c_c = i1;
                    }


                }
                theMaze[i] = rowi;
            }

            int t_c = BFS( theMaze, r_s, c_s, r_c, c_c );
            int t_m = BFS( theMaze, r_c, c_c, r_m, c_m );
            int t_j = BFS( theMaze, r_m, c_m, r_j, c_j );


            int timeTaken =  t_c + t_m + t_j;

            if(timeTaken < time && t_c!=-1 && t_m!=-1 && t_j!=-1) {
                System.out.println("Mission Success! 212!");
            }
            else
                System.out.println("Glory to Stroudonia...");






        }
    }

    // Below arrays details all 4 possible movements from a cell
    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    // Function to check if it is possible to go to position (row, col)
    // from current position. The function returns false if (row, col)
    // is not a valid position or has value 0 or it is already visited
    private static boolean isValid(char mat[][], boolean visited[][], int row, int col)
    {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] != '#' && !visited[row][col];
    }

    // Find Shortest Possible Route in a matrix mat from source
    // cell (i, j) to destination cell (x, y)
    private static int BFS(char mat[][], int i, int j, int x, int y)
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
}
