import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedServer {
  private static final int PORT = 12345;
  private static final int TOTAL_REQUESTS = 10; // To measure time taken for processing requests

  public static void main(String[] args) {
    int requestCount = 0;
    long startTime = 0; // Initialize but will be set when the first request is received

    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      System.out.println("Server started on port " + PORT);

      while (requestCount < TOTAL_REQUESTS) {
        try (Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
          System.out.println("Client connected");

          // Record start time when the first client connects
          if (requestCount == 0) {
            startTime = System.currentTimeMillis();
          }

          // Read request from client
          String input = in.readLine();
          if (input == null) {
            continue;
          }
          System.out.println("Request received: " + input);

          // Process request
          String[] parts = input.split(" ");
          if (parts.length != 3) {
            out.println("Invalid request");
            continue;
          }
          double num1 = Double.parseDouble(parts[0]);
          double num2 = Double.parseDouble(parts[1]);
          char operator = parts[2].charAt(0);

          // Perform operation
          double result = switch (operator) {
            case 'A' -> num1 + num2;
            case 'S' -> num1 - num2;
            case 'M' -> num1 * num2;
            case 'D' -> (num2 != 0) ? num1 / num2 : Double.NaN; // Check for division by zero
            default -> Double.NaN;
          };

          // Send response to client
          out.println("Result: " + result);
          System.out.println("Response sent to client");
          requestCount++;
        } catch (IOException | NumberFormatException e) {
          e.printStackTrace();
        }
      }

      long endTime = System.currentTimeMillis();
      System.out.println("Time taken to process " + TOTAL_REQUESTS + " requests: " + (endTime - startTime) + " ms");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
