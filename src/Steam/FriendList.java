package Steam;

public class FriendList {
    //VARIABLES
    private String frdUsername;
    private String frdNickname;
    private boolean frdOnline;
    private String nowPlaying;

    //CONSTRUCTOR
    public FriendList(String nameStr, String nicknameStr, boolean frdOnlineBool
    , String nowPlayingStr){
        frdUsername = nameStr;
        frdNickname = nicknameStr;
        frdOnline = frdOnlineBool;
        nowPlaying = nowPlayingStr;
    }

    //METHODS
    public String getFrdUsername() {
        return frdUsername;
    }
    public String getFrdNickname() {
        return frdNickname;
    }
    public String getNowPlaying() {
        return nowPlaying;
    }
    public boolean isFrdOnline() {
        return frdOnline;
    }
    public String toString() {
        if (isFrdOnline() && getNowPlaying() != ""){ 
            return getFrdNickname() + "(" + getFrdUsername() + "), online. Currently playing " + getNowPlaying() + ". ";
        }
        else if(isFrdOnline()){
            return getFrdNickname() + "(" + getFrdUsername() + "), online. ";
        }
        else{
            return getFrdNickname() + "(" + getFrdUsername() + "), offline. ";
        }
    }
}
