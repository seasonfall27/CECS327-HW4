import java.net.*;
import java.io.*;

/* CECS 327 - Assignment 4
   Socket Programming
   Spring 2021
   Autumn Nguyen and Kenneth Tran

   Requirements: You are required to write an Echo Client and an Echo Server program.
   The echo client communicates with the echo server using UDP.
*/
public class Server{

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
        System.out.println("Beginning echo server...");

        Scanner scan = new Scanner(System.in);
        int portNumber = setPortNumber();

        // Instantiate Server socket instance
        // Used by server to listen to client request
        try(ServerSocket echoServer = new ServerSocket(portNumber)){
            Socket clientSocket = echoServer.accept();
            System.out.println("Connected to client!");
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true); 

            // 1. Receives the message from the client.
            // Loops until the message is null
            String message;
            while((message = bufferedReader.readLine()) != null){
                // 2. Change the letters of the message to capital letters and send it back to the client by using the same socket.
                System.out.println("Server: " + message.toUpperCase());
                // Print back to client
                output.println(message.toUpperCase());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}