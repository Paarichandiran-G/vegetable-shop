package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.ProductDTO;
import Resources.SellDTO;

public class ConsumerDAO extends Connect {
    private static ConsumerDAO instance;
    private static PreparedStatement available;
    private static PreparedStatement sellhistory;
    ConsumerDAO() throws SQLException {
        sellhistory =conn.prepareStatement("Insert into sell(user_id,product_id,qty,totalprice) VALUES (?,?,?,?)");
        available=conn.prepareStatement("SELECT P.product_id, p.product_name, p.variety, p.1qtyprice, p.qty-IFNULL(sum(s.qty),0),p.qty from availabeproduct p LEFT JOIN sell s USING(product_id)  GROUP BY p.product_id");
    }

    public static ConsumerDAO getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConsumerDAO();
        }
        return instance;
    }

    public static ArrayList<ProductDTO> viewproducts(ProductDTO p)throws SQLException {
         available.executeQuery();
         ResultSet res=available.executeQuery();
         ArrayList<ProductDTO> availables=new ArrayList<ProductDTO>();
         while(res.next()){
            ProductDTO product=new ProductDTO();
            product.setProduct_id(res.getInt(1));
            product.setProduct_name(res.getString(2));
            product.setVariety(res.getString(3));
            product.set_1qtyprice(res.getInt(4));
            product.setAvailability(res.getInt(5));
            product.setQty(res.getInt(6));
            availables.add(product);
         }
         return availables;
    }

    public static void insert(SellDTO sell) throws SQLException{
        sellhistory.setInt(1,sell.getUser_id());
        sellhistory.setInt(2,sell.getProduct_id());
        sellhistory.setInt(3,sell.getQty());
        sellhistory.setInt(4,sell.getTotalprice());
        sellhistory.executeUpdate();
    }

}
