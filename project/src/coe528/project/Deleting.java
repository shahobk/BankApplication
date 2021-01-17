package coe528.project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 
 *
 * @author s3kazemi
 */


public class Deleting implements Initializable {
    
    @FXML
    private TextField usernameREE; 
    @FXML
    private Label accountStat;
    
    
     public void goToM(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent custRee = FXMLLoader.load(getClass().getResource("MainManager.fxml"));
           Scene sceneRp = new Scene(custRee);
           stage.setScene(sceneRp);
           stage.show();
    }
     public void delete (ActionEvent event) throws IOException{
         File f = new File(usernameREE.getText());
      if(f.delete()) 
        { 
            accountStat.setText(usernameREE.getText() + " has been removed.");
        } 
        else
        { 
            accountStat.setText(usernameREE.getText() + " could not be deleted. Account not found");
        } 
      }

   
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
