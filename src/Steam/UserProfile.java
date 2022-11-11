package Steam;

public class UserProfile {
    //VARIABLES
    private String username;
    private String realName;
    private String psw;
    private String bio;
    private String location;
    private int balanace;

    //CONSTRUCTOR
    public UserProfile(String usernameStr, String realNameStr, String pswStr, String bioStr, String locationStr, int balanceInt) {
        username = usernameStr;
        bio = bioStr;
        location = locationStr;
        balanace = balanceInt;
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
    public String getBio() {
        return bio;
    }
    public String getLocation() {
        return location;
    }
    public int getBalanace() {
        return balanace;
    }
}
