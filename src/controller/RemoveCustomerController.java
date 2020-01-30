package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class RemoveCustomerController extends Controller<Kiosk> {

    @FXML
    private TableView<Customer> customersTv;
    @FXML
    private Button button;

    private Customer getSelectedProduct() {
        return customersTv.getSelectionModel().getSelectedItem();
    }

    public void initialize() {
        button.disableProperty().bind(customersTv.getSelectionModel().selectedItemProperty().isNull());
    }

    @FXML
    private void handleRemoveCustomer(ActionEvent event) throws IOException {
        Customer p = getSelectedProduct();
        getKiosk().removeCustomer(p);
    }

    @FXML
    private void handleExit(ActionEvent event) throws IOException {
        stage.close();
    }


    public final Kiosk getKiosk() {
        return model;
    }

}
