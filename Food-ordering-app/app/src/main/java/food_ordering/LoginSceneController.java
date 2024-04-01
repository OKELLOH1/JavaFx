package food_ordering;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoginSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToAdminScene(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void switchToCustomerScene(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("customerLogin.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
