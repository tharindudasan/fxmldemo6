package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerTM;

import java.util.Optional;

public class TableFormController {
    public TableView<CustomerTM> tblCustomer;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSave;
    public Button btnNewCustomer;
    public Button btnDeleteCustomer;

    public void initialize() {
        btnDeleteCustomer.setDisable(true);
        /*
        Lets map Column Name
         */
        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        ObservableList<CustomerTM> olCustomers = tblCustomer.getItems();

        CustomerTM c001 = new CustomerTM("C001", "Kasun", "Panadura");
        olCustomers.add(c001);

        olCustomers.add(new CustomerTM("C002", "Ruwan", "Colombo"));
        olCustomers.add(new CustomerTM("C003", "Amal", "Moratuwa"));


//        btnNewCustomer.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//            }
//        });
        tblCustomer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observableValue, CustomerTM pervious, CustomerTM current) {
                if (current == null) {
                    btnDeleteCustomer.setDisable(true);
                    txtId.setEditable(true);
                    txtId.clear();
                    txtAddress.clear();
                    txtName.clear();
                    btnSave.setText("Save Customer");
                    return;
                }
                btnDeleteCustomer.setDisable(false);
                txtId.setText(current.getId());
                txtId.setEditable(false);
                txtName.setText(current.getName());
                txtAddress.setText(current.getAddress());
                btnSave.setText("Update Customet");
            }
        });
//        btnDeleteCustomer.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//            }
//        });

    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        {

            ObservableList<CustomerTM> olCustomers = tblCustomer.getItems();
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();

            txtId.requestFocus();
            if (id.isBlank()) {
                new Alert(Alert.AlertType.ERROR, "Customer ID Empty").showAndWait();
                txtId.requestFocus();
                return;
            } else if (name.isBlank()) {
                new Alert(Alert.AlertType.ERROR, "Customer Name Cant be Empty").showAndWait();
                txtName.requestFocus();
                return;

            } else if (address.isBlank()) {
                new Alert(Alert.AlertType.ERROR, "Customer address cant be Empty").showAndWait();
                txtAddress.requestFocus();
                return;
            }
            if (btnSave.getText().equalsIgnoreCase("Save Customer")) {
                for (CustomerTM olCustomer : olCustomers) {
                    if (olCustomer.getId().equals(txtId.getText())) {
                        new Alert(Alert.AlertType.ERROR, "you enter Duplicate value").showAndWait();
                        txtId.requestFocus();
                        return;
                    }
                }
                CustomerTM newCustomer = new CustomerTM(id, name, address);
                olCustomers.add(newCustomer);

                txtId.clear();
                txtName.clear();
                txtAddress.clear();
            } else {
                CustomerTM selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();
                selectedCustomer.setName(txtName.getText());
                selectedCustomer.setAddress(address);
                tblCustomer.refresh();
            }

        }
    }

    public void btnNewCustomer_OnACtion(ActionEvent actionEvent) {
        tblCustomer.getSelectionModel().clearSelection();
        txtId.requestFocus();

    }

    public void btnDeleteCustomer_OnAction(ActionEvent actionEvent) {
        //                CustomerTM selectedCustomer = tblCustomer.getSelectionModel().getSelectedItem();
//                int selectedIndex = tblCustomer.getSelectionModel().getSelectedIndex();
//                System.out.println(selectedCustomer);
//                System.out.println(selectedIndex);


        ObservableList<CustomerTM> olCutomer = tblCustomer.getItems();
        CustomerTM selectedCutomer = tblCustomer.getSelectionModel().getSelectedItem();
        if (selectedCutomer == null) return;
        Optional<ButtonType> selectedOption = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure to delete This Customer", ButtonType.YES, ButtonType.NO).showAndWait();
        if (selectedOption.get() == ButtonType.YES) {
            olCutomer.remove(selectedCutomer);
        }

    }
}
