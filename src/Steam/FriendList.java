package Steam;

import Steam.*;

public class FriendList {
    //VARIABLES
    private String frdName;
    private String frdNickname;
    private boolean frdOnline;
    private String nowPlaying;
    public int totalFrds = 0;
    public int numFrdsOnline = 0;

    //CONSTRUCTOR
    public FriendList(String nameStr, String nicknameStr, boolean onlineBool
    , String nowPlayingStr){
        frdName = nameStr;
        frdNickname = nicknameStr;
        frdOnline = onlineBool;
        nowPlaying = nowPlayingStr;
        
        if (frdOnline)
            numFrdsOnline++;
        totalFrds++;
    }

    //METHODS
    public String getFrdName() {
        return frdName;
    }
    public String getFrdNickname() {
        return frdNickname;
    }
    public String getNowPlaying() {
        return nowPlaying;
    }
    public int getNumFrdsOnline() {
        return numFrdsOnline;
    }
    public int getTotalFrds() {
        return totalFrds;
    }
    public boolean isFrdOnline() {
        return frdOnline;
    }
    public String TotalNoOfFrdsOnline(){
        return getNumFrdsOnline() + " out of " + getTotalFrds() + "are online."; 
    }
    public String friendStatus() {
        if (isFrdOnline() && getNowPlaying() != ""){ 
            return getFrdNickname() + "(" + getFrdName() + ") is online, currently playing " + getNowPlaying() + ". ";
        }
        else if(isFrdOnline()){
            return getFrdNickname() + "(" + getFrdName() + ") is online. ";
        }
        else{
            return getFrdNickname() + "(" + getFrdName() + ") is offline. ";
        }
    }
}
