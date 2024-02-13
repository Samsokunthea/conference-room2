public class admin {
    private String username;
    private String password;

    public admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getusername() {
        return username;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }
}
