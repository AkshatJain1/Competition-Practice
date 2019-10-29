import java.io.File;

public class Trust {
    public static void main(String[] args) throws Exception {
        java.util.Scanner kb = new java.util.Scanner(new File("trust.in"));
        kb.nextLine();
        while (kb.hasNextLine()) {

            String x = kb.nextLine().toLowerCase();
            String l = "";
            boolean t = false;
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != ' ') {
                    l += x.charAt(i);
                }
                if(t && x.charAt(i)=='f'){

                }

            }

            if (l.contains("forest")) {
                System.out.println("TWO-TWELVE!");
            } else {
                System.out.println("Glory to Stroudonia...");
            }

        }

    }
}
