package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AdminController extends Controller<Kiosk>  {
    
     public final Kiosk getKiosk() {
        return model;
    }
        
    @FXML private void handleCancel(ActionEvent event) {
        stage.close();
    }
    
     @FXML private void handleAddCustomer(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/AddCustomer.fxml", "AddCustomer", new Stage());
	}
     
     @FXML private void handleAddMovie(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/AddMovie.fxml", "AddMovie", new Stage());
	}
     
     @FXML private void handleRemoveCustomer(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/RemoveCustomer.fxml", "RemoveCustomer", new Stage());
                
                
	}
     
       @FXML private void handleRemoveMovie(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/RemoveMovie.fxml", "RemoveMovie", new Stage());
                
                
	}
     
     
     
      @FXML private void handleViewAllCustomers(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/ShowAllCustomers.fxml", "ShowAllCustomers", new Stage());
	}
      
       @FXML private void handleViewAllMovies(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/ShowAllMovies.fxml", "ShowAllMovies", new Stage());
	}
     
     
     
     
}
