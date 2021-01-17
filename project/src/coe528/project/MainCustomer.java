
package coe528.project;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
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
public class MainCustomer implements Initializable {
    
    /**
    *Overview: The MainCustomer class utilizes mutable and non mutable methods, where the user/customer can change withdraw, deposit, and make
    *purchases, with the help of getter and setter methods. The class uses mutable object references username3, balance, amountPurchased and login
    *to set the values of the wanted variables. Overall, we can see that the class, MainCustomer is indeed mutable.
    *
    *Abstraction Function:
    *AF(c): a database controller of the customer, cont, such that,
    *c.name = cont.name3 and c.id = cont.idNum.
    *
    *Rep Invariant:
    *RI(c): true if username2 != null and password2 != null
    *       false if otherwise
    */
    
    @FXML
    private TextField username2;
    @FXML
    private TextField password2;
    @FXML
    private Label errorMessage;
    @FXML
    private Label accountBal; 
    @FXML
    private Label accountStatus;
    @FXML
    private TextField amountOfCash;
    @FXML
    private boolean authenticated;
    @FXML
    private Label locked;
    
    private String username3;
    private String name3;
    private int idNumber = 0;
    
    private StateDesign mss = new PlatinumRewards();
    private Scanner scan;
    private double balance;
    private double amountPurchased;
    private boolean login;
    
    
  public double getBalanceREE(){
      /**
      *REQUIRES: String Username that is not null
      *MODIFIES: Account Balance
      *EFFECTS: Checks if the user credentials are in place with the proper account, and
      *         returns the balance of the account.
      */
    try{
         scan = new Scanner(new File(username2.getText())); 
         
       }
          catch(FileNotFoundException e){
         errorMessage.setText("User not found"); 
       }
       while(scan.hasNext()){ 
         String s1 = scan.next();
         String s2 = scan.next();
         String s3 = scan.next();
         balance = Double.parseDouble(s3);
         }
       scan.close();
       return balance;
}
  
  /**
   * 
   * @param s sets the username of the customer
   */
  public void setUserName3(String s){
      
      /**
      *REQUIRES: This to be instantiated
      *MODIFIES: username3
      *EFFECTS: Sets the username of the customer based on what the manager types in.
      *         
      */
      username3= s;
  }
  public double getAmountPurchased(){
      
      /**
      *REQUIRES: This to be instantiated
      *MODIFIES: N/A
      *EFFECTS: returns amountPurchased.
      */
      
    return amountPurchased;
}
  /**
   * 
   * @param sd  sets the StateDesign Information
   */
  
  public void setState(StateDesign sd) {
      
      /**
      *REQUIRES: This to be instantiated
      *MODIFIES: State
      *EFFECTS: Sets sd to mss, and mss gathers all information from sd.
      */
        mss = sd;
    }
  
  /**
   * 
   * @param balance sets the balance of the account
   * @throws IOException 
   */
  
  public void setBalance(double balance) throws IOException{
       
      /**
      *REQUIRES: Three null strings, s1, s2, s3.
      *MODIFIES: Account Balance
      *EFFECTS: Checks if the user credentials are in place with the proper account, and sets
                the balance that the admin inputs in, into the customers account.
      *         
      */
      
       String s1 = null;
       String s2= null;
       String s3= null;
      try{
          scan = new Scanner(new File(username2.getText()));
      }
      catch(FileNotFoundException e){
          errorMessage.setText("User not found");
      }
      while(scan.hasNext()){
         s1 = scan.next();
         s2 = scan.next();
         s3 = scan.next();
          
      }
      scan.close();
      s3 = Double.toString(balance);
      
      File file = new File(username2.getText());
      if(file.delete()){
          System.out.print("");
      }
      
       
       File newFile = new File(username2.getText());
       newFile.createNewFile();
               PrintWriter pwd = new PrintWriter(newFile);
                pwd.println(s1);
                pwd.println(s2);
                pwd.println(balance);
                pwd.close();
         
  }
  public void login(ActionEvent ev) throws IOException{
      
      /**
      *REQUIRES: This to be instantiated
      *MODIFIES: N/A
      *EFFECTS: Checks if username and password exists with an existing file created,
      *if so, unlocks the features of withdraw, deposit, make purchase, and account balance.
      *          
      */
      
      try{
         scan = new Scanner(new File(username2.getText())); 
         
       }
          catch(FileNotFoundException e){
         errorMessage.setText("User not found"); 
       }
       while(scan.hasNext()){  
         String a = scan.next();
         String b = scan.next();
         String c = scan.next();
         if(password2.getText().equals(b)){
             errorMessage.setText("Login Success"); 
             login = true;
             locked.setText("(Unlocked)");
             
         }
         else{
             errorMessage.setText("Invalid Credentials");
             
         }
       }
       scan.close();
  }
  
