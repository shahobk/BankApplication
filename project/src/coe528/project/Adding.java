package coe528.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import java.io.*;
import java.io.File;
import java.io.PrintWriter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 * 
 *
 * @author s3kazemi
 */
 

public class Adding implements Initializable {
   
   @FXML
   private TextField username;
   @FXML
   private TextField password;
   @FXML
   private TextField passwordConfirmation;
   @FXML
   private TextField balanceOfAccount;
   @FXML
   private Label accountMessage;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    public void goToMenu(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          Parent cust = FXMLLoader.load(getClass().getResource("MainManager.fxml"));
           Scene scene2 = new Scene(cust);
           stage.setScene(scene2);
           stage.show();
    }
    public void newCustomer(ActionEvent event) throws IOException{
        String str1 = "";
        if(str1.equals(passwordConfirmation.getText()) || str1.equals(username.getText()) || str1.equals(password.getText()) || str1.equals(balanceOfAccount.getText())){
             accountMessage.setText("Can't Add Customer, Please input for all fields."); 
        }
        else if (!((passwordConfirmation.getText()).equals(password.getText()))){
            accountMessage.setText("The password's do not match. Please try again.");
        }
        
        else if(!(str1.equals(balanceOfAccount.getText()))){
           try{
            double bal = Double.parseDouble(balanceOfAccount.getText());
                    if(bal<100){
                accountMessage.setText("WARNING: Minimum balance of $100 is required");
            }
            else{
               File file = new File(username.getText());
               if(file.exists()){
               accountMessage.setText("Sorry, this username is already taken.");
        }
                if(!file.exists()){
                file.createNewFile();
                PrintWriter ptp = new PrintWriter(file);
                ptp.println(username.getText());
                ptp.println(password.getText());
                ptp.println(balanceOfAccount.getText());
                ptp.close();
                accountMessage.setText("New Customer Added");
            
        }
            }
           }
           catch(NumberFormatException e){
               accountMessage.setText("Please enter a valid number for BALANCE Field");
           }
    
        }
       
       
}
}
