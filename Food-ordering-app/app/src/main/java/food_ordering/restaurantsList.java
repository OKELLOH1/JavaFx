package food_ordering;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import food_ordering.Classes.MenuItem;
import food_ordering.Classes.Restaurant;

public class restaurantsList {
    private static int count = 0;
    private static restaurantsList INSTANCE;
    public static restaurantsList getInstance(){
        if(INSTANCE == null){
            INSTANCE = new restaurantsList();
            count++;
            return INSTANCE;
        }
        return INSTANCE;
    }

    private Map<String, Restaurant> entries;

    public restaurantsList(){
        this.entries = new HashMap<>();
    }

    public void addRest(Restaurant rest){
        Restaurant restEntry = entries.get(rest.getName().trim().toUpperCase());
        if(restEntry != null){
            System.out.println("restaurant already exists");
        } else {
            entries.put(rest.getName().trim().toUpperCase(), rest);
        }
    }
    public void removeRest(Restaurant rest){
        Restaurant restEntry = entries.get(rest.getName().trim().toUpperCase());

        if(restEntry != null){
            entries.remove(restEntry.getName().trim().toUpperCase());
        }
    }

    public void addItem(MenuItem item, Restaurant rest){
        rest.addMenuItem(item);
        entries.put(rest.getName().trim().toUpperCase(), rest);
    }

    public void removeItem(MenuItem item, Restaurant rest){
        rest.removeMenuItem(item);
        entries.put(rest.getName().trim().toUpperCase(), rest);
    }

    public List<Restaurant> getRestaurants(){
        return new ArrayList<>(entries.values());
    }
    public void clearRestaurants(){
        entries.clear();
    }

    public void printRest(){
        for (Restaurant rest : entries.values()) {
            rest.displayRestaurantInfo();
            rest.displayMenu();
        }
    }
    public static boolean start(){
        return count==0 ? true : false;
    }
}