    public void getAccountBalance(ActionEvent ev) throws IOException{
        
      /*
      *REQUIRES: String Username that is not null
      *MODIFIES: Account Balance
      *EFFECTS: Checks if the user credentials are in place with the proper account, and
      *          returns the balance of the account.
      */
        String s1;
        String s2;
        String s3;
       if(login==true){
       scan = new Scanner(new File(username2.getText())); 
       while(scan.hasNext()){
         // While File has something in it  
         s1 = scan.next();
         s2 = scan.next();
         s3 = scan.next();
         balance = Double.parseDouble(s3);
         accountBal.setText("$ "+s3);
       }
       scan.close();
       }
       else{
           accountBal.setText("Please Login First!");
       }
    }
    
    public void depositMoneyInBank(ActionEvent ev) throws IOException{
     /**
      *REQUIRES: Null Strings s1, s2, s3, and empty String s4.
      *MODIFIES: Account Balance
      *EFFECTS: Checks if the user credentials are in place with the proper account, and deposits
      *         the amount of cash that the user types into the textfield.
      *         
      */
        
        String s1 = null; 
        String s2 = null; 
        String s3 = null;
        String s4 = "";
          if(login==true){
              scan = new Scanner(new File(username2.getText()));
       while(scan.hasNext()){
          
         s1 = scan.next();
         s2 = scan.next();
         s3 = scan.next();
          
         if(amountOfCash.getText().equals(s4)){
             accountStatus.setText("Amount field not entered");
         }
         else{
             try{
         balance = Double.parseDouble(s3) + Double.parseDouble(amountOfCash.getText());
         
             }
                        catch(NumberFormatException e){
               accountStatus.setText("Please enter a valid number for Amount field");
           }
         }
       }
       scan.close();
       
       
       s3 = Double.toString(balance);
      File file = new File(username2.getText());
      if(file.delete()){
          System.out.print("");
      }
      
       
       File newFile = new File(username2.getText());
       
               newFile.createNewFile();
               PrintWriter pwd = new PrintWriter(newFile);
                pwd.println(s1);
                pwd.println(s2);
                pwd.println(s3);
                pwd.close();
                  try{
         balance = Double.parseDouble(s3) + Double.parseDouble(amountOfCash.getText());
         accountStatus.setText("$"+amountOfCash.getText()+" deposited for "+ username2.getText());
             }
                             catch(NumberFormatException e){
               accountStatus.setText("Please enter a valid number for Amount field");
           }
                
                
          }    
          else{
              accountStatus.setText("Please login first");
          }

       
    }
    
