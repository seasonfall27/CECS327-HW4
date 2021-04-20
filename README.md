# CECS327-HW4
CECS327 Intro to Networking and Distributed Systems - Assignment 4 - Socket Programming

Requirements: You are required to write an Echo Client and an Echo Server  program. The echo client communicates with the echo server using UDP.

## **“Instructions for Users”**

#### **Running the Server**
1. Open a command prompt terminal and change directory to where the project files are located using the cd command.

2. Compile the Server class using the following command:

     `javac Server.java` 

3. Run the Server.java file using the following command:

     `java Server`

4. Enter a valid port number (must be an integer between 1-65535).

5. After the server is running, open another command prompt terminal to run the client.


#### **Running the Client**
1. In the different command prompt terminal, change directory to where the project files are located using the cd command.

2. Compile the Client class using the following command:

     `javac Client.java`

3. Run the Client.java file using the following command:

     `java Client`

4. Enter a valid IP address (must be in the IPv4 address format)

     - Regex used: `(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)`

     - To locate your IPv4 address, use the following command: `ipconfig/all`

5. Enter the same valid port number (must be an integer between 1-65535) as you entered in the Server. If different, will throw an I/O Exception and restart the program.

#### **Echoing Messages**
1. From the client terminal, the user is able to enter messages that will be sent to the Server and changed to all uppercase letters.

2. Then, the message is echoed back in the same terminal.

3. The user can quit the program using by entering -1
