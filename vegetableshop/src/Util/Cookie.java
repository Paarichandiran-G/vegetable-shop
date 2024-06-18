package Util;

import Resources.UserDTO;

public class Cookie {
    private static UserDTO user;

    public static UserDTO getUser() {
        return user;
    }

    public static void setUser(UserDTO u) {
        user = u;
    }

    
}
