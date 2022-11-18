package Steam;

import java.io.*;
import Steam.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Steam sign in");
        System.out.print("Enter your username: ");
        String name = keyboard.readLine();
        System.out.print("Enter your password: ");
        String password = keyboard.readLine();
        System.out.print("Enter your email address: ");
        String emailAddress = keyboard.readLine();
        System.out.print("Enter your store location: ");
        String storeLocation = keyboard.readLine();
        System.out.print("Enter your real name: ");
        String realName = keyboard.readLine();
        System.out.print("Enter your gender: ");
        String gender = keyboard.readLine();
        System.out.print("Enter your birthday: ");
        String birthday = keyboard.readLine();
        System.out.print("Do you want to deposit to your Steam wallet?(Y/N)");
        String answer = keyboard.readLine();
        double amount = 0.0;
        if (answer.equalsIgnoreCase("Y")) {
            System.out.print("How much do you want to deposit? $");
            amount += Double.parseDouble(keyboard.readLine());
            System.out.println("Successfully deposit into your account. ");
            System.out.println("There is now $"+ amount + " in your steam wallet");
        }

        UserProfile user = new UserProfile(name, realName, password, storeLocation, gender, birthday, emailAddress, amount);

        System.out.println("sign in as " + user.getUsername() + "...");
        System.out.println();
        System.out.println("Press ENTER to continue.");
        keyboard.readLine();        
        System.out.println("Welcome to Steam, " + user.getUsername());
        
        ArrayList<String> gameLibArrayList = new ArrayList<String>();
        ArrayList<String> storeArrayList = new ArrayList<String>();
        ArrayList<String> FrdsArrayList = new ArrayList<String>();

        //existing games
        GamesLibrary MGRR = new GamesLibrary("Metal Gear Rising: Revengence", true, false, 12.5, "12 June, 2022",20, 30);
        StorePage MGRR_Store = new StorePage(MGRR.getGameName(), MGRR.isInLibrary(), MGRR.isInstalled(), MGRR.isDeckSupport(), 23.99, 0, "Platinum Games", "KONAMI", "9 July 2013", 8, 917561, 880047, 3166, 1002);
        gameLibArrayList.add(MGRR.getGameName());
        storeArrayList.add(MGRR_Store.getGameName());

        GamesLibrary DS3 = new GamesLibrary("Dark Souls 3", true, true, 42.5, "18 July 2021",30, 50);
        StorePage DS3_Store = new StorePage(DS3.getGameName(), DS3.isInLibrary(), DS3.isInstalled(), DS3.isDeckSupport(), 34.99, 25, "FromSoftware", "FromSoftware", "4 December 2017", 30, 7572933, 7022048, 20758, 17874);
        gameLibArrayList.add(DS3.getGameName());
        storeArrayList.add(DS3_Store.getGameName());

        GamesLibrary GTAVI = new GamesLibrary("Grand Theft Auto VI", false, false, 7328, "11 October 2022", 100, 100);
        StorePage GTAVI_Store = new StorePage(GTAVI.getGameName(), GTAVI.isInLibrary(), GTAVI.isInstalled(), GTAVI.isDeckSupport(), 40.00, 50, "Rockstar Games", "Rockstar Games", "1 April 2022", 120, 9999999, 9999999, 174592, 17492); 
        gameLibArrayList.add(GTAVI.getGameName());
        storeArrayList.add(GTAVI_Store.getGameName());


        
        String menu = "";
        while(!(menu.equals("Exit Steam"))){
            System.out.println("Which page you want to go to?(| Store | Library | Friends | Profile | Exit Steam |");
            menu = keyboard.readLine();

            if(menu.equals("Store")){
                System.out.print("Enter a game's Name: ");
                String gameName = keyboard.readLine();
                boolean gameExist = false;
                int counter = -1;
                for(int i = 0; i < storeArrayList.size(); i++){
                    if (gameName.equals(storeArrayList.get(i))){
                        gameExist = true;
                        counter = i;
                        break;
                    }
                }
                if (gameExist == false){
                    storeArrayList.add(gameName);
                    System.out.println("Game deceted, would you like to fill in the game's info?(Y/N)");
                    String reply = keyboard.readLine();
                    if (reply.equalsIgnoreCase("Y")){
                        System.out.print("Who is the developer? ");
                        String developer = keyboard.readLine();
                        System.out.print("Who is the publisher? "); 
                        String publisher = keyboard.readLine();
                        System.out.print("How much is the game?");
                        double cost = Double.parseDouble(keyboard.readLine());
                        int discount = 0;
                        System.out.print("Is there any discount right now?(Y/N) ");
                        String haveDiscount = keyboard.readLine();
                        if (haveDiscount.equalsIgnoreCase("Y")){
                            System.out.print("How many % off? ");
                            discount = Integer.parseInt(keyboard.readLine());
                        }
                        System.out.print("When was the release date? ");
                        String releaseDate = keyboard.readLine();
                        System.out.print("How long is the game? ");
                        int gameLength = Integer.parseInt(keyboard.readLine());
                        boolean deckSupport = false;
                        System.out.print("Does the game supports steam deck?(Y/N) ");
                        String SDSupport = keyboard.readLine();
                        if(SDSupport.equalsIgnoreCase("Y")){
                            deckSupport = true;
                        }

                        System.out.println("Data of all time reviews: ");
                        System.out.print("Total number of reviews? ");
                        int reviews = Integer.parseInt(keyboard.readLine());
                        System.out.print("Number of positive reviews? ");
                        int posReviews = Integer.parseInt(keyboard.readLine());
                        System.out.println("Data of recent reviews: ");
                        System.out.print("Number of recent reviews? ");
                        int recentReviews = Integer.parseInt(keyboard.readLine());
                        System.out.print("Numbr of recent positive reviews? ");
                        int posRecentReviews = Integer.parseInt(keyboard.readLine());
                        System.out.println();

                        StorePage newGame = new StorePage(gameName, false, false, deckSupport, cost, discount, developer, publisher, releaseDate, gameLength, reviews, posReviews, recentReviews, posRecentReviews);
                        newGame.setPrice();
                        newGame.setPercentRating();
                        newGame.setRating();
                        newGame.setRecentPercentRating();
                        newGame.setRecentRating();
                        System.out.println("Successfully filled in the game's info. ");
                        System.out.println("------------------------------------");
                        newGame.gameStorePage();
                        
                        if(newGame.isInLibrary() == false){
                            System.out.println("The game is not in your library, do you want to buy it?(Y/N) ");
                            String add = keyboard.readLine();
                            if (add.equalsIgnoreCase("Y")){
                                System.out.println("The game" +  newGame.getGameName() + "costs" +String.format("%.2f", newGame.getPrice()) + ".");
                                System.out.println("========== Purchase Confirmation==========");
                                if (newGame.getPrice() < user.getBalanace()){
                                    System.out.println("you have $" + user.getBalanace() + ", do you want to purchase the game? ");
                                }
                                else{
                                    System.out.println("you have $" + user.getBalanace() + ", you dont have enough money in your steam wallet");

                                }
                            }
                        }
                    }
                    System.out.println("Return to Home page...");
                }
            }
            else if(menu.equals("Library")){
                System.out.println("-------------Games List-------------");
                for(int i = 0; i < gameLibArrayList.size(); i++){
                    System.out.println(gameLibArrayList.get(i));
                }
                System.out.println("------------------------------------");
                System.out.print("Check Game Info: ");
                String OpenedGame = keyboard.readLine();
            }
            else if(menu.equals("Friends")){
                
            }
            else if(menu.equals("Profile")){
                user.DisplayProfile();
            }
            else if(menu.equals("Exit Steam")){
                System.exit(0);
            }
            else{
                System.out.println("Page not found.");
                System.out.println("Return to Home page...");
            }
        }
    }
}
