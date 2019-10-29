import java.util.*;
import java.io.*;

public class UniquePaths {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("uniquepaths.dat"));

        String[] goal = kb.nextLine().split(" to ");
        int source = goal[0].charAt(0) - 'A', end = goal[1].charAt(0) - 'A';

        ArrayList<NodeN> n = new ArrayList<>();
        for (int i = source; i <= end; i++) {
            n.add(new NodeN(i,new ArrayList<>()));
        }
        while(kb.hasNextLine()) {
            String[] l = kb.nextLine().split("-");
            int a = l[0].charAt(0) - 'A', b = l[1].charAt(0) - 'A';
            n.get(a).add(n.get(b));
        }

        n.get(0).findPath(end);

        System.out.println("The number of unique paths connecting the two cities is " + NodeN.paths + ".");
    }
}
class NodeN {
    private int label;
    private ArrayList<NodeN> conn;
    public static int paths = 0;

    public NodeN(int label, ArrayList<NodeN> conn) {
        this.label = label;
        this.conn = conn;
    }
    public void add(NodeN n) {
        conn.add(n);
    }

    public void findPath(int goal) {
        if(label == goal)
            paths++;
        for (int i = 0; i < conn.size(); i++) {
            conn.get(i).findPath(goal);
        }
    }
}