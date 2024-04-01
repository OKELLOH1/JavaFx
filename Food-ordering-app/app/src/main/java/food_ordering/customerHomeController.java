package food_ordering;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import food_ordering.Classes.Customer;

public class customerHomeController {
    private static Customer user;
    
    @FXML
    private Label welcomeField;

    @FXML
    private BorderPane content;

    public void setWelcome(String name) {
        welcomeField.setText("Welcome " + name);
    }

    public void setUser(Customer person) throws IOException {
        user = person;
        setWelcome(user.getName());
        this.showHome();
    }
    public static Customer getUser(){
        return user;
    }
    public void showHome() throws IOException {
        content.setCenter(new menuView().getView());
    }
    public void showCart() throws IOException{
        content.setCenter(new cartView().getView());
    }
}
