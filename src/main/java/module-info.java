module com.raderh2o.fxtodo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.raderh2o.fxtodo to javafx.fxml;
    exports com.raderh2o.fxtodo;
}