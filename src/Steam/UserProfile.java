package Steam;

public class UserProfile {
    //VARIABLES
    private String username;
    private String realName;
    private String psw;
    private String location;
    private char gender;
    private String birthday;
    private String email;
    private double balanace;

    //CONSTRUCTOR
    public UserProfile(String usernameStr, String realNameStr, String pswStr, String locationStr, char genderChar, String birthdayStr, String emailStr, double balanceDouble) {
        username = usernameStr;
        realName = realNameStr;
        psw = pswStr;
        location = locationStr;
        gender = genderChar;
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
    public Character getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }
    public double getBalanace() {
        return balanace;
    }
}
