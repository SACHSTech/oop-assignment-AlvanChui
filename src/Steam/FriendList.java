package Steam;

import Steam.*;

public class FriendList {
    //VARIABLES
    private String name;
    private String nickname;
    private boolean online;
    private String nowPlaying;
    public int totalFriends = 0;
    public int friendsOnline = 0;

    //CONSTRUCTOR
    public FriendList(String nameStr, String nicknameStr, boolean onlineBool
    , String nowPlayingStr){
        name = nameStr;
        nickname = nicknameStr;
        online = onlineBool;
        nowPlaying = nowPlayingStr;
        
        if (online)
            friendsOnline++;
        totalFriends++;
    }

    //METHODS
    public String NoOfFrdsOnline(){
        return friendsOnline + " out of " + totalFriends + "are online."; 
    }
    public String friendStatus() {
        if (online && nowPlaying != ""){ 
            return nickname + "(" + name + ") is online, currently playing " + nowPlaying + ". ";
        }
        else if(online){
            return nickname + "(" + name + ") is online. ";
        }
        else{
            return nickname + "(" + name + ") is offline. ";
        }
    }
}
