package Steam;

import Steam.*;

public class GamesLibrary extends Games{
    //VARIABLES
    private double totalPlaytime;
    private String lastPlayed;
    private int unlockedAchv;
    private int totalAchv;
    private double percentCompletion;

    //CONSTRUCTOR
    public GamesLibrary(String gameNameStr, boolean installedBool, boolean DeckSupportBool , double totalPlaytimeStr, String lastPlayedStr, int unlockedAchvInt, int totalAchvInt){
        super(gameNameStr, true, installedBool, DeckSupportBool);
        totalPlaytime = totalPlaytimeStr;
        lastPlayed = lastPlayedStr;
        unlockedAchv = unlockedAchvInt;
        totalAchv = totalAchvInt;
    }
    
    //METHODS

    //SETTERS
    public void setPercentCompletion() {
        percentCompletion = getUnlockedAchv() / getTotalAchv() * 100;
    }
    
    //GETTERS
    public double getTotalPlaytime() {
        return totalPlaytime;
    }
    public String getLastPlayed() {
        return lastPlayed;
    }
    public int getUnlockedAchv() {
        return unlockedAchv;
    }
    public int getTotalAchv() {
        return totalAchv;
    }
    public double getPercentCompletion() {
        return percentCompletion;
    }

    public void Game() {
    
        System.out.println("========================================");
        System.out.println(GameInLibrary()); 
        System.out.println("Totalplaytime: " + getTotalPlaytime());
        System.out.println("Last played: " + getLastPlayed());
        System.out.println("Achievements: " + getUnlockedAchv() + "/" + getTotalAchv() + "unlocked (" + getPercentCompletion() + "% completion) ");
        System.out.println(SteamDeckCompatability());
        System.out.println("========================================");

    }
}