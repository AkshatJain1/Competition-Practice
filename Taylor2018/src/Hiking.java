import javax.swing.text.Position;
import java.util.*;
import java.io.*;
public class Hiking {
    // Below arrays details all 4 possible movements from a cell
    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("hiking.dat"));

        for (int x = 0; x <3; x++) {
            char[] line = kb.nextLine().toCharArray();
            int sc = line[2] - '0', sr = line[4] - '0', ec = line[8] - '0', er = line[10] - '0';

            char[][] map = new char[5][5];

            for (int i = 0; i < map.length; i++) {
                map[i] = kb.nextLine().toCharArray();
            }

            System.out.println("Your time to beat is " + BFS(map, sr, sc, er, ec) + "minutes.");
        }

    }

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
            node.postitions.add(new Postition(i,j));

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
                    int d = 0;
                    switch (mat[i][j]) {
                        case 'T':
                            d = 3;
                            break;
                        case 'W':
                            d = 8;
                            break;
                        case 'O':
                            d = 12;
                            break;
                        case 'S':
                            d = 20;
                            break;
                    }

                    q.add(new Node(i + row[k], j + col[k], dist+d, (ArrayList<Character>)node.pathTaken.clone(), (ArrayList<Postition>)node.postitions.clone()));
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

}