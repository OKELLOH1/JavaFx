package food_ordering;

import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import food_ordering.Classes.MenuItem;
import food_ordering.Classes.Order;
import food_ordering.Classes.PaymentService;
import food_ordering.Classes.Restaurant;

public class menuController {

    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    private PaymentService payment = new PaymentService();

    public void addSampleData() {
        // Add sample restaurants and menu items
        Restaurant restaurant1 = new Restaurant("Pizza Palace", "123 Main St", "555-555-5557");
        restaurant1.addMenuItem(new MenuItem("Pepperoni Pizza", 12.99));
        restaurant1.addMenuItem(new MenuItem("Cheese Pizza", 10.99));
        restaurant1.addMenuItem(new MenuItem("Veggie Pizza", 14.99));
        this.restaurants.add(restaurant1);

        Restaurant restaurant2 = new Restaurant("Sushi House", "456 Park Ave", "555-555-5558");
        restaurant2.addMenuItem(new MenuItem("California Roll", 8.99));
        restaurant2.addMenuItem(new MenuItem("Spicy Tuna Roll", 9.99));
        restaurant2.addMenuItem(new MenuItem("Dragon Roll", 12.99));
        this.restaurants.add(restaurant2);
    }

    @FXML
    GridPane restaurantGrid;

    @FXML
    public void initialize() {
        addSampleData();
        restaurantGrid.getChildren().clear();
        for (int i = 0; i < restaurants.size(); i++) {
            restaurantGrid.add(restView(restaurants.get(i)), 0, i);
        }
    }

    private GridPane restView(Restaurant rest) {
        VBox layout = new VBox();
        layout.setBackground(new Background(new BackgroundFill(Color.rgb(245, 248, 223), null, null)));
        Label restName = new Label(rest.getName());
        Label restAddress = new Label(rest.getAddress());
        
        layout.getChildren().addAll(restName, restAddress);
        layout.setPrefWidth(70);

        VBox menu = new VBox();
        for (MenuItem item : rest.getMenu()) {
            menu.getChildren().add(menuView(item, rest));
            menu.getChildren().add(new Separator(Orientation.HORIZONTAL));      
        }

        GridPane overall = new GridPane();
        overall.add(layout, 0, 0);
        overall.add(menu, 1, 0);
        return overall;
    }

    private HBox menuView(MenuItem item, Restaurant rest){
        HBox menuBox = new HBox();
        menuBox.setSpacing(3);

        Label foodName = new Label(item.getName());
        foodName.setPrefWidth(90);

        Label foodPrice = new Label("$" + item.getPrice());
        foodPrice.setPrefWidth(40);

        Button addToCart = new Button("Add to Cart");
        Order order = new Order(rest, item, payment);

        addToCart.setUserData(order);
        addToCart.setOnAction(event -> {
            // System.out.println("clicked ");
            shoppingCart cart = shoppingCart.getInstance();
            cart.addProduct(order);
        });
        menuBox.getChildren().addAll(foodName, foodPrice, addToCart);
        return menuBox;
    }

    //
    // public void setUser(Customer user){
    //     this.user = user;
    // }
}
