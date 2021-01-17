
package coe528.project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 *
 * @author s3kazemi
 */

public class PlatinumRewards extends StateDesign {
    
double extraCost = 0;

    @Override
    
    public void makeOnlinePurchase(MainCustomer c) {
     
        if(c.getBalanceREE()<10000){
            c.setState(new SilverRewards());
        }
        if(c.getBalanceREE()<20000 && c.getBalanceREE()>=10000){
            c.setState(new GoldRewards());
        }
        
        else{
          double sir = c.getAmountPurchased();
        try {
            c.setBalance(c.getBalanceREE() - sir);
            
        } catch (IOException ex) {
            Logger.getLogger(SilverRewards.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
         
    }

    @Override
    public double getExtraCost() {
        return extraCost;
            }
       
}
    
    