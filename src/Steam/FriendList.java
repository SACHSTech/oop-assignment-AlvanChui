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
    
    public String NoOfFrdsOnline(){
        return numFrdsOnline + " out of " + totalFrds + "are online."; 
    }
    public String friendStatus() {
        if (frdOnline && nowPlaying != ""){ 
            return frdNickname + "(" + frdName + ") is online, currently playing " + nowPlaying + ". ";
        }
        else if(frdOnline){
            return frdNickname + "(" + frdName + ") is online. ";
        }
        else{
            return frdNickname + "(" + frdName + ") is offline. ";
        }
    }
}
