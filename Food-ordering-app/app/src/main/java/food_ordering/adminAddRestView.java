package food_ordering;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class adminAddRestView {
    private Parent view;

    public adminAddRestView() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("addRest.fxml"));
        this.view = root;
    }
    public Parent getView() {
        return view;
    }
}
