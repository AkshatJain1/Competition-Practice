import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

import java.io.File;

public class Cruise {

    public static int depth;

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("cruise-1.dat"));

        int r = Integer.parseInt(kb.nextLine());

        for (int i = 0; i < r; i++) {
            int row = kb.nextInt(); int col = kb.nextInt();  depth = kb.nextInt(); kb.nextLine();
            String[][] map = new String[row][col];

            for (int i1 = 0; i1 < row; i1++) {
                String x = kb.nextLine();
                map[i1] = x.split(" ");
            }
            ArrayList<Integer> l_rows = new ArrayList<>();
            ArrayList<Integer> l_cols = new ArrayList<>();
            int s_row = -1,s_col = -1;
            for (int i1 = 0; i1 < map.length; i1++) {
                for (int i2 = 0; i2 < map[0].length; i2++) {
                    if(map[i1][i2].equals("L")) {
                        l_rows.add(i1);
                        l_cols.add(i2);
                    }
                    if(map[i1][i2].equals("S")) {
                        s_row = i1;
                        s_col = i2;
                    }
                }
            }

            int lowestTurns = Integer.MAX_VALUE;
            for (int i1 = 0; i1 < l_rows.size(); i1++) {

                int turns = BFS(map, s_row, s_col, l_rows.get(i1), l_rows.get(i1));
                if(turns!=-1 && lowestTurns>turns) {
                    lowestTurns = turns;
                }
            }

            System.out.println(lowestTurns);


        }



    }
    // Below arrays details all 4 possible movements from a cell
    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    // Function to check if it is possible to go to position (row, col)
    // from current position. The function returns false if (row, col)
    // is not a valid position or has value 0 or it is already visited
    private static boolean isValid(String mat[][], boolean visited[][], int row, int col)
    {
        if((row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length) && !mat[row][col].equals("L") && !mat[row][col].equals("S")) {
            System.out.println("mat row col: " + mat[row][col]);
            System.out.println("Depth: " + depth);
            System.out.println(Integer.parseInt(mat[row][col]) < depth );
        }

        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && !mat[row][col].equals("L") && !mat[row][col].equals("S") && Integer.parseInt(mat[row][col]) < depth   && !visited[row][col];
    }

    // Find Shortest Possible Route in a matrix mat from source
    // cell (i, j) to destination cell (x, y)
    private static int BFS(String mat[][], int i, int j, int x, int y)
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

