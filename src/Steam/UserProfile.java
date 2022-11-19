package Steam;

public class UserProfile {
    //VARIABLES
    private String username;
    private String realName;
    private String PSW;
    private String location;
    private String gender;
    private String birthday;
    private String email;
    private double balance;

    //CONSTRUCTOR
    public UserProfile(String usernameStr, String realNameStr, String PSWStr, String locationStr, String genderStr, String birthdayStr, String emailStr, double balanceDouble) {
        username = usernameStr;
        realName = realNameStr;
        PSW = PSWStr;
        location = locationStr;
        gender = genderStr;
        birthday = birthdayStr;
        email = emailStr;
        balance = balanceDouble;
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
        return PSW;
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
    public double getBalance() {
        return balance;
    }
    //SETTERS
    public void setUsername(String username) {
        this.username = username;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public void setPSW(String psw) {
        this.PSW = psw;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void deposit(double amount) {
        this.balance += amount;
    }
    /**
     * Displays the user's profile
     */
    public void DisplayProfile(){
        System.out.println("========================================");
        System.out.println("Username:" + getUsername()); 
        System.out.println("Email Address: " + getEmail());
        System.out.println("Steam Wallet Balance: $" + getBalance());
        System.out.println("Store Location: " + getLocation());
        System.out.println("Realname: " + getRealName());
        System.out.println("Gender: " + getGender());
        System.out.println("Birthday: " + getBirthday());
        System.out.println("========================================");
    }
}
