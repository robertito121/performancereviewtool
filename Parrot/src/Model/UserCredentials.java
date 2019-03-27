package Model;

import java.io.Serializable;

public class UserCredentials implements Serializable{

    private String userName;
    private String password;

    public UserCredentials(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {

        return userName;
    }

    public String getPassword() {

        return password;
    }
}
