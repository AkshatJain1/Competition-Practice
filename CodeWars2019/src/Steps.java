public class Steps {
    public static void main(String[] args) {
        System.out.println(num_ways(40, new int[] {1,3,5}));
    }
    public static int num_ways(int n, int[] x) {
        if(n==0) {
            return 1;
        }
        else if(n < 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum+= num_ways(n-x[i], x);
        }
        return sum;
    }
}
