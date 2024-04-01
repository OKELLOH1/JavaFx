package food_ordering;

import java.io.IOException;

import food_ordering.Classes.Customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class customerLoginController {
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label userWelcome;

    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private Button signUpBtn;

    @FXML
    private Label message;


    @FXML
    void customerSignUp(ActionEvent event) throws IOException {
        if(name.getText().trim().isEmpty() || address.getText().trim().isEmpty() || phone.getText().trim().isEmpty()){
            System.out.println("invalid login");
            message.setText("Required fields can't be empty!");
            message.setBackground(new Background(new BackgroundFill(Color.rgb(220, 80, 60), null, null)));
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerHome.fxml"));
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            customerHomeController chc = loader.getController();
            Customer user = new Customer(name.getText().trim(), address.getText().trim(), phone.getText().trim(), email.getText().trim());
            chc.setUser(user);
    
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
}