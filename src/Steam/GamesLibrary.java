package Steam;

import Steam.*;

public class GamesLibrary extends Games{
    //VARIABLES
    private double totalPlaytime;
    private String lastPlayed;
    private int unlockedAchievements;
    private double percentCompletion;
    
    //CONSTRUCTOR
    public GamesLibrary(String gameNameStr, boolean installedBool, boolean DeckSupportBool , double totalPlaytimeStr, String lastPlayedStr, int unlockedAchievementsInt, int totalAchievementsInt){
        super(gameNameStr, true, installedBool, DeckSupportBool, totalAchievementsInt);
        totalPlaytime = totalPlaytimeStr;
        lastPlayed = lastPlayedStr;
        unlockedAchievements = unlockedAchievementsInt;
    }
    
    //METHODS
    public double getTotalPlaytime() {
        return totalPlaytime;
    }
    public String getLastPlayed() {
        return lastPlayed;
    }
    public int getUnlockedAchievements() {
        return unlockedAchievements;
    }
    public double getPercentCompletion() {
        return percentCompletion;
    }
    public void setPercentCompletion() {
        percentCompletion = getUnlockedAchievements() / super.getTotalAchievements() * 100;
    }

    public void Game(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println(super.getGameName() + "is in your libary. ");
        System.out.println(GameInstalled()); 
        System.out.println("Totalplaytime: " + getTotalPlaytime());
        System.out.println("Last played: " + getLastPlayed());
        System.out.println("Achievements: " + getUnlockedAchievements() + "/" + super.getTotalAchievements() + "unlocked (" + getPercentCompletion() + "% completion) ");
        System.out.println(SteamDeckCompatability());
        System.out.println("-------------------------------------------------------------------");
    }
}