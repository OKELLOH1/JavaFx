package food_ordering.Classes;
import java.util.*;

public class FoodOrderingApp {
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;
    private PaymentService paymentService;

    public FoodOrderingApp() {
        restaurants = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
        paymentService = new PaymentService();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void addSampleData() {
        // Add sample customers
        customers.add(new Customer("John Doe", "456 Park Ave", "555-555-5555", "john.doe@gmail.com"));

        // Add sample restaurants and menu items
        Restaurant restaurant1 = new Restaurant("Pizza Palace", "123 Main St", "555-555-5557");
        restaurant1.addMenuItem(new MenuItem("Pepperoni Pizza", 12.99));
        restaurant1.addMenuItem(new MenuItem("Cheese Pizza", 10.99));
        restaurant1.addMenuItem(new MenuItem("Veggie Pizza", 14.99));
        restaurants.add(restaurant1);

        Restaurant restaurant2 = new Restaurant("Sushi House", "456 Park Ave", "555-555-5558");
        restaurant2.addMenuItem(new MenuItem("California Roll", 8.99));
        restaurant2.addMenuItem(new MenuItem("Spicy Tuna Roll", 9.99));
        restaurant2.addMenuItem(new MenuItem("Dragon Roll", 12.99));
        restaurants.add(restaurant2);
    }

    public ArrayList<Restaurant> searchRestaurantByName(String name) {
        ArrayList<Restaurant> searchResults = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().toLowerCase().contains(name.toLowerCase())) {
                searchResults.add(restaurant);
            }
        }
        return searchResults;
    }

    public void searchMenu(String keyword) {
        System.out.println("Results for search: " + keyword);
        for (Restaurant restaurant : restaurants) {
            for (MenuItem item : restaurant.getMenu()) {
                if (item.getName().toLowerCase().contains(keyword.toLowerCase()) || item.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println("- " + item.getName() + " at " + restaurant.getName() + ": $" + item.getPrice());
                }
            }
        }
    }

    public void payForAllOrders() {
        for (Order order : orders) {
            if (!order.isPaid()) {
                order.pay();
            }
        }
    }

    // public void run() {
    //     // Add sample data
    //     addSampleData();
    
    //     // Search for menu items
    //     searchMenu("pizza");
    
    //     // Place an order
    //     Customer customer = customers.get(0);
    //     Restaurant restaurant = searchRestaurantByName("pizza palace").get(0);
    //     Order order = new Order(customer, restaurant, paymentService);
    //     order.addItem(restaurant.getMenu().get(0));
    //     order.addItem(restaurant.getMenu().get(1));
    //     order.setDeliveryAddress("123 Main St");
    //     order.pay();
    //     orders.add(order);
    
    //     // Pay for all orders
    //     payForAllOrders();
    // }
    
    public static void main(String[] args) {
        FoodOrderingApp app = new FoodOrderingApp();
        // app.run();
    }
}
