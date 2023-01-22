The following README file is a small description of the features the CLI chat application is capable and how to interact with it.

-----------------MAIN FEATURES SERVER SIDE-----------------
The program does the following:
-It creates a server waiting for clients chat connections on port 9090.
-It initiates a ClientHandler object which makes the Multi Client Chat application possible.

-----------------MAIN FEATURES CLIENT SIDE-----------------
The program does the following:
-It creates a socket connection to the server at "localhost" and port 9090.
-It promts the user to enter his User Name.
-It creates a new Thread which is listening for incoming messages from the other users. 
-It implements the main Thread and another Thread, the main Thread is for writing the messages to the server and the other one is used for listening for the messages from other users.



-----------------HOW TO-----------------


The Multi-Client-Chat-Application :
*************George-Alexandru Craciun

1. In order for the chat application to work, the server-side main method needs to be run prior to any client-side connection is made.
******************CONSOLE OUTPUT*********************
--------------SERVER waiting for connection--------------

2. After the server-side program is running, the client-side connection can be made.
******************CONSOLE OUTPUT*********************
A new client has connected!!

3. Each new client which is connecting to the server needs to enter his/her user name.
******************CONSOLE OUTPUT*********************
Enter your username for the group chat:

4. When a new client has made a connection to the server, a broadcast message to the other clients is made.
******************CONSOLE OUTPUT*********************
SERVER: Diana has entered the chat!

5. When an user has left the chat, the server sends a broadcast message to the remaining user.
******************CONSOLE OUTPUT*********************
SERVER: Alex has left the chat!
