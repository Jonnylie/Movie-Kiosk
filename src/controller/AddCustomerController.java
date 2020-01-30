package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddCustomerController extends Controller<Kiosk> {

    @FXML
    private TextField idTf;
    @FXML
    private TextField nameTf;
    @FXML
    private TextField balanceTf;
    @FXML
    private Text customerAddedTf;
    @FXML
    private Button button;

    public final Kiosk getKiosk() {
        return model;
    }

    @FXML
    private void handleAddCustomer(ActionEvent event) throws IOException {
        try {
        Customer c = model.getCustomer(getID());
        if (c == null) {
        getKiosk().addCustomer(getID(), getName(), getBalance());
        setCustomerAdded();
        } else {
           customerAddedTf.setText("That customer exist.");
        }
        }
        catch(Exception ex){
          customerAddedTf.setText("Fail to add a customer. ID or Balance that you've entered is not a number.");
        }
    
    }
    
        public void initialize() {
      button.disableProperty().bind(Bindings.and(idTf.textProperty().isEmpty(),nameTf.textProperty().isEmpty()));
      button.disableProperty().bind(balanceTf.textProperty().isEmpty());

    }

    private int getID() {
        String text = idTf.getText();
        int id = Integer.parseInt(text);
        return id;
    }

    private void setID(String id) {
        idTf.setText(id);
    }

    private String getName() {
        return nameTf.getText();
    }

    private void setName(String name) {
        nameTf.setText(name);
    }

    private int getBalance() {
        String text = balanceTf.getText();
        int balance = Integer.parseInt(text);
        return balance;
    }

    private void setBalance(String balance) {
        idTf.setText(balance);
    }
    
     private void setCustomerAdded() {
        customerAddedTf.setText("Customer added to Kiosk.");
    }

    @FXML
    private void handleClose(ActionEvent event) {
        stage.close();
        
        
    }
}
