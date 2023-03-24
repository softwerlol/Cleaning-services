package app;

public class Users {

    public final String userName;
    public final String password;
    public final String role;
    protected boolean isSignedIn;

    public Users(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.isSignedIn = false;
    }

    public boolean checkUserName(String userName) {
        return this.userName.equals(userName);
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }


    public boolean signIn(String userName, String password) {
        this.isSignedIn = checkUserName(userName) && checkPassword(password);
        return this.isSignedIn;
    }

    public boolean checkRole(String role) {
        return this.role.equals(role);
    }


    public boolean signOut() {
        this.isSignedIn = false;
        return this.isSignedIn;
    }

    public boolean isSignedIn() {
        return this.isSignedIn;
    }

    @Override
    public boolean equals(Object o) {
        if  (!(o instanceof Users))
            return false;
        Users other = (Users) o;
        return (this.userName.equals(other.userName) && this.password.equals(other.password) && this.role.equals(other.role));
    }

    @Override
    public int hashCode() {
        return 0;
    }


}
