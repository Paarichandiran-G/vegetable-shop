package Views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import Controllers.adminController;
import Controllers.consumerController;
import Resources.ProductDTO;
import Resources.SellDTO;
import Resources.UserDTO;
import Util.Input;

public class Admin extends Input{
    public static void admin() throws Exception{
        while(true){
        try{
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|                  1.View Farmers                     |");
            System.out.println("|                  2.View Products                    |");
            System.out.println("|                  3.View Sell History                |");
            System.out.println("|                  4.Exit                             |");
            System.out.println("+-----------------------------------------------------+");
            int n=sc.nextInt();
            if(n==1){
                   ArrayList<UserDTO> user=adminController.user();
                   System.out.println("Farmers : ");
                   System.out.println("+" + "-".repeat(12) + "+" + "-".repeat(17) + "+" + "-".repeat(12) + "+" + "-".repeat(20) + "+" + "-".repeat(15) + "+");
                   System.out.printf("| %-10s | %-15s | %-10s | %-18s | %-13s |\n","user_id","name","gender","location","contact");
                   System.out.println("+" + "-".repeat(12)+"+"+"-".repeat(17)+"+"+"-".repeat(12)+"+"+"-".repeat(20)+"+"+"-".repeat(15) + "+");
                   for(UserDTO u : user){ 
                        System.out.printf("| %-10s | %-15s | %-10s | %-18s | %-13s |\n",u.getUser_id(),u.getName(),u.getGender(),u.getLocation(),u.getContact());
                   }
                   System.out.println("+"+"-".repeat(12)+"+"+"-".repeat(17)+"+"+"-".repeat(12)+"+"+"-".repeat(20)+"+"+"-".repeat(15) + "+");
                   System.out.println();
            }
            else if(n==2){
                    System.out.println("Available Products : ");
                    ArrayList<ProductDTO> available = consumerController.consumerview();
                    System.out.println("+" + "-".repeat(15) + "+" + "-".repeat(27) + "+" + "-".repeat(24) + "+"+ "-".repeat(20) + "+" + "-".repeat(22) + "+");
                    System.out.printf("| %-13s | %-25s | %-22s | %-18s | %-20s |\n", "product_id", "product name","variety", "1kgprice", "Availability");
                    System.out.println("+" + "-".repeat(15) + "+" + "-".repeat(27) + "+" + "-".repeat(24) + "+"
                            + "-".repeat(20) + "+" + "-".repeat(22) + "+");
                    for (ProductDTO product : available) {
                        System.out.printf("| %-13s | %-25s | %-22s | %-18s | %-20s |\n", product.getProduct_id(),
                                product.getProduct_name(), product.getVariety(), product.get_1qtyprice(),
                                product.getAvailability());
                    }
                    System.out.println("+" + "-".repeat(15) + "+" + "-".repeat(27) + "+" + "-".repeat(24) + "+"
                            + "-".repeat(20) + "+" + "-".repeat(22) + "+");
                    System.out.println();  
            }
            else if(n==3){
                System.out.println("Sold List :");
                 ArrayList<SellDTO> sell=adminController.sellhistory();
                 System.out.println("+" + "-".repeat(20) + "+" + "-".repeat(22) + "+" + "-".repeat(22) + "+"+ "-".repeat(20) + "+" + "-".repeat(18) + "+"+ "-".repeat(22) + "+");
                 System.out.printf("| %-18s | %-20s | %-20s | %-18s | %-16s | %-20s |\n","username","productname","variety","Qty","totalprice","date");
                 System.out.println("+" + "-".repeat(20) + "+" + "-".repeat(22) + "+" + "-".repeat(22) + "+"+ "-".repeat(20) + "+" + "-".repeat(18) + "+"+ "-".repeat(22) + "+");
                 for(SellDTO dto :sell){
                    System.out.printf("| %-18s | %-20s | %-20s | %-18s | %-16s | %-20s |\n",dto.getUsername(),dto.getProductname(),dto.getVariety(),dto.getQty(),dto.getTotalprice(),dto.getDate());
                 }
                 System.out.println("+" + "-".repeat(20) + "+" + "-".repeat(22) + "+" + "-".repeat(22) + "+"+ "-".repeat(20) + "+" + "-".repeat(18) + "+"+ "-".repeat(22) + "+");
                 System.out.println();
            }    
            else{
                System.out.println("-- Thank You ! --");
                return;
            }
            
        }
        catch(SQLException err){
           System.out.println("--Database error--");
       }
       catch(InputMismatchException err){
           System.out.println("--Invalid input--");
       }
       catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
       
    }


}
