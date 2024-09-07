package com.raderh2o.fxtodo;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TodoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TodoApplication.class.getResource("main_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TO-DO LIST");
        stage.setScene(scene);
        stage.show();
    }

    public void startApp() {
        launch();
    }
}