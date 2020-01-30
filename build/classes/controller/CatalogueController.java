
package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Catalogue;
import model.*;




public class CatalogueController extends Controller<Kiosk> {

 
  public void initialize() {

  }

  public final Kiosk getKiosk() {
        return model;
    }
  
  
  
  @FXML private void handleAllMovies(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/ShowAllMovies.fxml", "AllMovies", new Stage());
	}
  
   @FXML private void handleRentMovie(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/RentMovie.fxml", "RentMovie", new Stage());
	}
   
    @FXML private void handleReturnMovie(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/ReturnMovie.fxml", "ReturnMovie", new Stage());
	}
  
  @FXML private void handleAvailableMovies(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/ShowAvailableMovies.fxml", "AvailableMovies", new Stage());
	}
  
  @FXML private void handleMoviesByGenre(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/ShowMoviesByGenre.fxml", "MoviesByGenre", new Stage());
	}
  
  @FXML private void handleMoviesByYear(ActionEvent event) throws Exception {
		// Note which model is passed in.
		// You can't pass in the account because the account is yet to be created!
		// You pass in the customer which has the list of accounts to which the
		// new account needs to be added.
		ViewLoader.showStage(getKiosk(), "/view/ShowMoviesByYear.fxml", "MoviesByYear", new Stage());
	}
  
    @FXML private void handleExit(ActionEvent event) throws Exception {
		stage.close();
	}

}

