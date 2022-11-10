package Steam;

public class StorePage extends Games {
    private double markedPrice;
    private int discount;
    private double price;
    private String developer;
    private String publisher;
    private String releaseDate;
    private int gameLength;
    
    public StorePage(String gameNameString, boolean inLibraryBool, boolean installedBool, boolean DeckSupportBool, int totalAchievementsInt, double markedPriceDouble, int discountInt, String developerString, String publisherString, String releaseDateString, int gameLengthInt){
        super(gameNameString, inLibraryBool, installedBool, DeckSupportBool, totalAchievementsInt);
        markedPrice = markedPriceDouble;
        discount = discountInt;
        developer = developerString;
        publisher = publisherString;
        releaseDate = releaseDateString;
        gameLength = gameLengthInt;
    }
    public String getDeveloper() {
        return developer;
    }
    public String getPublisher() {
        return publisher;
    }
    public double getMarkedPrice() {
        return markedPrice;
    }
    public int getDiscount() {
        return discount;
    }
    public void setPrice() {
        price = markedPrice * discount / 100;
    }

}
