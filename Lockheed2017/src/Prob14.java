import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by respe on 9/18/2018.
 */
public class Prob14 {
    public static void main(String[] args) throws Exception{
        Scanner kb = new Scanner(new File("JudgingInputs/Prob14.in.txt"));

        int runs = kb.nextInt(); kb.nextLine();
        Level firstLevel = new Level(null);

        for(int y= 0; y<runs; y++) {
            String line = kb.nextLine();
            String parent = line.split(",")[1];
            String product = line.split(",")[0];

            if(parent.equals("None"))
                firstLevel.addProduct(product,parent);
            else
                firstLevel.addProductChain(product,parent);
        }
        Collections.sort(firstLevel.products);
        for(int x =0; x<firstLevel.products.size(); x++){
            firstLevel.printChildren(firstLevel.products.get(x),"");
        }


    }
}
class Level{
    ArrayList<String> parents;
     ArrayList<String> products;
     Level next;

    public Level(Level next) {
        this.products = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.next = next;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }

    public Level getNext() {
        return next;
    }

    public void setNext(Level next) {
        this.next = next;
    }

    public ArrayList<String> getParents() {
        return parents;
    }

    public void setParents(ArrayList<String> parents) {
        this.parents = parents;
    }

    public void addProductChain(String product, String parent) {
        if(next == null){
            next = new Level(null);
        }
        if(isInLevel(parent)){

            next.addProduct(product,parent);

        }
        else{
            next.addProductChain(product,parent);
        }
    }

    public void addProduct(String product, String parent){
            parents.add(0, parent);
            products.add(0, product);
    }

    public boolean isInLevel(String prod){
        return products.contains(prod);
    }
    public void printChildren(String product, String dash) {
        System.out.println(dash+product);
        if(next!=null){
            ArrayList<String> alphaProducts = new ArrayList<>();
            for(int y = 0; y<next.parents.size(); y++){
                if(next.parents.get(y).equals(product)) {
                    alphaProducts.add(next.products.get(y));
                }
            }
            Collections.sort(alphaProducts);
            for(int x = 0; x < alphaProducts.size(); x ++) {
                printChildren(alphaProducts.get(x), dash+"-");
            }
        }
    }
}
