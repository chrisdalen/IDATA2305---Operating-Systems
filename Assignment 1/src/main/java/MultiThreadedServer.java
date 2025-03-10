import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple multithreaded server that handles multiple client connections.
 */
public class MultiThreadedServer {
  private static final int PORT = 12345;
  private static final int TOTAL_REQUESTS = 10; // Number of requests to track time
  private static long startTime;
  private static AtomicInteger requestCount = new AtomicInteger(0); // Thread-safe counter

  /**
   * Main method to run the server.
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      System.out.println("Server started on port " + PORT);

      while (getRequestCount() < getTotalRequests()) {
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        // Record start time when the first client connects
        if (getRequestCount() == 0) {
          startTime = System.currentTimeMillis();
        }

        // Pass requestCount and TOTAL_REQUESTS to the ClientHandler
        new Thread(new ClientHandler(clientSocket, requestCount)).start();
      }

      // The server can exit after handling the total requests
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Get the number of requests processed by the server.
   *
   * @return The number of requests processed
   */
  public static int getRequestCount() {
    return requestCount.get();
  }

  /**
   * Get the total number of requests to process.
   *
   * @return The total number of requests
   */
  public static int getTotalRequests() {
    return TOTAL_REQUESTS;
  }

  /**
   * Print the time taken to process all requests.
   */
  public static void printElapsedTime() {
    long elapsedTime = System.currentTimeMillis() - startTime;
    System.out.println("Time taken to process " + TOTAL_REQUESTS + " requests: " + elapsedTime + " ms");
  }
}
