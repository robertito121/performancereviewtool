package Model;

public class User {

    protected String firstName;
    protected String lastName;
    protected String userId;
    protected String role;
    private UserCredentials userCredentials;

    public User(String firstName, String lastName, String userId, String role, UserCredentials credentials){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.role = role;
        this.userCredentials = credentials;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    public void setPermissions(String userRole){

    }

    /**
     * displays the users info in the overwritten format
     * @return
     */
    @Override
    public String toString() {
        String userToString = "" + firstName + " " + lastName + " (" + userId + ")";
        return userToString;
    }


    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }
}
