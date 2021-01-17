package coe528.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 *
 * @author s3kazemi
 */

public class MainManager {
  
    public void Logout(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent custPo = FXMLLoader.load(getClass().getResource("ManagerLogin.fxml"));
           Scene sceneRe = new Scene(custPo);
           stage.setScene(sceneRe);
           stage.show();
    }
    public void addCustomer(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent custPi = FXMLLoader.load(getClass().getResource("Adding.fxml"));
           Scene sceneRa = new Scene(custPi);
           stage.setScene(sceneRa);
           stage.show();
    }
    
    public void deleteCustomer(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent custP = FXMLLoader.load(getClass().getResource("Deleting.fxml"));
           Scene sceneR = new Scene(custP);
           stage.setScene(sceneR);
           stage.show();
           
    }public void closeTheProgram(){
    System.exit(1);
}
    
    
    
}
