package Model;

import java.util.ArrayList;

public class UserList {

    private ArrayList<User> userList;

    public UserList() {
        userList = new ArrayList();
    }

    public void initializeList() {

        UserCredentials credentials = new UserCredentials("rgonzales1", "password1");
        User newUser = new User("Roberto",  "Gonzales", "rgonzales1", "administrator", "Information Technology", credentials);
        userList.add(newUser);

        credentials = new UserCredentials("jgill", "password2");
        newUser = new User("Joey",  "Gill", "jgill", "administrator","Information Technology", credentials);
        userList.add(newUser);

        credentials = new UserCredentials("shandelong", "password3");
        newUser = new User("Stephen",  "Handelong", "shandelong", "administrator","Information Technology", credentials);
        userList.add(newUser);

        credentials = new UserCredentials("tgordon", "password4");
        newUser = new User("Tommee",  "Gordon", "tgordon", "administrator","Information Technology", credentials);
        userList.add(newUser);

        credentials = new UserCredentials("sgill", "password5");
        newUser = new User("Shane",  "Gill", "sgill", "administrator","Information Technology", credentials);
        userList.add(newUser);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
    
    public void addUser(User addedUser) {
        userList.add(addedUser);
    }
}
