package dev.lopez.app;

import dev.lopez.exceptions.IncorrectPasswordException;
import dev.lopez.exceptions.NoUsernameFound;
import dev.lopez.models.Customer;
import dev.lopez.services.UserServices;

import java.util.Scanner;

public class MainMenu {
    private static String adminString = "lopezbraca"; //setting user "lopezbraca" as the only admin.
    static UserServices userServices = new UserServices();
    public static void display(){

        Scanner scanner = new Scanner (System.in);
        boolean running = true;

        while (running) {
            //Menu view
            System.out.println("Welcome to the CryptoWallet App!\nStore all your valuable crypto in a secure place.");
            System.out.println("Please choose one of the options below.");
            //Options Menu view
            System.out.println("1) Login to your Crypto Wallet.");
            System.out.println("2) Create a new Crypto Wallet.");
            System.out.println("3) Exit.");

            //input from user
            String result = scanner.nextLine();

            switch (result){
                //Login Window
                case "1":
                    System.out.println("Enter your Username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter your password");
                    String password = scanner.nextLine();
                    try{
                        Customer c = userServices.userLogin(username, password);
                        if (c.getUsername().equals(adminString)){
                            AdminMenu.display(c);
                        }
                        else{
                            UserMenu.display(c);
                        }
                    } catch (IncorrectPasswordException e){
                        System.out.println("Incorrect password.");
                    } catch (NoUsernameFound e) {
                        System.out.println("No username found with those credentials.");
                    }
                    break;
                    //Create new CryptoWallet customer window
                    case "2":
                        NewUserMenu.display();
                        break;

                case "3":
                    running = false;
                    break;
                default:


                    }




            }

        }


    }

