package dev.lopez.app;

import dev.lopez.models.Customer;
import dev.lopez.repositories.CustomerRepo;
import dev.lopez.services.UserServices;

import java.util.Scanner;

public class UserMenu {
    static UserServices userServices = new UserServices();
    static Customer myUser=null;
    public static void display(Customer u){

        //loop the following
        myUser = u;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to your Crypto Wallet "+u.getUsername()+"!");

        while(running) {

            /// need to display a menu
            System.out.println("1) Check your wallet balance.");
            System.out.println("2) Deposit Ethereum crypto.");
            System.out.println("3) Withdraw Ethereum crypto.");
            System.out.println("4) Back");


            ///recieve input from the user
            String result = scanner.nextLine();

            switch (result){

                //show current user's balance
                case "1":
                    System.out.println("Your current balance is:");
                    System.out.println(u.getBalance() + "  ETHE");
                    break;
                //2 and 3 load/withdraw fund
                case "2":
                    System.out.println("Enter the amount you wish to deposit to your Wallet: ");
                    try {
                        String amount = scanner.nextLine();
                        u = userServices.loadBalance(u, Integer.parseInt(amount));
                        if (u == null) {
                            System.out.println(" System error , back to previous menu.");
                            running = false;
                            break;
                        }
                        System.out.println("Your new balance is " + u.getBalance() + " ETHE.");
                    }
                    catch (NumberFormatException e){
                        System.out.println("Invalid input.");
                    }
                    break;
                case "3":
                    System.out.println("Enter the amount you wish to withdraw: ");
                    try {
                        String amount1 = scanner.nextLine();
                        //withdraw = load the negative amount
                        myUser = userServices.loadBalance(myUser, -Integer.parseInt(amount1));
                        if (myUser == null) {
                            System.out.println("internal system error 0, back to previous menu.");
                            running = false;
                            break;
                        }
                        System.out.println("Your new balance is " + myUser.getBalance() + ".");
                    }
                    catch (NumberFormatException e){
                        System.out.println("Invalid input.");
                    }
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                //list an item


            }
        }
    }

}
