package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Resources.ProductDTO;

public class ProductDAO extends Connect {
   private static ProductDAO instance;
   private static PreparedStatement farmerproduct;
   private static PreparedStatement productdetails;

   ProductDAO() throws SQLException {
      farmerproduct = conn.prepareStatement("INSERT INTO availabeproduct(farmer_id,product_name,variety,qty,date,cost,1qtyprice) VALUES(?,?,?,?,?,?,?)");
      productdetails = conn.prepareStatement("SELECT product_name,variety,qty,cost,date FROM availabeproduct where farmer_id=?");
   }

   public static ProductDAO getInstance() throws SQLException {
      if (instance == null) {
         instance = new ProductDAO();
      }
      return instance;
   }

   public void insert(ProductDTO available) throws SQLException {
      farmerproduct.setInt(1, available.getFarmer_id());
      farmerproduct.setString(2, available.getProduct_name());
      farmerproduct.setString(3, available.getVariety());
      farmerproduct.setInt(4, available.getQty());
      farmerproduct.setString(5, available.getDate());
      farmerproduct.setInt(6, available.getCost());
      farmerproduct.setInt(7, available.get_1qtyprice());
      farmerproduct.executeUpdate();
      System.out.println();
      System.out.println("-- Product Sale Successfully --");
      // ResultSet res=farmerproduct.executeQuery();
   }
   
   public ArrayList<ProductDTO> d(ProductDTO details)throws SQLException{
      productdetails.setInt(1, details.getFarmer_id());
      productdetails.executeQuery();
      ResultSet res=productdetails.executeQuery();
      ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
      while(res.next()){
         ProductDTO product=new ProductDTO();
         product.setProduct_name(res.getString(1));
         product.setVariety(res.getString(2));
         product.setQty(res.getInt(3));
         product.setCost(res.getInt(4));
         product.setDate(res.getString(5));
         products.add(product);
      }
      return products;
   }
   public int getCost(int id) throws SQLException{
      ResultSet res=statement.executeQuery("SELECT 1qtyprice FROM availabeproduct WHERE product_id="+id);
      if(res.next()){
         return res.getInt(1);
      }
      return -1;
   }
  
   
   

}
