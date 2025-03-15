// ChatClient.java - Connects to server and sends/receives messages
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to chat server");

            // Thread to listen for incoming messages from server
            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Message: " + message); // Display received message
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiveThread.start();

            // Main loop to send messages
            while (true) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine(); // Read user input
                out.println(message); // Send message to server
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
