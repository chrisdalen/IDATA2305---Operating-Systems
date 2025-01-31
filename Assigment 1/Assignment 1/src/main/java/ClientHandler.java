import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientHandler implements Runnable {
  private final Socket clientSocket;
  private final AtomicInteger requestCount;

  public ClientHandler(Socket clientSocket, AtomicInteger requestCount) {
    this.clientSocket = clientSocket;
    this.requestCount = requestCount;
  }

  @Override
  public void run() {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

      // Read request from client
      String input = in.readLine();
      if (input == null) {
        return;
      }
      System.out.println("Request received: " + input);

      // Process request
      String[] parts = input.split(" ");
      if (parts.length != 3) {
        out.println("Invalid request");
        return;
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

      // Increment the request count after processing
      if (requestCount.incrementAndGet() == MultiThreadedServer.getTotalRequests()) {
        MultiThreadedServer.printElapsedTime();
      }

    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    } finally {
      try {
        clientSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
