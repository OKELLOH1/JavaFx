package food_ordering.Classes;
import java.util.*;

import food_ordering.Abstract_Classes.*;

// Restaurant class that inherits from FoodService
public class Restaurant extends FoodService {
    private ArrayList<MenuItem> menu;

    public Restaurant(String name, String address, String phone) {
        super(name, address, phone);
        menu = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(MenuItem item){
        menu.remove(item);
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public void displayMenu() {
        System.out.println("Menu items: ");
        for (MenuItem item : menu) {
            System.out.println("> "+ item.getName() + ": $" + item.getPrice());
        }
    }
    public void displayRestaurantInfo() {
        System.out.println("Restaurant Name: " + getName());
        System.out.println("Restaurant Address: " + getAddress());
        System.out.println("Restaurant Phone Number: " + getPhone());
    }
}
