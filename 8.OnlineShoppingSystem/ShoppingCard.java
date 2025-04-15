import java.util.HashMap;
import java.util.Map;

public class ShoppingCard {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }
    public void removeProduct(Product product){
       items.remove(product);
    }
    public void updateProductQuantity(Product product, int quantity) {
        if (quantity <= 0) removeProduct(product);
        else items.put(product, quantity);
    }
    public double calculateTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getProductPrice() * entry.getValue();
        }
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clearCart() {
        items.clear();
    }

    public void displayCartContents() {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getProductName() + " x" + entry.getValue());
        }
    }
}
