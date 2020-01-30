package controller;

import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class CustomerRecordController extends Controller<Kiosk> {

    @FXML
    private TableView<Movie> moviesTv;
    @FXML
    private TableView<Movie> movies2Tv;
    @FXML
    private TextField idTf;
    @FXML
    private Text customerTf;
    @FXML
    private Button selectTf;

    public void initialize() {
        selectTf.disableProperty().bind(idTf.textProperty().isEmpty());
    }

    private int ID() {
        String text = idTf.getText();
        int ID = Integer.parseInt(text);
        return ID;

    }

    private Customer getID() {
        return getKiosk().getCatalogue().getCustomer(ID());
    }

    public final Kiosk getKiosk() {
        return model;
    }

    public void handleSelectCustomer(ActionEvent event) throws IOException {
        try {
            Customer c = model.getCustomer(ID());
            if (c != null) {
                customerTf.setText(getID() + "");
                moviesTv.setItems(getKiosk().getCustomer(ID()).currentlyRented());
                movies2Tv.setItems(getKiosk().getCustomer(ID()).rentingHistory());
            } else {
                customerTf.setText("No such customer.");
                moviesTv.setItems(null);
                movies2Tv.setItems(null);
            }
        } catch (Exception ex) {
            customerTf.setText("ID that you have entered is not a number");
            moviesTv.setItems(null);
            movies2Tv.setItems(null);

        }
    }

    public void handleClose(ActionEvent event) {
        stage.close();
    }

}
