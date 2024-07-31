package com.seafooddelakec.app;
import com.seafooddelakec.RestaurantEmployee;

/*
 * Server class functions to greet and capture customer's order.
 * once customer enters a valid menu selection, server prompts user to either:
 * select another menu item or complete order
 * If user chooses to add another menu item, same server prompt as before (add or complete order)
 * If user completes order, server submits order to "kitchen"
 * Chat screen should clear
 */
public class Server implements RestaurantEmployee {
    // private fields to access:
    // FoodType Enum (menu item + price)
    // user inputted customer name



    @Override
    public void greeting() {
        String serverName = "Beyonce";

        if (Host.getCustomerName() != null && !Host.getCustomerName().isEmpty()) {
            System.out.println("Server: Hi " + Host.getCustomerName() +
                    ", my name is " + serverName + " and I will be your server today.");
        } else {
            System.out.println("Server: Hi, my name is " + serverName + " and I will be your server today.");
        }
    }
}


