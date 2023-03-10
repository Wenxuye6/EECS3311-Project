package bean;

/**
 * Administrator entity category
 */

//admin log in portal
public class Admin {
    private String username; //Administrator account
    private String password; //Administrator password

    //No-Arg Constructor.
    public Admin() {
    }
    //Parameterized Constructor.
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    //getter username
    public String getUsername() {
        return username;
    }
    //setter username
    public void setUsername(String username) {
        this.username = username;
    }
    //getter for password
    public String getPassword() {
        return password;
    }
    //setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
