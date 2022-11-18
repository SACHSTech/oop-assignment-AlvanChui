package Steam;

public class UserProfile {
    //VARIABLES
    private String username;
    private String realName;
    private String psw;
    private String location;
    private String gender;
    private String birthday;
    private String email;
    private double balanace;

    //CONSTRUCTOR
    public UserProfile(String usernameStr, String realNameStr, String pswStr, String locationStr, String genderStr, String birthdayStr, String emailStr, double balanceDouble) {
        username = usernameStr;
        realName = realNameStr;
        psw = pswStr;
        location = locationStr;
        gender = genderStr;
        birthday = birthdayStr;
        email = emailStr;
        balanace = balanceDouble;
    }

    //METHODS

    //GETTERS
    public String getUsername() {
        return username;
    }
    public String getRealName() {
        return realName;
    }
    public String getPsw() {
        return psw;
    }
    public String getLocation() {
        return location;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }
    public double getBalanace() {
        return balanace;
    }
    /**
     * Displays the user's profile
     */
    public void DisplayProfile(){
        System.out.println("========================================");
        System.out.println("Username:" + getUsername()); 
        System.out.println("Email Address: " + getEmail());
        System.out.println("Steam Wallet Balance: $" + getBalanace());
        System.out.println("Store Location: " + getLocation());
        System.out.println("Realname: " + getRealName());
        System.out.println("Gender: " + getGender());
        System.out.println("Birthday: " + getBirthday());
        System.out.println("========================================");
    }
}
