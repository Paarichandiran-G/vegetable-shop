package Controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.ConsumerDAO;
import Models.ProductDAO;
import Resources.ProductDTO;
import Resources.SellDTO;
import Util.Cookie;
import Util.Input;

public class consumerController extends Input{
    public static ArrayList<ProductDTO> consumerview() throws SQLException{
       ConsumerDAO view=ConsumerDAO.getInstance();
       ProductDTO product=new ProductDTO();
       return view.viewproducts(product);
        
    }
     public static void sell(int product_id, int quantity) throws Exception{
        ConsumerDAO product=ConsumerDAO.getInstance();
        ProductDAO productModal=ProductDAO.getInstance();
        int cost=productModal.getCost(product_id);
        if(cost==-1){
            throw new Exception("Invalid Product ID");
        }
        SellDTO sell = new SellDTO(Cookie.getUser().getUser_id(),product_id,quantity,cost*quantity,"",0);
        product.insert(sell);
       }  
}
