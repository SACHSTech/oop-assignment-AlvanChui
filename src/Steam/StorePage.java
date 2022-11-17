package Steam;
public class StorePage extends Games {
    //VARIABLES
    private double markedPrice;
    private int discount;
    private double price;
    private String developer;
    private String publisher;
    private String releaseDate;
    private int gameLength;
    private int totalReviews;
    private int positiveReviews;
    private double percentRating;
    private String rating;
    private int recentReviews;
    private int recentPositiveReviews;  
    private double recentPercentRating;
    private String recentRating;

    //CONSTRUCTOR
    public StorePage(String gameNameString, boolean inLibraryBool, boolean installedBool, boolean DeckSupportBool, double markedPriceDouble, int discountInt, String developerString, String publisherString, String releaseDateString, int gameLengthInt, int totalReviewsInt, int positiveReviewsInt, int recentReviewsInt, int recentPositiveReviewsInt){
        
        super(gameNameString, inLibraryBool, installedBool, DeckSupportBool);
        markedPrice = markedPriceDouble;
        discount = discountInt;
        developer = developerString;
        publisher = publisherString;
        releaseDate = releaseDateString;
        gameLength = gameLengthInt;
        totalReviews = totalReviewsInt;
        recentReviews = recentReviewsInt;
        positiveReviews = positiveReviewsInt;
        recentPositiveReviews = recentPositiveReviewsInt;

    }
    //METHODS

    //SETTERS
    public void setPercentRating(){
        percentRating = positiveReviews / totalReviews * 100;
    }
    public void setRating() {
        if (percentRating >= 90)
            rating = "Overwhelmingly positive";
        else if (percentRating >= 75)
            rating = "Mostly positive";
        else if (percentRating >= 60)
            rating = "Positive";
        else if (percentRating >= 40)
            rating = "Mixed";
        else if (percentRating >= 25)
            rating = "Negative";
        else if (percentRating >= 10)
            rating = "Mostly negative";
        else 
            rating = "Overwhelmingly negative";
    }
    public void setRecentPercentRating() {
        recentPercentRating = recentPositiveReviews / recentReviews * 100;
    }
    public void setRecentRating() {
        if (recentPercentRating >= 90)
            recentRating = "Overwhelmingly positive";
        else if (recentPercentRating >= 75)
            recentRating = "Mostly positive";
        else if (recentPercentRating >= 60)
            recentRating = "Positive";
        else if (recentPercentRating >= 40)
            recentRating = "Mixed";
        else if (recentPercentRating >= 25)
            recentRating = "Negative";
        else if (recentPercentRating >= 10)
            recentRating = "Mostly negative";
        else
            recentRating = "Overwhelmingly negative";
    }

    //GETTERS
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
    public String getReleaseDate() {
        return releaseDate;
    }
    public int getGameLength() {
        return gameLength;
    }
    public void setPrice() {
        price = markedPrice * (100-discount) / 100;
    }
    public double getPrice() {
        return price;
    }
    public int getTotalReviews() {
        return totalReviews;
    }
    public int getRecentReviews() {
        return recentReviews;
    }
    public double getPercentRating() {
        return percentRating;
    }
    public String getRating() {
        return rating;
    }
    public double getRecentPercentRating() {
        return recentPercentRating;
    }
    public String getRecentRating() {
        return recentRating;
    }
    public void gameStorePage() {

        System.out.println("========== " + getGameName() + " ==========");
        System.out.println();
            System.out.println(GameInLibrary());
        if(isInLibrary()) {
            System.out.println("Marked Price: " + getMarkedPrice());
            System.out.println("Price: " + getPrice() + " (-" + getDiscount() + "%)");
        }
        System.out.println("------------ Reviews ------------");
        System.out.println(getRating() + " (" + getPercentRating() + "% of " + getTotalReviews() + ") ALL TIME");
        System.out.println(getRecentRating() + " (" + getRecentPercentRating() + "% of" + getRecentReviews() + ") RECENT");
        System.out.println();
        System.out.println("----- Additional Information -----");
        System.out.println("Developer: " + getDeveloper());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Release Date: " + getReleaseDate());
        System.out.println("Game Length: ~" + getGameLength() + "hours");
        System.out.println(SteamDeckCompatability());
        System.out.println("===================================");

    }
}
