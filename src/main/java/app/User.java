package app;
import java.util.regex.Pattern;

public class User {

    private String userName;
    private String password;
    protected Address address;
    protected String  email;
    protected String  mobileNumber;
    private String role;
    protected String price;
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    protected boolean []pointer ={false , false  , false , false , false , false, false};

    public User() {}


    public User(String userName,String password) {
        this.setUserName(userName);
        this.setPassword(password);
    }

    public User(String userName) {
        this.setUserName(userName);
    }
    public User(String username2, String password2, String email2, String phoneNumber  ) {
        this.setUserName(username2);
        this.setPassword(password2);
        this.setEmail(email2);
        this.setMobileNumber(phoneNumber);
    }

    public void setIndexPointer(boolean point [] ,boolean value,int index) {
        point[index]=value;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean[] getPointer() {
        return pointer;
    }
    public void setPointer(boolean[] pointer) {
        this.pointer = pointer;
    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean validUsername(String username ,String character ) {

        if(username == null){
            this.pointer[0]= false;
        }

        else if(username.length() != 6){
            this.pointer[0] =false;

        }
        else if(!username.startsWith(character)){
            this.pointer[0] =false;
        }
        else {
            for(int i=0 ;i<5 ; i++) {
                if(username.charAt(i) >= '0' && username.charAt(i) <= '9'){
                    this.pointer[0] =true;
                }
            }
        }
        return this.pointer[0] ;
    }


    public void validPassword(String password) {

        String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null)
            this.pointer[1]=false;


        this.pointer[1]=p.matcher(password).matches();
    }

    public void validEmail(String email)
    {
        String emailRegex1 ="[a-zA-Z0-9_+&*-]+)*@";
        String emailRegex2 ="^[a-zA-Z0-9_+&*-]+(?:\\.";
        String emailRegex =emailRegex2+emailRegex1+"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null || !pat.matcher(email).matches())
        {
            this.pointer[2]=false;
        }
        else if(pat.matcher(email).matches())
        {
            this.pointer[2]= true ;
        }

    }

    public void validMobileNumber(String mobile) {
        String  regex = ("(05)?[6-9]"+"[0-9]{7}");
        Pattern p = Pattern.compile(regex);
        this.pointer[3]=p.matcher(mobile).matches();
    }


}
