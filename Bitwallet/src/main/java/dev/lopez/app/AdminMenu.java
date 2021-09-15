package dev.lopez.app;

import dev.lopez.models.Customer;
import dev.lopez.services.UserServices;

import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    static UserServices userServices = new UserServices();

    public static void display(Customer u) {

        //loop the following
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to the Wallet Management menu: " + u.getUsername() );

        while (running) {
            System.out.println("Choose an option:");
            /// need to display a menu
            System.out.println("1) View all Users information");
            System.out.println("2) Exit Wallet Management");



            ///recieve input from the user
            String result = scanner.nextLine();

            switch (result) {
                //show item list

                //show user list
                case "1":
                    List<Customer> c = userServices.getAllCustomers();
                    if (c.isEmpty()) System.out.println("There is no customers available.");
                    for (Customer user : c) {
                        System.out.println(user);
                    }
                    break;
                case "2":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
