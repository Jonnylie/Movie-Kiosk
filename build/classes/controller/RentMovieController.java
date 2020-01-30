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

public class RentMovieController extends Controller<Kiosk> {

    @FXML
    private TableView<Movie> moviesAvailableTv;
    @FXML
    private TextField idTf;
    @FXML
    private Text movieRentedTf;
    @FXML
    private Button rentTf;
    @FXML
    private Button selectTf;

    public void initialize() {
        selectTf.disableProperty().bind(idTf.textProperty().isEmpty());
        rentTf.disableProperty().bind(moviesAvailableTv.getSelectionModel().selectedItemProperty().isNull());
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

    private Movie getSelectedProduct() {
        return moviesAvailableTv.getSelectionModel().getSelectedItem();
    }

    public void handleRentSelectedMovie(ActionEvent event) throws IOException  {
       
        Movie m = getSelectedProduct();
        if (getKiosk().getCatalogue().rentMovieToCustomer(m, getID())) {
            movieRentedTf.setText("Movie Rented.");
        } else {
            movieRentedTf.setText("Your balance is too low!");
        }
        
        
    }

    public void handleSelectCustomer(ActionEvent event) throws IOException {
        try {
        Customer c = model.getCustomer(ID());
        if (c != null) {
            moviesAvailableTv.setItems(getKiosk().getCatalogue().getMoviesAvailable());
            movieRentedTf.setText("");
        } else {
            movieRentedTf.setText("Customer does not exist.");
            moviesAvailableTv.setItems(null);
        }
    }
    catch(Exception ex) {
            movieRentedTf.setText("ID that you've entered is not a number");
            moviesAvailableTv.setItems(null);
    }
    }

    public void handleClose(ActionEvent event) {
        stage.close();
    }

}
