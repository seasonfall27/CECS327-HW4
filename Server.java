import java.net.*;
import java.io.*;

public class Server{

    public static void main(String args[]){
        System.out.println("Beginning echo server...");

        // Instantiate Server socket instance
        // Used by server to listen to client request
        try(ServerSocket echoServer = new ServerSocket(8000)){
            Socket clientSocket = echoServer.accept();
            System.out.println("Connected to client!");
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true); 

            // Receives the messagefrom the client.
            // Loops until the message is null
            String message;
            while((message = bufferedReader.readLine()) != null){
                // Change the letters of the message to capital letters and send it back to the client by using the same socket.
                System.out.println("Server: " + message.toUpperCase());
                // Print back to client
                output.println(message);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}