package com.raderh2o.fxtodo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TodoController {

    @FXML
    TextField todo;

    @FXML
    VBox todoList;

    ArrayList<CheckBox> todos = new ArrayList<>();

    public void initialize() {

        loadTodos();
    }

    public void addTodo() {

        addTodo(todo.getText());
    }

    public void addTodo(String todoText) {

        CheckBox todoBox = new CheckBox();

        VBox.setMargin(todoBox, new Insets(0, 0, 10, 0));

        todoBox.setText(todoText);
        todoBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                todoList.getChildren().remove(todoBox);
                todos.remove(todoBox);
            }
        });

        todoList.getChildren().add(todoBox);
        todos.add(todoBox);
    }

    public void saveTodos() {

        try {
            FileWriter fileWriter = new FileWriter("todos.txt", false);

            String processedTodos = "";
            for (CheckBox todoObject : todos) {
                processedTodos = processedTodos.concat("- [ ] " + todoObject.getText() + "\n");
            }
            fileWriter.write(processedTodos);

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTodos() {

        try (FileReader fileReader = new FileReader("todos.txt")) {

            String line = "";
            int characterRead = -1;

            while ((characterRead = fileReader.read()) != -1) {
                if ((char) characterRead != '\n') {
                    line += Character.toString((char) characterRead);
                } else if (line.length() > 4) {

                    addTodo(line.substring(5));
                    line = "";
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}