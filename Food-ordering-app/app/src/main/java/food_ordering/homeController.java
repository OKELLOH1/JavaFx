package food_ordering;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import food_ordering.Classes.MenuItem;
import food_ordering.Classes.Restaurant;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class homeController {
    @FXML
    private VBox contentPane;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    public void initialize() {
        List<Restaurant> restList = restaurantsList.getInstance().getRestaurants();
        contentPane.getChildren().clear();
        if (restList.isEmpty()) {
            Label noRests = new Label("No restaurants in the database");
            Button addSample = new Button("add sample data");
            addSample.setAlignment(Pos.CENTER);
            addSample.setOnAction(e -> {
                for (Restaurant rest : addSampleData()) {
                    restaurantsList rList = restaurantsList.getInstance();
                    rList.addRest(rest);
                }
                initialize();
            });
            contentPane.getChildren().addAll(noRests, addSample);
            contentPane.setSpacing(250);
        } else {
            for (Restaurant rest : restList) {
                contentPane.setSpacing(5);
                contentPane.getChildren().add(entryView(rest));
            }
        }
    }

    private HBox entryView(Restaurant rest) {
        HBox itemBox = new HBox();
        itemBox.setBackground(new Background(new BackgroundFill(Color.rgb(245, 245, 220), null, null)));

        // Continue from here

        VBox leftSide = new VBox();
        Label restLabel = new Label(rest.getName());
        Label restAdd = new Label(rest.getAddress());
        Button addMenuBtn = new Button("Add Item");
        leftSide.getChildren().addAll(restLabel, restAdd, addMenuBtn);
        leftSide.setPrefWidth(70);
        leftSide.setSpacing(5);

        addMenuBtn.setOnAction(event -> {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            VBox dialogVbox = new VBox(5);
            dialogVbox.setStyle("-fx-padding: 20px;");
            Label message = new Label();
            Label name = new Label("Name");
            TextField nameField = new TextField();
            Label price = new Label("Price");
            NumberTextField priceField = new NumberTextField();


            dialogVbox.getChildren().addAll(message, name, nameField, price, priceField);
            Button exitButton = new Button("Add");
            exitButton.setOnAction(e -> {
                if(nameField.getText().trim().isEmpty() || priceField.getText().trim().isEmpty()){
                    message.setText("Entry fields can't be empty!");
                    message.setBackground(new Background(new BackgroundFill(Color.rgb(220, 80, 60), null, null)));
                } else {
                    MenuItem mItem = new MenuItem(nameField.getText(), Float.parseFloat(priceField.getText()));
                    restaurantsList.getInstance().addItem(mItem, rest);
                    initialize();
                    dialog.close();
                }
            });
            dialogVbox.getChildren().add(exitButton);
            Scene dialogScene = new Scene(dialogVbox, 250, 210);
            dialog.setScene(dialogScene);
            dialog.show();
        });

        Separator sep1 = new Separator();
        sep1.setOrientation(Orientation.VERTICAL);
        Separator sep2 = new Separator();
        sep2.setOrientation(Orientation.VERTICAL);

        VBox centerSide = new VBox();
        for (MenuItem item : rest.getMenu()) {
            centerSide.getChildren().add(menuView(item, rest));
            centerSide.getChildren().add(new Separator(Orientation.HORIZONTAL));
        }
        centerSide.setPrefWidth(160);

        VBox rightSide = new VBox();
        Button updateBtn = new Button("Update");
        updateBtn.setPrefWidth(60);

        updateBtn.setOnAction(event -> {
            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            VBox dialogVbox = new VBox(5);
            dialogVbox.setStyle("-fx-padding: 20px;");

            Label message = new Label("Leave empty for no change");
            message.setBackground(new Background(new BackgroundFill(Color.rgb(245, 245, 220), null, null)));
            Label name = new Label("Name");
            TextField nameField = new TextField();
            Label address = new Label("Address");
            TextField addressField = new TextField();
            Label phone = new Label("Phone number:");
            NumberTextField phoneField = new NumberTextField();
            dialogVbox.getChildren().addAll(message, name, nameField, address, addressField, phone, phoneField);

            Button exitButton = new Button("Add");
            exitButton.setOnAction(e -> {
                restaurantsList.getInstance().removeRest(rest);
                if(!nameField.getText().trim().isEmpty()){
                    rest.setName(nameField.getText().trim());
                }
                if(!addressField.getText().trim().isEmpty()){
                    rest.setAddress(addressField.getText().trim());
                }
                if(!phoneField.getText().trim().isEmpty()){
                    rest.setPhone(phoneField.getText().trim());
                }

                restaurantsList.getInstance().addRest(rest);
                initialize();
                dialog.close();
            });
            dialogVbox.getChildren().add(exitButton);
            Scene dialogScene = new Scene(dialogVbox, 250, 280);
            dialog.setScene(dialogScene);
            dialog.show();

        });

        Button delButton = new Button("Delete");
        delButton.setPrefWidth(60);

        delButton.setOnAction(e -> {
            restaurantsList.getInstance().removeRest(rest);
            initialize();
        });

        rightSide.getChildren().addAll(updateBtn, delButton);

        itemBox.getChildren().addAll(leftSide, sep1, centerSide, sep2, rightSide);
        return itemBox;
    }

    private HBox menuView(MenuItem item, Restaurant rest) {
        HBox menuBox = new HBox();
        menuBox.setSpacing(8);
        // menuBox.setBackground(new Background(new BackgroundFill(Color.rgb(205, 205,
        // 220), null, null)));
        Label itemName = new Label(item.getName());
        itemName.setPrefWidth(90);
        Label itemPrice = new Label(df.format(item.getPrice()));
        itemPrice.setPrefWidth(30);

        Image icon = new Image("trash.png");
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(15);
        iconView.setPreserveRatio(true);

        Button removeItem = new Button();
        removeItem.setPadding(new Insets(3));
        removeItem.setGraphic(iconView);

        removeItem.setOnAction(event -> {
            System.out.println("removing item");
            restaurantsList.getInstance().removeItem(item, rest);
            restaurantsList.getInstance().printRest();
            initialize();
        });

        menuBox.getChildren().addAll(itemName, itemPrice, removeItem);
        return menuBox;
    }

    public List<Restaurant> addSampleData() {
        // Add sample restaurants and menu items
        Restaurant restaurant1 = new Restaurant("Pizza Palace", "123 Main St", "555-555-5557");
        restaurant1.addMenuItem(new MenuItem("Pepperoni Pizza", 12.99));
        restaurant1.addMenuItem(new MenuItem("Cheese Pizza", 10.99));
        restaurant1.addMenuItem(new MenuItem("Pepperoni Pizza", 12.99));
        restaurant1.addMenuItem(new MenuItem("Cheese Pizza", 10.99));
        restaurant1.addMenuItem(new MenuItem("Veggie Pizza", 14.99));

        Restaurant restaurant2 = new Restaurant("Sushi House", "456 Park Ave", "555-555-5558");
        restaurant2.addMenuItem(new MenuItem("California Roll", 8.99));
        restaurant2.addMenuItem(new MenuItem("Spicy Tuna Roll", 9.99));
        restaurant2.addMenuItem(new MenuItem("Dragon Roll", 12.99));

        List<Restaurant> resList = new ArrayList<>();
        resList.add(restaurant1);
        resList.add(restaurant2);
        return resList;
    }
}
