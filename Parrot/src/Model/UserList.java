package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserList {

    private ArrayList<User> userList;
    private final String listOfUsers = "listOfUsers.ser";

    public UserList() {
        userList = new ArrayList<>();
        
        this.readUserListFile();
        if (userList.isEmpty()) {
            initializeList();
        }
        //this.printUserListFile();
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

    private void readUserListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(listOfUsers);
            in = new ObjectInputStream(fis);
            userList = (ArrayList<User>) in.readObject();
            in.close();
            if (!userList.isEmpty()) {
                //System.out.println("There are movies in the user list");
            }
        } catch (IOException | ClassNotFoundException ex) {
        }
    }
    
    public void writeUserListFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(listOfUsers);
            out = new ObjectOutputStream(fos);
            out.writeObject(userList);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void printUserListFile() {
        for (int i = 0; i < userList.size(); i++) {
            User currentUser = (User) userList.get(i);
            System.out.println(currentUser.getFirstName());
        }
    }
}
