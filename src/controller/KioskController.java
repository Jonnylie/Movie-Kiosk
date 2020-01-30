package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.fxml.FXML;
import model.*;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class KioskController extends Controller<Kiosk> {


  
  public void initialize() {

  }

  public final Kiosk getKiosk() {
        return model;
    }

  @FXML private void handleAdministration(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/Admin.fxml", "Administration", new Stage());
	}
  
 @FXML private void handleExploreCatalogue(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/Catalogue.fxml", "Catalogue", new Stage());
	}
 
 @FXML private void handleCustomerRecord(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/CustomerRecord.fxml", "CustomerRecord", new Stage());
	}
 
 @FXML private void handleTopUpAccount(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/TopUpAccount.fxml", "TopUpAccount", new Stage());
	}
 
 @FXML private void handleFavouriteMovies(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/FavouriteMovies.fxml", "FavouriteMovies", new Stage());
	}
  
  @FXML private void handleExit(ActionEvent event) {
        System.exit(0);
    }
  
}

