package controller;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ShowAvailableMoviesController extends Controller<Kiosk> {

  @FXML private TableView<Customer>customersTv;
  
   

    
    
    
    @FXML private void handleExit(ActionEvent event) throws IOException {
        stage.close();
    }
       
  
  public void initialize() {

  }

  public final Kiosk getKiosk() {
        return model;
    }

}