import java.util.ArrayList;

public class Products {

    boolean leaf;
    String name;
    int total_count;
    int level;
    ArrayList<Products> product;

    Products() {
        this.product = new ArrayList<>();
    }

    public ArrayList<Products> getProduct() {
        return product;
    }

    public void setProduct(Products products) {
        product.add(products);
        this.product = product;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    int totalcountat(Products products) {
        if (products.leaf) {
            return products.total_count;
        }
        int count = 0;
        for (int i = 0; i < products.getProduct().size(); i++) {
            count = count + totalcountat(products.getProduct().get(i));
        }
        return count;
    }

}


