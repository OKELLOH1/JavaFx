package food_ordering;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class cartView {
    private Parent view;

    public cartView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cart.fxml"));
        this.view = root;
    }

    public Parent getView() {
        return view;
    }
}
