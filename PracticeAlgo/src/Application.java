import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) throws FileNotFoundException {
        Products products = new Products();

        FileReader fileReader = new FileReader("info.txt");
        Scanner sc = new Scanner(fileReader);
        while (sc.hasNext()) {
            String value = sc.next();
            String words[] = value.split(">");
            process(words, products);
        }
    }

    private static void getcountthepraticuluarlevle(Products products, int level, int count)
    {


    }

    private static void process(String[] words, Products products) {
        for (int i = 0; i < words.length - 1; i++) {
            Products products1 = getlevel(products, i, 0, words[i]);
            if (i == words.length - 2) {
                Products pr = new Products();
                pr.setName(words[words.length - 2]);
                pr.setLeaf(true);
                pr.setTotal_count(Integer.parseInt(words[words.length - 1]));
                products1.setProduct(pr);
            }
          else  if (getlevel(products, i, 0, words[i]) != null) {
                ArrayList<Products> product = products1.getProduct();
                Products pr = new Products();
                pr.setName(words[i]);
                product.add(pr);

            }

        }
    }

    static Products getlevel(Products products, int level, int count, String name) {
        if (products.isLeaf() == true && count != level) {
            return null;
        }
        if (level == count) {
            for (int i = 0; i < products.getProduct().size(); i++) {
                if (products.getProduct().get(i).equals(name)) {
                    return products.getProduct().get(i);
                }
            }
        }
        Products pr = null;
        for (int i = 0; i < products.product.size(); i++) {
            pr = getlevel(products.product.get(i), level, count + 1, name);
            if (pr != null) {
                return pr;
            }
        }
        return pr;


    }

}
