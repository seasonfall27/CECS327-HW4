import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client{
    /*
    * Prompts user to enter the ip address to be validated and returned as a string.
    * Returns the ip address as a String.
    */
    static String setIPAddress() {
        // initialize scanner to read user input and get the ip address
        Scanner in = new Scanner(System.in);
        // initialize string for the ip address as empty string
        String ip_address = "";
        // initialize boolean var to enter and exit while loop while validating input
        boolean is_valid = false;

        // enter while loop to prompt user to enter ip address and validate it
        while (!is_valid) {
            System.out.println("Enter an IP address: ");
            ip_address = in.nextLine();
            // checks if the input is valid using validator, exits loop if it is
            is_valid = ip_address.matches("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
        }
        return ip;
    }

    /*
    * Prompts user to enter the port number to be validated and returned as an integer.
    * Returns the port number as an Int.
    */
    static int setPortNumber() {
        // Initialize scanner to read user input and get the port number
        Scanner in = new Scanner(System.in);
        // initialize var for port number
        int portNumber = -1;

        while (true) {
            try {
                // port number validation for user input
                while (portNumber > 65535 || portNumber < 1) {
                    // Prompt user to enter the port number
                    System.out.println("Enter the port number: ");
                    // Assigns the variable portNumber with the value of the user input
                    portNumber = in.nextInt();
                }
                break;
            }  
            // handles and throws numberformatexception
            catch (NumberFormatException e) {
                System.out.println("Enter the port number: ")
                continue;
            }
        }
        return portNumber;
    }

    public static void main(String args[]){
        System.out.println("Beginning echo client...");
    }
}