public class User {

    // ==========================
    // Data Members
    // ==========================

    private String username;
    private String password;
    private String displayName;

    // ==========================
    // Default Constructor
    // ==========================

    public User() {

    }

    // ==========================
    // Parameterized Constructor
    // ==========================

    public User(String username, String password, String displayName) {

        this.username = username;
        this.password = password;
        this.displayName = displayName;

    }

    // ==========================
    // Getters
    // ==========================

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }

    // ==========================
    // Setters
    // ==========================

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    // ==========================
    // toString()
    // ==========================

    @Override
    public String toString() {

        return "User{" +
                "username='" + username + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';

    }

}