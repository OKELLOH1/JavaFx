package food_ordering;

import java.text.DecimalFormat;
import java.util.List;

import food_ordering.Classes.Order;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class cartController {
    @FXML
    private VBox cartPane;

    private Label totalPriceLabel;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    public void initialize() {
        // Populating the cart view
        List<Order> entries = shoppingCart.getInstance().getEntries();
        cartPane.getChildren().clear();
        if (entries.isEmpty()) {
            Label emptyCart = new Label("Your cart is empty");
            cartPane.getChildren().add(emptyCart);
        } else {
            for (Order order : entries) {
                cartPane.getChildren().add(cartEntryView(order));
            }
            Separator sep = new Separator();
            sep.setOrientation(Orientation.HORIZONTAL);
            cartPane.getChildren().add(sep);
            HBox totalPrice = totalView(shoppingCart.getInstance().calculateTotal());
            cartPane.getChildren().add(totalPrice);
            Separator sep2 = new Separator();
            sep2.setOrientation(Orientation.HORIZONTAL);
            cartPane.getChildren().add(sep2);
            HBox buttonLine = new HBox();
            buttonLine.setAlignment(Pos.CENTER_RIGHT);
            Button clearButton = new Button("Check out");
            clearButton.setOnAction(e -> {
                // https://stackoverflow.com/questions/22166610/how-to-create-a-popup-window-in-javafx
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                VBox dialogVbox = new VBox(20);
                dialogVbox.setStyle("-fx-padding: 10px;");
                dialogVbox.getChildren().add(new Label("You have checked out!"));
                dialogVbox.getChildren().add(new Label("Your items are on their way"));
                Button exitButton = new Button("Go back");
                exitButton.setOnAction(event -> {
                    dialog.close();
                });
                dialogVbox.getChildren().add(exitButton);
                Scene dialogScene = new Scene(dialogVbox, 220, 120);
                dialog.setScene(dialogScene);
                dialog.show();
                shoppingCart.getInstance().clearEntries();
                initialize();
            });
            buttonLine.getChildren().add(clearButton);
            cartPane.getChildren().add(buttonLine);
        }
    }

    private HBox totalView(double totalPrice) {
        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER);

        Label totalLabel = new Label("Total: ");
        this.totalPriceLabel = new Label(df.format(totalPrice));

        layout.getChildren().addAll(totalLabel, totalPriceLabel);

        return layout;
    }

    private HBox cartEntryView(Order order) {
        HBox itemDisplay = new HBox();
        Label prodName = new Label(order.getItem().getName());
        prodName.setPrefWidth(100);
        prodName.setStyle("-fx-font-size: 12px; -fx-padding: 5px;");
        Label quantity = new Label("" + order.getQuantity());
        quantity.setPrefWidth(50);
        quantity.setStyle("-fx-padding:5px 15px");
        Button plusbtn = new Button("+");
        plusbtn.setStyle("-fx-padding:5px");
        plusbtn.setPrefWidth(20);
        Button minusbtn = new Button("-");
        minusbtn.setStyle("-fx-padding:5px");
        minusbtn.setPrefWidth(20);
        Label price = new Label(df.format(order.getTotalCost()));
        price.setStyle("-fx-padding:5px 15px");
        itemDisplay.getChildren().addAll(prodName, minusbtn, quantity, plusbtn, price);
        plusbtn.setOnAction(event -> {
            shoppingCart cart = shoppingCart.getInstance();
            cart.addProduct(order);
            initialize();
        });
        minusbtn.setOnAction(event -> {
            shoppingCart cart = shoppingCart.getInstance();
            cart.removeProduct(order);
            initialize();
        });
        return itemDisplay;
    }
}