    public void withdrawMoneyFromBank(ActionEvent ev) throws IOException{
        
         /**
      *REQUIRES: Null Strings s1, s2, s3, and empty String s4.
      *MODIFIES: Account Balance
      *EFFECTS: Checks if the user credentials are in place with the proper account, and withdraws
      *         the amount of cash that the user types into the textfield. Before it withdraws,
      *          it checks to make sure that the account has enough money.
      *         
      */
        
        String s1 = null; 
        String s2 = null; 
        String s3 = null;
        String s4 = "";
        if(login==true){
       scan = new Scanner(new File(username2.getText()));
       while(scan.hasNext()){ 
         s1 = scan.next();
         s2 = scan.next();
         s3 = scan.next();
          
         if(amountOfCash.getText().equals(s4)){
             accountStatus.setText("Amount field not entered");
         }
         else{
             try{
         balance = Double.parseDouble(s3) - Double.parseDouble(amountOfCash.getText());
         
             }
                        catch(NumberFormatException e){
               accountStatus.setText("Please enter a valid number for Amount field");
           }
         }
       }
       scan.close();
       
       if(balance >= 0){
       s3 = Double.toString(balance);
      File file = new File(username2.getText());
      if(file.delete()){
          System.out.println("");
      }
      
       
       File newFile = new File(username2.getText());
       
               newFile.createNewFile();
               PrintWriter pwd = new PrintWriter(newFile);
                pwd.println(s1);
                pwd.println(s2);
                pwd.println(s3);
                pwd.close();
                       try{
         balance = Double.parseDouble(s3) + Double.parseDouble(amountOfCash.getText());
         accountStatus.setText("$"+amountOfCash.getText()+" withdrawed for "+username2.getText());
             }
                             catch(NumberFormatException e){
               accountStatus.setText("Please enter a valid number for Amount field");
           }
       

       
    }
       else{
           accountStatus.setText("Not enough balance in account");
       }
    }
        else{
              accountStatus.setText("Please login first");
          }
        
    }
    public void makeOnlinePurchase(ActionEvent ev) throws IOException{
        
        /**
      *REQUIRES: Null Strings s1, s2, s3, and empty String s4.
      *MODIFIES: Account Balance
      *EFFECTS: Checks if the user credentials are in place with the proper account, and makes online purchase
      *          with the amount of cash that the user types into the textfield. Before it makes the purchase,
      *          it checks to make sure that the account has enough money. It also goes through the rewards classes,
      *          and checks if the accountBalance meets with the standards of the rewards classes, and adds a fee
      *          depending on the rewards class
      *         
      */
        
        String s1 = null; 
        String s2 = null; 
        String s3 = null;
        String s4 = "";
        String level = null;
          if(login==true){
         if(amountOfCash.getText().equals(s4)){
             accountStatus.setText("Amount field not entered");
             System.out.println("pat2");
         }
         else{
             try{
         amountPurchased = Double.parseDouble(amountOfCash.getText());
             
             if(amountPurchased>=50){
                 
             
             double d = mss.getExtraCost();
             if(amountPurchased + d < this.getBalanceREE()){
            mss.makeOnlinePurchase(this); 
            d = mss.getExtraCost();
            if(d==20){
               level = "Silver"; 
            }
            else if(d==10){
                level = "Gold";
            }
            else if(d==0){
                 level= "Platinum";
             }
            String dd = Double.toString(d);
            
            accountStatus.setText("Level: "+level+" $"+dd+" fee charged. Purchase Succcess");
             }
             else{
                 accountStatus.setText("Not enough balance in account to make purchase");
             }
             }
             else{
                 accountStatus.setText("Online Purchase must be $50 or more");
             }
             }
                        catch(NumberFormatException e){
               accountStatus.setText("Please enter a valid number for Amount field");
           }

             
           
         }
       }
          
          
      else{
             accountStatus.setText("Please login first");  
          }
              
              
              
              
          }
          
    
    
    public void logoutOfCust (ActionEvent ev) throws IOException{
        
        /**
      *REQUIRES: N/A
      *MODIFIES: N/A
      *EFFECTS: Logs out of the Customer Mainpage, and goes back to the main menu.
      *         
      */
        
        
        Stage stage = (Stage)((Node)ev.getSource()).getScene().getWindow();
          Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
           Scene scene1 = new Scene(login);
           stage.setScene(scene1);
           stage.show();
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    } @Override
    public String toString(){
        
        return ("Username: " + this.name3 + "ID: " + this.idNumber );
        
    }public boolean repOk(){
        
        if(username2 != null && password2 != null){
            return true;
            
        }else{
            return false;
        }
    }      
}
