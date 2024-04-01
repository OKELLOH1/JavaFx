package food_ordering;

import food_ordering.Classes.Restaurant;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class addRestController {

    @FXML
    private Button addBtn;

    @FXML
    private TextField restAdd;

    @FXML
    private TextField restName;

    @FXML
    private TextField restPhone;

    @FXML
    private Label message;

    public void addRest() {
        System.out.println("Add restaurant fired");
        if (restAdd.getText().trim().isEmpty() || restName.getText().trim().isEmpty()
                || restPhone.getText().trim().isEmpty()) {
            message.setText("Entry fields can't be empty!");
            message.setBackground(new Background(new BackgroundFill(Color.rgb(220, 80, 60), null, null)));
        } else{
            message.setText("Successfully added!");
            message.setBackground(new Background(new BackgroundFill(Color.rgb(40, 220, 60), null, null)));
            restaurantsList restList = restaurantsList.getInstance();
            Restaurant rest = new Restaurant(restName.getText(), restAdd.getText(), restPhone.getText());
            restList.addRest(rest);
            restList.printRest();
        }
    }
}
