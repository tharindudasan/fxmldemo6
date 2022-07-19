package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ComboBoxFormController {
    public ComboBox<Integer> cmbNumber;
    public Button btnAdd;
    public Button btnRemove;
    public void initialize(){
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ADD");
                ObservableList<Integer> olNumbers = cmbNumber.getItems();
                olNumbers.add((int)(Math.random()*10));
            }
        });
        btnRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println( "Rmove");
                ObservableList<Integer> olNumbers = cmbNumber.getItems();
                olNumbers.remove(0);

            }
        });
    }
}
