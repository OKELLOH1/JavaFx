package food_ordering;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SignInController {

    private String username = "Admin";
    private String password = "1234";

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    void SignIn(ActionEvent event) {
        if (userNameField.getText().trim().equals(username) && passwordField.getText().trim().equals(password)) {
            System.out.println("log in successful");
            proceed(event);
        } else {
            System.out.println("Cant log in");
        }
    }

    public void proceed(ActionEvent e) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHome.fxml"));
        try {
            root = loader.load();
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            AdminHome ahc = loader.getController();
            ahc.start();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
