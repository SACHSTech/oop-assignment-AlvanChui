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
        double amount = 0.0;
        String answer = keyboard.readLine();
        while (!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N"))){
            System.out.println("please enter a valid answer. ");
            answer = keyboard.readLine();
        }
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
        
        //arrayLists that stores the game library information
        ArrayList<String> gameNameArrayList = new ArrayList<String>();
        ArrayList<GamesLibrary> gamesLibArrayList = new ArrayList<GamesLibrary>();
        //arrayLists that stores the store page information
        ArrayList<String> storeNameArrayList = new ArrayList<String>();
        ArrayList<StorePage> storePageArrayList = new ArrayList<StorePage>();
        //arrayList that stores friends information
        ArrayList<FriendList> FrdsArrayList = new ArrayList<FriendList>();


        //default existing games
        GamesLibrary MGRR = new GamesLibrary("Metal Gear Rising: Revengence", true, false, 12.5, "12 June, 2022",20, 30);
        StorePage MGRR_Store = new StorePage(MGRR.getGameName(), MGRR.isInLibrary(), MGRR.isInstalled(), MGRR.isDeckSupport(), 23.99, 0, "Platinum Games", "KONAMI", "9 July 2013", 8, 917561, 880047, 3166, 1002);
        gameNameArrayList.add(MGRR.getGameName());
        storeNameArrayList.add(MGRR_Store.getGameName());
        gamesLibArrayList.add(MGRR);
        storePageArrayList.add(MGRR_Store);

        GamesLibrary DS3 = new GamesLibrary("Dark Souls 3", true, true, 42.5, "18 July 2021",30, 50);
        StorePage DS3_Store = new StorePage(DS3.getGameName(), DS3.isInLibrary(), DS3.isInstalled(), DS3.isDeckSupport(), 34.99, 25, "FromSoftware", "FromSoftware", "4 December 2017", 30, 7572933, 7022048, 20758, 17874);
        gameNameArrayList.add(DS3.getGameName());
        storeNameArrayList.add(DS3_Store.getGameName());
        gamesLibArrayList.add(DS3);
        storePageArrayList.add(DS3_Store);

        GamesLibrary GTAVI = new GamesLibrary("Grand Theft Auto VI", false, false, 7328, "11 October 2022", 100, 100);
        StorePage GTAVI_Store = new StorePage(GTAVI.getGameName(), GTAVI.isInLibrary(), GTAVI.isInstalled(), GTAVI.isDeckSupport(), 40.00, 50, "Rockstar Games", "Rockstar Games", "1 April 2022", 120, 9999999, 9999999, 174592, 17492); 
        gameNameArrayList.add(GTAVI.getGameName());
        storeNameArrayList.add(GTAVI_Store.getGameName());
        gamesLibArrayList.add(GTAVI);
        storePageArrayList.add(GTAVI_Store);
        
        //default existing friends
        FriendList Imposter = new FriendList("Imposter", "Sussy Impasta", true, "");
        FrdsArrayList.add(Imposter);

        FriendList JackCooper = new FriendList("Jack_Cooper", "BT-7274", true, "TitanFall 2");
        FrdsArrayList.add(JackCooper);

        FriendList Vergil = new FriendList("Vergil", "Bury the light", false, "");
        FrdsArrayList.add(Vergil);

        //Menu
        String menu = "";
        while(!(menu.equals("Exit Steam"))){
            System.out.println("Which page you want to go to? (| Store | Library | Friends | Profile | Exit Steam |");
            menu = keyboard.readLine();
            
            //StorePage
            if(menu.equals("Store")){
                String ReturnToMenu = "N";
                while(!ReturnToMenu.equalsIgnoreCase("Y")){
                    System.out.print("Enter a game's Name: ");
                    String gameName = keyboard.readLine();
                    boolean gameExist = false;
                    int counter = -1;
                    for(int i = 0; i < storeNameArrayList.size(); i++){
                        if (gameName.equals(storeNameArrayList.get(i))){
                            gameExist = true;
                            counter = i;
                            break;
                        }
                        
                    }
                    if (gameExist == true){
                        //get data of an existing game from the array list
                        storePageArrayList.get(counter).setPrice();
                        storePageArrayList.get(counter).setPercentRating();
                        storePageArrayList.get(counter).setRating();
                        storePageArrayList.get(counter).setRecentPercentRating();
                        storePageArrayList.get(counter).setRecentRating();
                        //display the information of the game
                        storePageArrayList.get(counter).gameStorePage();
                    }
                    else if (gameExist == false){
                        //collect data of a new game
                        System.out.println("New game detected, would you like to fill in the game's info?(Y/N) ");
                        String reply = keyboard.readLine();
                        while (!(reply.equalsIgnoreCase("Y") || reply.equalsIgnoreCase("N"))){
                            System.out.println("please enter a valid answer. ");
                            reply = keyboard.readLine();
                        }
                        if (reply.equalsIgnoreCase("Y")){
                            storeNameArrayList.add(gameName);
                            //filling out the information of the game
                            System.out.println("==================================");
                            System.out.print("Who is the developer? ");
                            String developer = keyboard.readLine();
                            System.out.print("Who is the publisher? "); 
                            String publisher = keyboard.readLine();
                            System.out.print("How much is the game? ");
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
                            System.out.print("Total number of achievements: ");
                            int totalAchievements = Integer.parseInt(keyboard.readLine());


                            System.out.print("Does the game supports steam deck?(Y/N) ");
                            String SDSupport = keyboard.readLine();
                            while (!(SDSupport.equalsIgnoreCase("Y") || SDSupport.equalsIgnoreCase("N"))){
                                System.out.println("please enter a valid answer. ");
                                SDSupport = keyboard.readLine();
                            }
                            if(SDSupport.equalsIgnoreCase("Y")){
                                deckSupport = true;
                            }
                            System.out.println();
                            //Set Reviews
                            System.out.println("---- Data of ALL TIME reviews ----");
                            System.out.print("Number of reviews: ");
                            int reviews = Integer.parseInt(keyboard.readLine());
                            System.out.print("Number of positive reviews: ");
                            int posReviews = Integer.parseInt(keyboard.readLine());
                            while(posReviews > reviews){
                                System.out.println("please enter a valid number. ");
                                posReviews = Integer.parseInt(keyboard.readLine());
                            }
                            System.out.println("----- Data of RECENT reviews -----");
                            System.out.print("Number of reviews: ");
                            int recentReviews = Integer.parseInt(keyboard.readLine());
                            while(recentReviews > reviews){
                                System.out.println("please enter a valid number. ");
                                recentReviews = Integer.parseInt(keyboard.readLine());
                            }
                            System.out.print("Numbr of recent positive reviews: ");
                            int posRecentReviews = Integer.parseInt(keyboard.readLine());
                            while(posRecentReviews > recentReviews){
                                System.out.println("please enter a valid number. ");
                                posRecentReviews = Integer.parseInt(keyboard.readLine());
                            }
                            System.out.println("----------------------------------");

                            //Create an Object to store the data
                            StorePage newGame = new StorePage(gameName, false, false, deckSupport, cost, discount, developer, publisher, releaseDate, gameLength, reviews, posReviews, recentReviews, posRecentReviews);
                            newGame.setPrice();
                            newGame.setPercentRating();
                            newGame.setRating();
                            newGame.setRecentPercentRating();
                            newGame.setRecentRating();
                            System.out.println("Successfully filled in the game's info. ");
                            System.out.println("==================================");
                            newGame.gameStorePage();
                            
                            if(newGame.isInLibrary() == false){
                                System.out.println("The game is not in your library, do you want to buy it?(Y/N) ");
                                String add = keyboard.readLine();
                                while (!(add.equalsIgnoreCase("Y") || add.equalsIgnoreCase("N"))){
                                    System.out.println("please enter a valid answer. ");
                                    add = keyboard.readLine();
                                }
                                if (add.equalsIgnoreCase("Y")){
                                    System.out.println("The game" +  newGame.getGameName() + "costs" +String.format("%.2f", newGame.getPrice()) + ".");
                                    System.out.println("========== Purchase Confirmation==========");
                                    if (newGame.getPrice() <= user.getBalance()){
                                        System.out.println("you have $" + user.getBalance() + ", you have enough money to buy " + newGame.getGameName());
                                        System.out.println("Enter your password to confirm your purchase");
                                        String confirmpsw = keyboard.readLine();
                                        while (!confirmpsw.equals(user.getPsw())){
                                            System.out.println("your password is wrong, please enter again: ");
                                        }
                                        newGame.setInLibrary(true);
                                        GamesLibrary newGameInLibrary = new GamesLibrary(newGame.getGameName(), false, newGame.isDeckSupport(), 0, "never played", 0, totalAchievements);
                                        gamesLibArrayList.add(newGameInLibrary);
                                    }
                                    else{
                                        System.out.println("you have $" + user.getBalance() + ", you dont have enough money in your steam wallet");
                                    }
                                }
                            }
                        }
                    }
                    System.out.println();
                    System.out.println("Do you want to return to Menu Page?(Y/N) ");
                    ReturnToMenu = keyboard.readLine();
                    while(!(ReturnToMenu.equalsIgnoreCase("Y") || ReturnToMenu.equalsIgnoreCase("N"))){
                        System.out.println("please enter a valid answer. ");
                        ReturnToMenu = keyboard.readLine();
                    }
                }
                System.out.println("Returning to Menu page...");
            }

            //Library
            else if(menu.equals("Library")){
                String ReturnToMenu = "N";
                while(!ReturnToMenu.equalsIgnoreCase("Y")){
                    System.out.println("-------------Games List-------------");
                    for(int i = 0; i < gameNameArrayList.size(); i++){
                        System.out.print((i + 1) + ". ");
                        System.out.println(gameNameArrayList.get(i));
                    }
                    System.out.println("------------------------------------");
                    System.out.print("Enter the number of a game on the list: ");
                    int number = Integer.parseInt(keyboard.readLine());
                    while(number < 0 || number >= gameNameArrayList.size()){
                        System.out.println("please enter a valid number");
                        number = Integer.parseInt(keyboard.readLine());

                    }
                    System.out.println(gamesLibArrayList.get(number - 1));
                    
                    System.out.println();
                    System.out.println("Do you want to return to Menu Page?(Y/N) ");
                    ReturnToMenu = keyboard.readLine();
                    while(!(ReturnToMenu.equalsIgnoreCase("Y") || ReturnToMenu.equalsIgnoreCase("N"))){
                        System.out.println("please enter a valid answer. ");
                        ReturnToMenu = keyboard.readLine();
                    }
                }
                System.out.println("Returning to Menu page...");
            }

            //Friends
            else if(menu.equals("Friends")){
                String ReturnToMenu = "N";
                System.out.println("=============== Friend List ===============");
                System.out.println();
                for(int i = 0; i < FrdsArrayList.size(); i++){
                    System.out.println(FrdsArrayList.get(i));
                }
                while(!ReturnToMenu.equalsIgnoreCase("Y")){
                    String addFrd = keyboard.readLine();
                    System.out.println("Add a new friend?(Y/N) ");
                    while(!(addFrd.equalsIgnoreCase("Y") || addFrd.equalsIgnoreCase("N"))){
                        System.out.println("please enter a valid answer. ");
                        addFrd = keyboard.readLine();
                    }
                    if(addFrd.equalsIgnoreCase("Y")){
                        System.out.println("what is the username of the friend? ");
                        String FrdUsername = keyboard.readLine();
                        System.out.println("what is the nickname of the friend");
                        String FrdNickname = keyboard.readLine();
                        System.out.println("Is the friend online?(Y/N) ");
                        String Online = keyboard.readLine();
                        boolean frdOnline = false;
                        String nowPlaying = "";
                        while (!(Online.equalsIgnoreCase("Y")||Online.equalsIgnoreCase("N"))){
                            System.out.println("please enter a valid answer. ");
                            Online = keyboard.readLine();
                        }
                        if(Online.equalsIgnoreCase("Y")){
                            frdOnline = true;
                            System.out.print("Is the friend playing a game?(Y/N) ");
                            String FrdPlaying = keyboard.readLine();
                            while(!(FrdPlaying.equalsIgnoreCase("Y")||FrdPlaying.equalsIgnoreCase("N"))){
                                System.out.println("please enter a valid answer. ");
                                FrdPlaying = keyboard.readLine();
                            }
                            if(FrdPlaying.equalsIgnoreCase("Y"))
                            {
                                System.out.print("what is the name of that game? ");
                                nowPlaying = keyboard.readLine();
                            }
                        }
                        FriendList newFriend = new FriendList(FrdUsername, FrdNickname, frdOnline, nowPlaying);
                        FrdsArrayList.add(newFriend);
                        System.out.println("=============== Friend List ===============");
                        for(int i = 0; i < FrdsArrayList.size(); i++){
                            System.out.println(FrdsArrayList.get(i));
                        }
                        System.out.println("===========================================");
                    }
                    System.out.println();
                    System.out.println("Do you want to return to Menu Page?(Y/N) ");
                    ReturnToMenu = keyboard.readLine();
                    while(!(ReturnToMenu.equalsIgnoreCase("Y") || ReturnToMenu.equalsIgnoreCase("N"))){
                        System.out.println("please enter a valid answer. ");
                        ReturnToMenu = keyboard.readLine();
                    }
                }
                System.out.println("Returning to Menu page...");
            }

            //Profile
            else if(menu.equals("Profile")){
                user.DisplayProfile();
                String ReturnToMenu = "N";
                while(!ReturnToMenu.equalsIgnoreCase("Y")){
                    System.out.println("Do you want to edit your profile?(Y/N) ");
                    String EditProfile = keyboard.readLine();
                    while(!(EditProfile.equalsIgnoreCase("Y") || EditProfile.equalsIgnoreCase("N"))){
                        System.out.println("please enter a valid answer.");
                    }
                    if(EditProfile.equalsIgnoreCase("Y")){
                        System.out.println("| change username | change password | change store location | change email | deposit |");
                        String option = keyboard.readLine();
                        if(option.equals("change username")){
                            System.out.print("new username: ");
                            String newUsername = keyboard.readLine();
                            user.setUsername(newUsername);
                            user.DisplayProfile();
                        }
                        else if(option.equals("change password")){
                            System.out.print("old password: ");
                            String oldPSW = keyboard.readLine();
                            while (!oldPSW.equals(user.getPsw())){
                                System.out.println("your password is wrong, please enter again: ");
                            }
                            System.out.print("new password: ");
                            String newPSW = keyboard.readLine();
                            user.setPSW(newPSW);
                            user.DisplayProfile();
                        }
                        else if(option.equals("change store location")){
                            System.out.print("new store location: ");
                            String newStoreLocation = keyboard.readLine();
                            user.setLocation(newStoreLocation);
                            user.DisplayProfile();
                        }
                        else if(option.equals("change email")){
                            System.out.print("Enter your password to continue: ");
                            String PSW = keyboard.readLine();
                            while (!PSW.equals(user.getPsw())){
                                System.out.println("your password is wrong, please enter again: ");
                            }
                            System.out.print("new email address: ");
                            String newEmail = keyboard.readLine();
                            user.setEmail(newEmail);
                            user.DisplayProfile();
                        }
                        else if(option.equals("deposit")){
                            System.out.print("How much do you want to deposit? ");
                            int addAmount = Integer.parseInt(keyboard.readLine());
                            user.deposit(addAmount);
                            user.DisplayProfile();
                        }
                        else{
                            System.out.println("Invalid option: " + option);
                        }
                    }
                    System.out.println();
                    System.out.println("Do you want to return to Menu Page?(Y/N) ");
                    ReturnToMenu = keyboard.readLine();
                    while(!(ReturnToMenu.equalsIgnoreCase("Y") || ReturnToMenu.equalsIgnoreCase("N"))){
                        System.out.println("please enter a valid answer. ");
                        ReturnToMenu = keyboard.readLine();
                    }
                    System.out.println("Returning to Menu page...");
                }
            }

            //Exit Steam
            else if(menu.equals("Exit Steam")){
                String exit = "";
                System.out.print("Are you sure you want to exit Steam?(Y/N) ");
                exit = keyboard.readLine();
                while(!(exit.equalsIgnoreCase("Y") || exit.equalsIgnoreCase("N"))){
                    System.out.println("please enter a valid answer. ");
                }
                if(exit.equalsIgnoreCase("Y")){
                    System.out.println("Exiting Steam...");
                    System.exit(0);
                }
                else{
                    System.out.println("Returning to Menu page...");
                }
            }

            //No such Page
            else{
                System.out.println("Page not found.");
                
                System.out.println();
                System.out.println("Press ENTER to eturn to Home page...");
                keyboard.readLine();
            }
        }
    }
}
