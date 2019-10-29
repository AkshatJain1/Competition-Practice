import java.io.File;
import java.util.*;

public class RunningLate {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("late.in"));
        char[][] map = new char[7][5];
        for (int i = 0; i < map.length; i++) {
            map[i] = kb.nextLine().replaceAll(" ","").toCharArray();
        }

        int time = kb.nextInt();

        int rr = 0, rc = 0, br = 0, bc = 0, jr = 0, jc = 0, tr = 0, tc = 0;

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                if(map[r][c] == 'R'){
                    rr = r;
                    rc = c;
                }
                if(map[r][c] == 'B'){
                    br = r;
                    bc = c;
                }
                if(map[r][c] == 'J'){
                    jr = r;
                    jc = c;
                }
                if(map[r][c] == 'T'){
                    tr = r;
                    tc = c;
                }
            }
        }

        int dist = BFS(map,br,bc,rr,rc) + BFS(map,rr,rc,jr,jc) + BFS(map,jr,jc,tr,tc) - 5;
        int dist2 = BFS(map, br,bc,jr,jc) + BFS(map,jr,jc,rr,rc) + BFS(map,rr,rc,tr,tc) - 5;
        int dist4 = BFS(map,br,bc,rr,rc) + BFS(map,rr,rc,tr,tc);

        int t = dist<=dist2 && dist<=dist4 ? dist : dist2<=dist && dist2<=dist4? dist2:dist4;
        System.out.println(t);
        System.out.println(time<t?"Donald is cut from the team":"Donald lucked out");


    }
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
class Postition {
    int row, col;
    public Postition(int row, int col) {
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
    ArrayList<Postition> postitions;

    Node(int x, int y, int dist,ArrayList<Character> pathTaken, ArrayList<Postition> postitions) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.pathTaken = pathTaken;
        this.postitions = postitions;
    }

    public boolean visited(int r, int c) {
        for (int i = 0; i < postitions.size(); i++) {
            if(postitions.get(i).row == r && postitions.get(i).col == c)
                return true;
        }
        return false;
    }

}