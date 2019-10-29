public class Test {
public static void main(String[] args) {
        Test obj = new Test();
        obj.start();
        }
        public static void start() {
        String stra = "do";
        String strb = method(stra);
        System.out.print(": "+stra + strb);
        }
        public static String method(String stra) {
        stra = stra + "good";
        System.out.print(stra);
        return" good";
        }
}