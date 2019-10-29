import javax.swing.text.Position;
import java.util.*;
import java.io.*;
public class Quest {
    // Below arrays details all 4 possible movements from a cell
    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("quest.dat"));
        int sets = kb.nextInt(); kb.nextLine();
        for (int i = 0; i < sets; i++) {
            char[][] map = new char[10][10];
            int sr = 0, sc = 0, er = 0, ec = 0, kr = 0, kc = 0;
            for (int i1 = 0; i1 < map.length; i1++) {
                char[] d = kb.nextLine().toCharArray();
                for (int i2 = 0; i2 < d.length; i2++) {
                    if(d[i2] == 'A'){
                        sr = i1;
                        sc = i2;
                    }
                    if(d[i2] == 'H'){
                        er = i1;
                        ec = i2;
                    }
                    if(d[i2] == 'K'){
                        kr = i1;
                        kc = i2;
                    }
                }
                map[i1] = d;
            }
            if(kb.hasNextLine())
                kb.nextLine();

            ArrayList<Postition> pos = BFS(map, sr, sc, er, ec, kr, kc);
            for (int i1 = 0; i1 < pos.size(); i1++) {
                map[pos.get(i1).row][pos.get(i1).col] = 'O';
            }
            for (int i1 = 0; i1 < map.length; i1++) {
                for (int i2 = 0; i2 < map[0].length; i2++) {
                    System.out.print(map[i1][i2] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static boolean isValid(char mat[][], Node n, int row, int col, int frow, int fcol)
    {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] != '#' && !n.visited(row, col) && killer(row, col, frow, fcol);
    }
    public static boolean killer(int row, int col, int frow, int fcol) {
        if(col==fcol) {
            if (row + 1 == frow || row - 1 == frow)
                return false;
        }
        else if(row == frow) {
            if (col + 1 == fcol || col - 1 == fcol)
                return false;
        }
        return true;
    }
    // Find Shortest Possible Route in a matrix mat from source
    // cell (i, j) to destination cell (x, y)
    public static ArrayList<Postition> BFS(char mat[][], int i, int j, int x, int y, int o, int p)
    {

        // create an empty queue
        Queue<Node> q = new ArrayDeque<>();

        ArrayList<Character> path = new ArrayList();
        // mark source cell as visited and enqueue the source node

        ArrayList<Postition> pos = new ArrayList<>();


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
                    pos = node.postitions;
                }
                break;
            }

            // check for all 4 possible movements from current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++)
            {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (isValid(mat, node, i + row[k], j + col[k],o,p))
                {
                    int d = 1;

                    q.add(new Node(i + row[k], j + col[k], dist+d, (ArrayList<Character>)node.pathTaken.clone(), (ArrayList<Postition>)node.postitions.clone()));
                }
            }
        }
        //remove start and end
        if(path.size()>1){
            path.remove(0);
            path.remove(path.size()-1);
        }
        if(pos.size()>1){
            pos.remove(0);
            pos.remove(pos.size()-1);
        }
        //return path or min_dist
//        return min_dist == Integer.MAX_VALUE ? -1 : min_dist;
        return pos;
    }
}