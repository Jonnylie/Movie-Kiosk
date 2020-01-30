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


public class AddMovieController extends Controller<Kiosk> {

    @FXML
    private TextField titleTf;
    @FXML
    private TextField yearTf;
    @FXML
    private TextField genreTf;
    @FXML
    private TextField priceTf;
    @FXML
    private Text movieAddedTf;
    @FXML
    private Button button;
    
        public void initialize() {
      button.disableProperty().bind(Bindings.or(titleTf.textProperty().isEmpty(),yearTf.textProperty().isEmpty()));
      button.disableProperty().bind(Bindings.or(genreTf.textProperty().isEmpty(),priceTf.textProperty().isEmpty()));

    }
    
    @FXML private void handleClose(ActionEvent event) {
        stage.close();
    }
    
    private String getTitle() {
        return titleTf.getText();
    }
    
    private String getGenre() {
        return genreTf.getText();
    }
    
    private int getYear() {
       String text = yearTf.getText();
        int year = Integer.parseInt(text);
        return year;
        
    }
    
    private int getPrice() {
        String text = priceTf.getText();
        int price = Integer.parseInt(text);
        return price;
        
    }
    
    private void setMovieAdded() {
        movieAddedTf.setText("Movie added to Catalogue.");
    }

   
    
    public final Kiosk getKiosk() {
        return model;
    }
    
    public void handleAddMovie(ActionEvent event) throws IOException {
        try {
        
        getKiosk().getCatalogue().addMovie(getTitle(), getYear(), getGenre(), getPrice());
        setMovieAdded();
        }
        catch(Exception ex){
          movieAddedTf.setText("Fail to add a Movie. Year or Price that you've entered is not a number.");
        }
    
}
}
