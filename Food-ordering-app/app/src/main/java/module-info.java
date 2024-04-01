module food_ordering {
    requires javafx.controls;
    requires javafx.fxml;

    opens food_ordering to javafx.fxml;
    exports food_ordering;
}
