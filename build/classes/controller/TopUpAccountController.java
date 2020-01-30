package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class TopUpAccountController extends Controller<Kiosk> {

    @FXML
    private TextField idTf;
    @FXML
    private TextField amountTf;
    @FXML
    private Text transactionTf;
    @FXML
    private Button topUpButton;

    
    public void initialize() {
      topUpButton.disableProperty().bind(Bindings.or(idTf.textProperty().isEmpty(),amountTf.textProperty().isEmpty()));

    }

    private int ID() {
        String text = idTf.getText();
        int ID = Integer.parseInt(text);
        return ID;

    }

    private int amount() {
        String text = amountTf.getText();
        int amount = Integer.parseInt(text);
        return amount;

    }

    public final Kiosk getKiosk() {
        return model;
    }

    public void handleTopUpAccount(ActionEvent event) throws IOException  {
        try {
        Customer c = model.getCustomer(ID());
        if (c!=null){
            getKiosk().getCustomer(ID()).topUpAccount(amount());
        transactionTf.setText("Transaction Complete.");

        }
        else{
            transactionTf.setText("No such customer.");
        }
        }
        catch(Exception ex) {
            
             transactionTf.setText("ID or amount you've entered is not a number");
        }
        
        
        
            }

    public void handleClose(ActionEvent event) {
        stage.close();
    }

}
