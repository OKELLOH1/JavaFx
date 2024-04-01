package food_ordering;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import food_ordering.Classes.Order;

public class shoppingCart {

    private static shoppingCart INSTANCE;
    public static shoppingCart getInstance(){
        if(INSTANCE==null){
            INSTANCE = new shoppingCart();
            return INSTANCE;
        }
        return INSTANCE;
    }

    private Map<String, Order> entries;

    public shoppingCart(){
        this.entries = new HashMap<>();
    }

    public void addProduct(Order order){
        Order productEntry = entries.get(order.getItem().getName().toUpperCase());
        if(productEntry != null){
            productEntry.addItem();
        } else{
            entries.put(order.getItem().getName().toUpperCase(), order);
        }
    }
    public void removeProduct(Order order){
        Order productEntry = entries.get(order.getItem().getName().toUpperCase());
        if(productEntry != null){
            productEntry.removeItem();
            if(productEntry.getQuantity() == 0){
                entries.remove(order.getItem().getName().toUpperCase());
            };

        }
    }
    public int getQuantity(Order order){
        Order productEntry = entries.get(order.getItem().getName().toUpperCase());
        if(productEntry != null){
            return productEntry.getQuantity();
        }
        return 0;
    }
    public double calculateTotal(){
        double total = 0;
        for (Order order : entries.values()) {
            total += order.getTotalCost();
        } 
        return total;
    }
    public List<Order> getEntries(){
        return new ArrayList<>(entries.values());
    }
    public void clearEntries(){
        entries.clear();
    }
}
