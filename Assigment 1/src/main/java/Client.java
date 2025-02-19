import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * A simple Client class that sends a request to the server and reads the response.
 */
public class Client {
  private static final String SERVER_ADDRESS = "localhost";
  private static final int PORT = 12345;

  /**
   * Main method to run the client.
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         Scanner scanner = new Scanner(System.in)) {

      // Get user input
      System.out.print("Enter first number: ");
      double num1 = scanner.nextDouble();
      System.out.print("Enter second number: ");
      double num2 = scanner.nextDouble();
      System.out.print("Enter operation (A for +, S for -, M for *, D for /): ");
      char operator = scanner.next().charAt(0);

      // Send request to server
      out.println(num1 + " " + num2 + " " + operator);

      // Read response from server
      String response = in.readLine();
      System.out.println("Server response: " + response);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

