package booking;

public class MovieTicketClient extends Thread {
  private final MovieTicketServer movieTicketServer;
  private final String customerName;
  private final int ticketsToBook;

  /**
   * Constructs a new MovieTicketClient.
   *
   * @param movieTicketServer the shared MovieTicketServer instance.
   * @param customerName the name of the customer booking the tickets.
   * @param ticketsToBook the number of tickets to book.
   */
  public MovieTicketClient(MovieTicketServer movieTicketServer, String customerName, int ticketsToBook) {
    this.movieTicketServer = movieTicketServer;
    this.customerName = customerName;
    this.ticketsToBook = ticketsToBook;
  }

  @Override
  public void run() {
    movieTicketServer.bookTicket(customerName, ticketsToBook);
  }
}
