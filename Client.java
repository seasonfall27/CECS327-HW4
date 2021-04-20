import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

/* CECS 327 - Assignment 4
   Socket Programming
   Spring 2021
   Autumn Nguyen and Kenneth Tran

   Requirements: You are required to write an Echo Client and an Echo Server program.
   The echo client communicates with the echo server using UDP.
*/
public class Client{

    static int portNumber;

    /*
    * Prompts user to enter the ip address to be validated and returned as a string.
    * Returns the ip address as a String.
    */
    static String setIPAddress() {
        // initialize scanner to read user input and get the ip address
        Scanner ip = new Scanner(System.in);
        // initialize string for the ip address as empty string
        String ip_address = "";
        // initialize boolean var to enter and exit while loop while validating input
        boolean is_valid = false;

        // enter while loop to prompt user to enter ip address and validate it
        while (!is_valid) {
            System.out.println("Enter a valid IP address: ");
            ip_address = ip.nextLine();

            // checks if the input is valid using validator, exits loop if it is
            is_valid = ip_address.matches("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
            
            // 4. Displays an error message if the IP address or port number were entered incorrectly.
            // If not valid IP address, print error and continue in while loop
            if (!is_valid){
                System.out.println("IP Address was entered incorrectly.");
            }
        }

        return ip_address; // Return string IP Address
    }

    /*
    * Prompts user to enter the port number to be validated and returned as an integer.
    * Returns the port number as an Int.
    */
    static int setPortNumber() {
        // Initialize scanner to read user input and get the port number
        Scanner in = new Scanner(System.in);
        // Initialize var for port number
        int portNumber = -1;

        System.out.println("Enter valid port number:"); // Prompt user to enter the port number

        while (true) {
            try {
                portNumber = in.nextInt();
                // port number validation for user input
                while (portNumber > 65535 || portNumber < 1) {
                    System.out.println("Port number was entered incorrectly.");
                    System.out.println("Enter valid port number: ");
                    // Assigns the variable portNumber with the value of the user input
                    portNumber = in.nextInt();
                }
                break;
            }  
            // 4. Displays an error message if the IP address or port number were entered incorrectly.
            // Handles and throws InputMismatchException
            catch (InputMismatchException e) {
                System.out.println("Port number was entered incorrectly.");
                System.out.println("Enter valid port number: ");
                in.nextLine();
            }
        }
        return portNumber;
    }

    public static void main(String args[]){
        System.out.println("Beginning echo client...");

        while(true) {

            try {
                // 1. Prompts the user to input the IP address and port number of the server.
                InetAddress address = InetAddress.getByName(setIPAddress()); // Converts string to InetAddress
                int portNumber = setPortNumber();

                String msg, response = "";
                Socket socket = new Socket(address, portNumber); // Creates socket with set address on portNumber
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                System.out.println("Connected to server!");
                Scanner in = new Scanner(System.in);

                // Prompts user to 2. Sends the message to the server
                while (true){
                    System.out.println("Enter message to send to server (-1 to quit): ");
                    msg = in.nextLine();
                    if(msg.equals("-1")) {
                        break;
                    }
                    // 3. Display the server replay by using the same socket.
                    pw.println(msg);
                    response = br.readLine();
                    System.out.println("Response: " + response);
                }

                // Close variables so there are no resource leak warnings
                pw.flush();
                socket.close();
                br.close();
                in.close();
                break;
            }
            catch(IOException e) {
                System.out.println("An I/O error has occurred when creating the socket.");
                System.out.println("Restarting the program...");
            }
        }
    }
}