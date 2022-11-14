package Steam;

import java.io.*;
import Steam.*;

public class main {
    public static void main(String[] args) throws Exception {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(" Steam sign in");
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
        char gender = (char)keyboard.read();
        System.out.print("Enter your birthday: ");
        String birthday = keyboard.readLine();
        System.out.print("Do you want to deposit to your Steam wallet?(Y/N) ");
        double amount = 0.0;
        if(keyboard.read() == 'Y'){
            amount += Integer.parseInt(keyboard.readLine());
        }
        UserProfile user = new UserProfile(name, realName, password, storeLocation, gender, birthday, emailAddress, amount);

        
    }      
}
