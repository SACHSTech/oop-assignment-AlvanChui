package Steam;

import java.util.concurrent.Flow.Publisher;

import Steam.*;

public class Games {
    //VARIABLES
    private String gameName;
    private boolean inLibrary;
    private boolean installed;
    private boolean DeckSupport;
    private int totalAchievements;
    private int totalReviews;
    private int recentReviews;  

    //CONSTRUCTOR
    public Games(String gameNameStr, boolean inLibraryBool, boolean installedBool, boolean DeckSupportBool, int totalAchievementsInt){
        gameName = gameNameStr;
        inLibrary = inLibraryBool;
        installed = installedBool;
        DeckSupport = DeckSupportBool;
        totalAchievements = totalAchievementsInt;

    }
    //METHODS
    public String getGameName() {
        return gameName;
    }
    public int getTotalAchievements() {
        return totalAchievements;
    }

    public String SteamDeckCompatability(){
        if (DeckSupport)
            return getGameName() + " supports Steam Deck. ";
        else 
            return getGameName() + " supports Steam Deck. ";
    }
    public String GameInstalled(){
        if (installed)
            return getGameName() + "the game is installed on your PC. ";
        else 
            return getGameName() + "is not installed on your PC. ";
    }
}
