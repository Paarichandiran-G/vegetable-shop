package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Resources.ProductDTO;
import Resources.SellDTO;
import Resources.UserDTO;

public class AdminDAO extends Connect {
       private static AdminDAO instance;
       private PreparedStatement farmer;
       private PreparedStatement sellhis;

       AdminDAO() throws SQLException {
              farmer = conn.prepareStatement("select *from user where role='farmer'");
              sellhis=conn.prepareStatement("SELECT U.name,P.product_name,P.variety,s.qty,s.totalprice,S.date FROM sell S JOIN availabeproduct P USING(product_id) JOIN user U USING(user_id)") ;    
       }

       public static AdminDAO getInstance() throws SQLException {
              if (instance == null) {
                     instance = new AdminDAO();
              }
              return instance;
       }

       public ArrayList<UserDTO> userfarmer(UserDTO u) throws SQLException {
              farmer.executeQuery();
              ResultSet res=farmer.executeQuery();
              ArrayList<UserDTO> users=new ArrayList<UserDTO>();
              while(res.next()){
                     UserDTO user=new UserDTO();
                     user.setUser_id(res.getInt(1));
                     user.setName(res.getString(2));
                     user.setGender(res.getString(3));
                     user.setLocation(res.getString(4));
                     user.setContact(res.getString(5));
                     users.add(user);
              }
              return users;

       }

       public ArrayList<SellDTO> sold(SellDTO sell) throws SQLException{
         sellhis.executeQuery();
         ResultSet res=sellhis.executeQuery();
         ArrayList<SellDTO> result = new ArrayList<SellDTO>();
         while(res.next()){
                SellDTO user=new SellDTO();
              user.setUsername(res.getString(1));
              user.setProductname(res.getString(2));
              user.setVariety(res.getString(3));
              user.setQty(res.getInt(4));
              user.setTotalprice(res.getInt(5));
              user.setDate(res.getString(6));
              result.add(user);
         }
         return result;
       }


}
