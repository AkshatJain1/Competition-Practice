import java.util.*;
import java.io.*;
public class Marble {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(new File("marble.dat"));

        while(kb.hasNextLine()) {
            String m = kb.nextLine();
            Scanner k = new Scanner(m);
            int[] marbles  = new int[m.split(" ").length];
            for(int i = 0; i < marbles.length; i++) {
                marbles[i] = k.nextInt();
            }
            System.out.print("FF:  ");
            firstFit(marbles);

            System.out.print("FFI:  ");
            firstFitIncreasing(marbles);

            System.out.print("FFD:  ");
            firstFitDecreasing(marbles);

            System.out.print("BF:  ");
            bestFit(marbles);

            System.out.print("WF:  ");
            worstFit(marbles);

        }
    }
    public static void firstFit(int[] marble){

        int[] bins = new int[25];
        int[] marbles = new int[marble.length];
        for (int i = 0; i < marble.length; i++) {
            marbles[i] = marble[i];
        }

        for (int i = 0; i < marbles.length; i++) {
            int binCounter = 0;
            while(true) {
                if(bins[binCounter] + marbles[i] <= 10) {
                    bins[binCounter] += marbles[i];
                    break;
                }
                binCounter++;
            }
        }


        for (int i = 0; i < bins.length; i++) {
            if(bins[i]!=0) {
                System.out.print( bins[i] + " ");
            }
        }
        System.out.println();
    }
    public static void firstFitIncreasing(int[] marble) {
        int[] marbles = new int[marble.length];
        for (int i = 0; i < marble.length; i++) {
            marbles[i] = marble[i];
        }

        ArrayList<Integer> m = new ArrayList<>();

        for (int i = 0; i < marbles.length; i++) {
            m.add(marbles[i]);
        }
        Collections.sort(m);

        for (int i = 0; i < m.size(); i++) {
            marbles[i] = m.get(i);
        }

        firstFit(marbles);

    }
    public static void firstFitDecreasing(int[] marble) {
        int[] marbles = new int[marble.length];
        for (int i = 0; i < marble.length; i++) {
            marbles[i] = marble[i];
        }

        ArrayList<Integer> m = new ArrayList<>();

        for (int i = 0; i < marbles.length; i++) {
            m.add(marbles[i]);
        }
        Collections.sort(m);
        Collections.reverse(m);

        for (int i = 0; i < m.size(); i++) {
            marbles[i] = m.get(i);
        }

        firstFit(marbles);
    }
    public static void bestFit(int[] marble){

        int[] bins = new int[25];
        int[] marbles = new int[marble.length];
        for (int i = 0; i < marble.length; i++) {
            marbles[i] = marble[i];
        }

        for (int i = 0; i < marbles.length; i++) {
            int binIn = -1; int heavyBin = Integer.MIN_VALUE;
            for (int i1 = 0; i1 < bins.length; i1++) {
                if(bins[i1] + marbles[i] > heavyBin && bins[i1] + marbles[i] <= 10) {
                    binIn = i1;
                    heavyBin = bins[i1] + marbles[i];
                }
            }
            bins[binIn] += marbles[i];
        }


        for (int i = 0; i < bins.length; i++) {
            if(bins[i]!=0) {
                System.out.print( bins[i] + " ");
            }
        }
        System.out.println();
    }
    public static void worstFit(int[] marble){

        int[] bins = new int[25];
        int[] marbles = new int[marble.length];
        for (int i = 0; i < marble.length; i++) {
            marbles[i] = marble[i];
        }

        for (int i = 0; i < marbles.length; i++) {
            int binIn = -1; int heavyBin = Integer.MAX_VALUE;
            for (int i1 = 0; i1 < bins.length; i1++) {
                boolean canPut = true;
                if(bins[i1] == 0) {
                    for (int i2 = 0; i2 < i1; i2++) {
                        if (marbles[i] + bins[i2] <= 10)
                            canPut = false;
                    }
                }

                if(bins[i1] + marbles[i] < heavyBin && bins[i1] + marbles[i] <= 10 &&  canPut) {
                    binIn = i1;
                    heavyBin = bins[i1] + marbles[i];
                }
            }
            bins[binIn] += marbles[i];
        }


        for (int i = 0; i < bins.length; i++) {
            if(bins[i]!=0) {
                System.out.print( bins[i] + " ");
            }
        }
        System.out.println();
        System.out.println();
    }

    
}