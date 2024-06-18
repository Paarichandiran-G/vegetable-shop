package Controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.AdminDAO;
import Resources.SellDTO;
import Resources.UserDTO;
// import Resources.UserDTO;
import Util.Input;
import Views.Admin;

public class adminController extends Input{
       public static ArrayList<UserDTO> user() throws SQLException{
        AdminDAO use=AdminDAO.getInstance();
        UserDTO users=new UserDTO();
        return use.userfarmer(users);
        
       } 
       public static ArrayList<SellDTO> sellhistory() throws SQLException {
         AdminDAO admin=AdminDAO.getInstance();
         SellDTO sell=new SellDTO();
         return admin.sold(sell);
       }
     
    }

