import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface ProductIterator extends Iterator<Product> {
    @Override
    boolean hasNext();
    @Override
    Product next();
}

class ProductList implements Iterable<Product> {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public Iterator<Product> iterator() {
        return new ConcreteProductIterator(products);
    }
}

class ConcreteProductIterator implements ProductIterator {
    private List<Product> products;
    private int index = 0;

    public ConcreteProductIterator(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return index < products.size();
    }

    @Override
    public Product next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        Product product = products.get(index);
        index++;
        return product;
    }
}

class Product {
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + description + " - $" + price;
    }
}

public class MainIterator {
    public static void main(String[] args) {
        ProductList productList = new ProductList();
        productList.addProduct(new Product("Chair", "A comfortable chair", 50.0));
        productList.addProduct(new Product("Table", "A sturdy table", 100.0));
        productList.addProduct(new Product("Sofa", "A cozy sofa", 200.0));

        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
