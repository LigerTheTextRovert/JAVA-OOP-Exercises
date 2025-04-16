import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private ArrayList<Product> currentItems = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        product.setStockCount(quantity);
        currentItems.add(product);
    }

    public void removeProduct(Product product) {
        currentItems.remove(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product p : currentItems) {
            total += p.getProductPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return currentItems.isEmpty();
    }

    public void clearCart() {
        currentItems.clear();
    }

    public void displayCartContents() {
        for (Product p : currentItems) {
            System.out.println("Product :" + p.getProductName() + " | Price :" + p.getProductPrice() + " | Left :" + p.getStockCount());
        }
    }
}
