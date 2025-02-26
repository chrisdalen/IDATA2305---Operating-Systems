import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A simple class which spawns multiple clients to connect to the server.
 * Used for testing the time taken to process multiple requests.
 */
public class ClientTester {
  private static final int PORT = 12345;
  private static final String HOST = "localhost";

  /**
   * Main method to run the client tester.
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    int numClients = 10; // Number of clients to create
    Thread[] clients = new Thread[numClients];

    for (int i = 0; i < numClients; i++) {
      final int clientNumber = i + 1;
      clients[i] = new Thread(() -> {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

          // Example request: "50 20 A" (50 + 20)
          String request = (clientNumber * 5) + " " + (clientNumber * 2) + " A";
          out.println(request);
          System.out.println("Client " + clientNumber + " sent: " + request);

          // Read response
          String response = in.readLine();
          System.out.println("Client " + clientNumber + " received: " + response);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
      clients[i].start();
    }

    // Wait for all threads to complete
    for (Thread client : clients) {
      try {
        client.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
