# Chat Application (Socket Programming in Java)

## Description
This project is a simple online chat application using Java. It allows multiple users to connect to a central server, send messages, and receive messages from other users in real time. It demonstrates the implementation of socket programming, client-server communication, and basic user interface handling.

## Features
- Multi-client support using threads.
- Real-time message broadcasting.
- Simple text-based user interface.
- Error handling for connection issues.

## Requirements
- Java Development Kit (JDK) installed (Java 8 or later).
- A terminal or command prompt to run the application.

## How to Run

### 1. Compile the Java Files
Ensure you have both `ChatServer.java` and `ChatClient.java` in the same directory. Then, compile them using:
```sh
javac ChatServer.java ChatClient.java
```

### 2. Start the Server
Run the server first to listen for client connections:
```sh
java ChatServer
```
You should see `Chat Server started...` in the terminal.

### 3. Start the Clients
Open a new terminal window for each client and run:
```sh
java ChatClient
```
Each client should see `Connected to chat server`.

### 4. Sending and Receiving Messages
- Clients can type messages and press Enter to send.
- Messages will be broadcasted to all connected clients.

## Implementation Details
### **ChatServer.java**
- Uses `ServerSocket` to listen for client connections.
- Spawns a new thread for each client.
- Maintains a list of connected clients using a `Set<PrintWriter>`.
- Uses synchronized broadcasting to send messages to all clients.

### **ChatClient.java**
- Connects to the server using `Socket`.
- Uses `PrintWriter` to send messages.
- Reads incoming messages using `BufferedReader` in a separate thread.
- Uses a `Scanner` for user input.

## Example Output
### Server Output
```
Chat Server started...
Received: Hello from Client 1
Received: Hi from Client 2
```

### Client Output
```
Connected to chat server
Enter message: Hello
Message: Hi from Client 2
```

## Notes
- Ensure the server is running before starting clients.
- The application currently runs on `localhost` (127.0.0.1) by default.
- Modify `SERVER_ADDRESS` in `ChatClient.java` to connect to a remote server.

## Future Improvements
- Implement a GUI using Java Swing or JavaFX.
- Add authentication for users.
- Implement message history storage.
- Enhance security using encryption.

## Author
Foster Boadi

---
Enjoy chatting! 😊

