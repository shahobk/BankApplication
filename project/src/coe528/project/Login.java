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
import java.io.*;
import java.util.*;

/**
 * 
 *
 * @author s3kazemi
 */


public class Login {
   @FXML
   private Label errorM;
   @FXML
   private TextField adminU;
   @FXML
   private TextField adminP;
   
   private Scanner scan;
   
   public void loginM(ActionEvent event) throws IOException{
       Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent homepage = FXMLLoader.load(getClass().getResource("ManagerLogin.fxml"));
           Scene scene2 = new Scene(homepage);
           stage.setScene(scene2);
           stage.show();
   }
    public void loginC(ActionEvent event) throws IOException{
       Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent homepage = FXMLLoader.load(getClass().getResource("MainCustomer.fxml"));
           Scene scene2 = new Scene(homepage);
           stage.setScene(scene2);
           stage.show();
   }
          public void goBackToMainM(ActionEvent event) throws IOException{
           Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent homepage = FXMLLoader.load(getClass().getResource("Login.fxml"));
           Scene scene2 = new Scene(homepage);
           stage.setScene(scene2);
           stage.show();
       }
   public void Login(ActionEvent event) throws IOException{
       
       if(adminU.getText().equals("admin")&& adminP.getText().equals("admin")){
          errorM.setText("Login Success"); 
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent homepage = FXMLLoader.load(getClass().getResource("MainManager.fxml"));
           Scene scene2 = new Scene(homepage);
           stage.setScene(scene2);
           stage.show();
       }

       
      else{
       errorM.setText("Invalid Credentials!");
   }
       
       
} public void closeProgram(){
    System.exit(1);
}
}

