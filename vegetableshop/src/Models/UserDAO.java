package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Statement;
import java.sql.Statement;

import Resources.UserDTO;

public class UserDAO extends Connect {
   private static UserDAO instance;
   private PreparedStatement insertUser;
   private PreparedStatement insertLogin;
   private PreparedStatement insertFarmer;
   private PreparedStatement selectByEmail;
   UserDAO() throws SQLException {
      insertUser=conn.prepareStatement("INSERT INTO user (name,gender,location, contact, role) VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
      insertLogin=conn.prepareStatement("INSERT INTO login (email,password,user_id) VALUES(?,?,?)");
      insertFarmer=conn.prepareStatement("INSERT INTO farmer (user_id) VALUES(?)");
      selectByEmail=conn.prepareStatement("SELECT L.email,L.password,L.user_id,U.name,U.gender,U.location,U.contact,U.role FROM login L JOIN user U USING(user_id) WHERE L.email=?");

   }

   public static UserDAO getInstance() throws SQLException {
      if(instance == null){
         instance = new UserDAO();
      }
      return instance;
   }

   public int insert(UserDTO user) throws SQLException {
      insertUser.setString(1, user.getName());
      insertUser.setString(2, user.getGender());
      insertUser.setString(3, user.getLocation());
      insertUser.setString(4, user.getContact());
      insertUser.setString(5, user.getRole());
      insertUser.executeUpdate();
      ResultSet res=insertUser.getGeneratedKeys();
      if(res.next()){
         insertLogin.setString(1, user.getEmail());
         insertLogin.setString(2, user.getPassword());
         insertLogin.setInt(3, res.getInt(1));
         insertLogin.executeUpdate();
         return res.getInt(1);
      }
      return -1;
   }
   public void addFarmer(int id) throws SQLException {
      insertFarmer.setInt(1, id);
      insertFarmer.executeUpdate();
   }
   public UserDTO getByEmail(String email) throws SQLException {
      selectByEmail.setString(1, email);
      ResultSet res=selectByEmail.executeQuery();
      if(res.next()) {
         return new UserDTO(res.getString(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8));
      }
      return null;
   }
}
