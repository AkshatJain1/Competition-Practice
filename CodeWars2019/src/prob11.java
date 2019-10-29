import java.util.ArrayDeque;
import java.util.Queue;

public class prob11 {

    public static final int row[]= {1, 0, -1, 0};
    public static final int col[]= {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BFS(new char[][] {{'o', '#', 'o'},
                          {'o', '#', 'o'},
                          {'o', 'o', 'o'}},
                0,0,2,2);
    }

    public static int BFS(char[][] mat, int i, int j, int x, int y) {
        Queue<Node> q = new ArrayDeque<>();

        q.add(new Node(i, j, 0));

        int min_dist = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            Node n = q.poll();

            i = n.x;
            j = n.y;
            int dist = n.dist;

            if(i == x && j == y) {
                if(min_dist< dist) {
                    min_dist = dist;
                }
            }

            for(int k = 0; k < row.length; k++) {
                if(isValid(mat,i + row[k], j + row[k])) {
                    q.add(new Node(i + row[k], j + row[k], dist++));
                }
            }
        }
        return min_dist;
    }
    public static boolean isValid(char[][] map, int row, int col) {
        return (row >= 0 && row < map.length && col >= 0 && col < map[0].length && map[row][col] != '#');
    }
}

class Node {
    int x, y, dist;

    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}