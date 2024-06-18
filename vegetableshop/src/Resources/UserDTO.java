package Resources;
import Resources.UserDTO;
public class UserDTO {
    private String email;
    private String password;
    private int user_id;
    private String name;
    private String gender;
    private String location;
    private String contact;
    private String role;
    private String farmer_id;
    public UserDTO() {
    }
    
    public UserDTO(String email, String password, int user_id, String name, String gender, String location, String contact, String role) {
        this.email = email;
        this.password = password;
        this.user_id = user_id;
        this.name = name;
        this.gender = gender;
        this.location = location;
        this.contact = contact;
        this.role = role;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getFarmer_id() {
        return this.farmer_id;
    }

    public void setFarmer_id(String farmer_id) {
        this.farmer_id = farmer_id;
    }
    
    
    
    
}

