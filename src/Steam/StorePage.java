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
        percentRating = ((double)getPositiveReviews()/(double)getTotalReviews() * 100);
    }
    public void setRating() {
        if (getPercentRating() >= 90)
            rating = "Overwhelmingly positive";
        else if (getPercentRating() >= 75)
            rating = "Mostly positive";
        else if (getPercentRating() >= 60)
            rating = "Positive";
        else if (getPercentRating() >= 40)
            rating = "Mixed";
        else if (getPercentRating() >= 25)
            rating = "Negative";
        else if (getPercentRating() >= 10)
            rating = "Mostly negative";
        else 
            rating = "Overwhelmingly negative";
    }
    public void setRecentPercentRating() {
        recentPercentRating = (double)getRecentPositiveReviews()/(double)getRecentReviews() * 100;
    }
    public void setRecentRating() {
        if (getRecentPercentRating() >= 90)
            recentRating = "Overwhelmingly positive";
        else if (getRecentPercentRating() >= 75)
            recentRating = "Mostly positive";
        else if (getRecentPercentRating() >= 60)
            recentRating = "Positive";
        else if (getRecentPercentRating() >= 40)
            recentRating = "Mixed";
        else if (getRecentPercentRating() >= 25)
            recentRating = "Negative";
        else if (getRecentPercentRating() >= 10)
            recentRating = "Mostly negative";
        else
            recentRating = "Overwhelmingly negative";
    }
    public void setPrice() {
        price = getMarkedPrice() * (100-getDiscount()) / 100;
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
    public double getPrice() {
        return price;
    }
    public int getTotalReviews() {
        return totalReviews;
    }
    public int getPositiveReviews() {
        return positiveReviews;
    }
    public int getRecentReviews() {
        return recentReviews;
    }
    public int getRecentPositiveReviews() {
        return recentPositiveReviews;
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

        System.out.println("============ " + getGameName() + " ============");
        System.out.println(GameInLibrary());
        if(!isInLibrary()) {
            System.out.println("Marked Price: " + getMarkedPrice());
            System.out.println("Price: " + String.format("%.2f", getPrice()) + " (-" + getDiscount() + "%)");
        }
        System.out.println("------------ Reviews ------------");
        System.out.println(getRating() + " (" + String.format("%.2f", getPercentRating()) + "% of " + getTotalReviews() + ") ALL TIME");
        System.out.println(getRecentRating() + " (" + String.format("%.2f", getRecentPercentRating()) + "% of " + getRecentReviews() + ") RECENT");
        System.out.println("----- Additional Information -----");
        System.out.println("Developer: " + getDeveloper());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Release Date: " + getReleaseDate());
        System.out.println("Game Length: ~" + getGameLength() + "hours");
        System.out.println(SteamDeckCompatability());
        System.out.println("===================================");
    }
}
