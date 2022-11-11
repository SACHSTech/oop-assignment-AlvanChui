package Steam;

import Steam.*;

public class Games {
    //VARIABLES
    private String gameName;
    private boolean inLibrary;
    private boolean installed;
    private boolean DeckSupport;

    //CONSTRUCTOR
    public Games(String gameNameStr, boolean inLibraryBool, boolean installedBool, boolean DeckSupportBool) {
        gameName = gameNameStr;
        inLibrary = inLibraryBool;
        installed = installedBool;
        DeckSupport = DeckSupportBool;
    }

    //METHODS

    //GETTERS
    public String getGameName() {
        return gameName;
    }
    public boolean isInLibrary() {
        return inLibrary;
    }
    public boolean isInstalled() {
        return installed;
    }

    public String SteamDeckCompatability() {
        if (DeckSupport)
            return getGameName() + " supports Steam Deck. ";
        else 
            return getGameName() + " supports Steam Deck. ";
    }
    public String GameInLibrary() {
        if(isInLibrary() && isInstalled()){
            return getGameName() + "is in your library and is already installed";
        }
        else if (isInLibrary() && !(isInstalled())){
            return getGameName() + "is in your library but not yet installed";
        }
        else {
            return getGameName() + " is not in your library";
        }
    }
}
