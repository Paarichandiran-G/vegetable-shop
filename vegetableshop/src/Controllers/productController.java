package Controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.ProductDAO;
import Models.UserDAO;
import Resources.ProductDTO;
import Util.Cookie;

public class productController {
    public static void product(String product_name,String variety,int qty,String date,int cost,int _1qtyprice) throws SQLException{
        ProductDAO product=ProductDAO.getInstance();
        ProductDTO available = new ProductDTO(product_name,variety,qty,date,cost,_1qtyprice);
        available.setFarmer_id(Cookie.getUser().getUser_id());
        product.insert(available);
    }
    public static ArrayList<ProductDTO> product_details() throws SQLException{
        ProductDAO product=ProductDAO.getInstance();
        ProductDTO details=new ProductDTO();
        details.setFarmer_id(Cookie.getUser().getUser_id());
        return product.d(details);
           
    }

        
    
}
