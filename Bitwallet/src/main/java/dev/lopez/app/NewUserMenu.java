package dev.lopez.app;

import dev.lopez.exceptions.IncorrectPasswordException;
import dev.lopez.models.Customer;
import dev.lopez.services.UserServices;


import java.util.Scanner;

public class NewUserMenu {
    static UserServices userServices = new UserServices();
    public static void display(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to registration services.");
        System.out.println("Enter new Username:");
        String username = scanner.nextLine();
        System.out.println("Enter new password:");
        String password = scanner.nextLine();
        try {
            Customer c = userServices.userRegister(username,password);
            System.out.println("User "+c.getUsername()+" created.");
        }
        catch(IllegalArgumentException e){
            System.out.println("username is taken.");
            NewUserMenu.display();
        }
        catch (Exception e){
            System.out.println("username/password is too long.");
            NewUserMenu.display();
        }
    }

}














