package food_ordering;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class menuView {
    private Parent view;

    public menuView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menuGrid.fxml"));
        this.view = root;
    }

    public Parent getView() {
        return view;
    }
}
