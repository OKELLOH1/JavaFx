package food_ordering;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class AdminHome {

    @FXML
    private Button addRestBtn;

    @FXML
    private Label nameLabel;

    @FXML
    private BorderPane content;

    @FXML
    void addRestaurant(ActionEvent event) {
        System.out.println("adding Restaurant clicked");
    }

    public void start() throws IOException{
        this.showAdminHome();
    }

    public void showAdminHome() throws IOException {
        content.setCenter(new adminHomeView().getView());
    }
    public void showAddRestView() throws IOException{
        content.setCenter(new adminAddRestView().getView()); 
    }
}
