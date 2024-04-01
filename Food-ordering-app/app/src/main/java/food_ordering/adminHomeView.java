package food_ordering;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class adminHomeView {
    private Parent view;

    public adminHomeView() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        this.view = root;
    }
    public Parent getView() {
        return view;
    }
}
