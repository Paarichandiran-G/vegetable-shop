package Controllers;

import java.sql.SQLException;

import Models.Connect;
import Models.UserDAO;
import Resources.UserDTO;
import Util.Cookie;
// import Util.Cookie;
import Util.Input;

public class userController extends Input{
    public static void add(String name,String gender,String location,String contact,String role,String email,String password) throws SQLException{
        UserDAO userModal=UserDAO.getInstance();
        UserDTO user=new UserDTO(email, password, 0, name, gender, location, contact, role);
        int id=userModal.insert(user);
        if(role.equals("farmer")){
            userModal.addFarmer(id);
        }
        return;
    }
    public static int  login(String email,String password) throws Exception{
        UserDAO userModal=UserDAO.getInstance();
        UserDTO user=userModal.getByEmail(email);
        if(user==null){
            throw new Exception("$        Invalid User      $");
        }
        if(!password.equals(user.getPassword())){
            throw new Exception("$        Invalid Password        $");
        }
        Cookie.setUser(user);
        if(user.getRole().equals("farmer")){
            return 1;
        }
        else if(user.getRole().equals("admin")){
            return 2;
        }
        return 3;
    }
   
}
