
package proj3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rafiu
 */
public class MovieFXMLController implements Initializable {

    @FXML
    private TextField MovieInputTextField;
    @FXML
    private ListView<String> movieList;

    @FXML
    void onClickAdd(ActionEvent event) {
        String movieName = (MovieInputTextField.getText()).toLowerCase().trim();
        
        if(!movieName.isEmpty())
            movieList.getItems().add(movieName); 
        MovieInputTextField.clear();
    }

    @FXML
    void onClickRemove(ActionEvent event) {
         if (!movieList.getSelectionModel().getSelectedItems().isEmpty()) {
            movieList.getItems().removeAll(movieList.getSelectionModel().getSelectedItems());
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert Message");
            alert.setHeaderText("Please select a movie to delete!");
            alert.show();
        }
    }

    @FXML
    void onClickLoad(ActionEvent event) {
        Scanner scan;
        try {
            scan = new Scanner(new File("movies.txt"));
            movieList.getItems().clear();
            while (scan.hasNext()) {
                movieList.getItems().add(scan.nextLine());                
            }
            scan.close();
        } catch (FileNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert Message");
            alert.setHeaderText("Movie Name Not Found!");
            alert.show();
        }
    }

    @FXML
    void onClickSave(ActionEvent event) {
        PrintWriter movieInput;
        try {
            movieInput = new PrintWriter("movies.txt");
            for (String movieItems : movieList.getItems()) {
                movieInput.println(movieItems);
            }
            movieInput.close();
            } catch (FileNotFoundException ex) {
           
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert Message");
            alert.setHeaderText("File Not Found!");
            alert.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        movieList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // TODO
    } 
    
}
