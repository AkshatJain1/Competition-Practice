//import java.lang.reflect.Array;
//import java.util.*;
//import java.io.*;
//public class Clearing {
//    // Below arrays details all 4 possible movements from a cell
//    private static final int row[] = { -1, 0, 0, 1 };
//    private static final int col[] = { 0, -1, 1, 0 };
//
//    public static void main(String[] args) throws Exception {
//        Scanner kb = new Scanner(new File("clearing.dat"));
//
//        while(kb.hasNextLine()) {
//            String line = kb.nextLine();
//            int bombs = Integer.parseInt(line.split(":")[0]);
//            String dim = line.split(":")[1];
//            int cols = Integer.parseInt(dim.split("x")[0]);
//            int rows = Integer.parseInt(dim.split("x")[1]);
//
//            int sr=0,sc=0, er = 0, ec = 0;
//
//            char[][] map = new char[rows][cols];
//            for (int i = 0; i < rows; i++) {
//                map[i] = kb.nextLine().toCharArray();
//            }
//            for (int i = 0; i < map.length; i++) {
//                for (int i1 = 0; i1 < map[i].length; i1++) {
//                    if(map[i][i1] == 'S'){
//                        sr = i;
//                        sc = i1;
//                    }
//                    if(map[i][i1] == 'E'){
//                        er = i;
//                        ec = i1;
//                    }
//                }
//            }
//
//           ArrayList<Character> path = (BFS(map,sr,sc,er,ec));
//
//            for (Character character : path) {
//                if(character == 'R')
//                    bombs--;
//            }
//            if(bombs<0)
//                System.out.println("Delete");
//            else
//                System.out.println("Keep");
//        }
//    }
//
//    public static boolean isValid(char mat[][], boolean visited[][], int row, int col)
//    {
//        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
//                && mat[row][col] != '#' && !visited[row][col];
//    }
//
//    // Find Shortest Possible Route in a matrix mat from source
//    // cell (i, j) to destination cell (x, y)
//    public static ArrayList<Character> BFS(char mat[][], int i, int j, int x, int y)
//    {
//        // construct a matrix to keep track of visited cells
//        boolean[][] visited = new boolean[mat.length][mat[0].length];
//
//        // create an empty queue
//        Queue<Node> q = new ArrayDeque<>();
//
//        ArrayList<Character> path = new ArrayList();
//        // mark source cell as visited and enqueue the source node
//        visited[i][j] = true;
//        q.add(new Node(i, j, 0 ,new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
//
//        // stores length of longest path from source to destination
//        int min_dist = Integer.MAX_VALUE;
//
//        // run till queue is not empty
//        while (!q.isEmpty())
//        {
//            // pop front node from queue and process it
//            Node node = q.poll();
//
//            // (i, j) represents current cell and dist stores its
//            // minimum distance from the source
//            i = node.x;
//            j = node.y;
//            int dist = node.dist;
//
//
//            node.pathTaken.add(mat[i][j]);
//            node.rowsVisited.add(i);
//            node.colsVisited.add(j);
//
//            // if destination is found, update min_dist and stop
//            if (i == x && j == y)
//            {
//                path = node.pathTaken;
//                break;
//            }
//
//            // check for all 4 possible movements from current cell
//            // and enqueue each valid movement
//            for (int k = 0; k < 4; k++)
//            {
//                // check if it is possible to go to position
//                // (i + row[k], j + col[k]) from current position
//                if (isValid(mat, visited, i + row[k], j + col[k]))
//                {
//                    // mark next cell as visited and enqueue it
//                    visited[i + row[k]][j + col[k]] = true;
//                    q.add(new Node(i + row[k], j + col[k], dist+1, (ArrayList<Character>)node.pathTaken.clone(), (ArrayList<Integer>)node.rowsVisited.clone(), (ArrayList<Integer>)node.colsVisited.clone() ));
//                }
//            }
//        }
//        //remove start and end
//        if(path.size()>1){
//            path.remove(0);
//            path.remove(path.size()-1);
//        }
//        return path;
//    }
//}
