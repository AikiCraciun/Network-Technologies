# Multi-Client-Chat-Application

## Intructions how to run the program
1. The __src__ directory should be downloaded locally. 
1. From the __src/ie/gmit/dip__ directory, run the following command line instructions (starting the server side chat)
```
javac *.java
java Server
```
3. Once __java Server__ command is run form the CLI, the Client Chat Users can connect to the chat server. Multiple users can connect on the same time. For any user to connect to server, the following instructions needs to be run form the terminal. 
```
javac *.java
java Client
```

## _MAIN FEATURES SERVER SIDE_
The program does the following:
* It creates a server waiting for clients chat connections on port 9090.
* It initiates a ClientHandler object which makes the Multi Client Chat application possible.

## _MAIN FEATURES SERVER SIDE_
The program does the following:
* It creates a socket connection to the server at "localhost" and port 9090.
* It promts the user to enter his User Name.
* It creates a new Thread which is listening for incoming messages from the other users. 
* It implements the main Thread and another Thread, the main Thread is for writing the messages to the server and the other one is used for listening for the messages from other users.

## _Intructions how to use the CLI program_


1. In order for the chat application to work, the server-side main method needs to be run prior to any client-side connection is made.
    * __*CONSOLE OUTPUT:*__
        ```
        --------------SERVER waiting for connection--------------
        ```
1. After the server-side program is running, the client-side connection can be made.
    * __*CONSOLE OUTPUT:*__
         ```
        A new client has connected!!
         ```
1. Each new client which is connecting to the server needs to enter his/her user name.
    * __*CONSOLE OUTPUT:*__
        ```
        Enter your username for the group chat:
        ```
1. When a new client has made a connection to the server, a broadcast message to the other clients is made.
    * __*CONSOLE OUTPUT:*__
        ```
        SERVER: Diana has entered the chat!
        ```
1. When an user has left the chat, the server sends a broadcast message to the remaining user/users.
    * __*CONSOLE OUTPUT:*__
         ```
        SERVER: Alex has left the chat!
         ```

## License
GNU General Public License v3.0 

**Free Software, Happy days!**