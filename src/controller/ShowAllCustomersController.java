package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ShowAllCustomersController extends Controller<Kiosk> {

    @FXML private TableView<Customer>customersTv;
  
  public void initialize() {

  }

  public final Kiosk getKiosk() {
        return model;
    }
  
@FXML private void handleExit(ActionEvent event) {
        stage.close();
    }
}
