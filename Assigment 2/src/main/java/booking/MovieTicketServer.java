package booking;

public class MovieTicketServer {
  private final String movieName;
  private int availableTickets;


  /**
   * Constructs a new MovieTicketServer.
   *
   * @param movieName the name of the movie.
   * @param availableTickets the number of available tickets.
   */
  public MovieTicketServer(String movieName, int availableTickets) {
    this.movieName = movieName;
    this.availableTickets = availableTickets;
  }

  /**
   * Books a number of tickets for a customer.
   *
   * @param customerName The name of the customer.
   * @param ticketsToBook The number of tickets to book. Must be greater than 0.
   *
   * @return true if the booking was successful, false otherwise.
   */
  public synchronized boolean bookTicket(String customerName, int ticketsToBook) {
    if (ticketsToBook <= 0) {
      return false;
    }

    if (ticketsToBook > availableTickets) {
      System.out.println("Not enough tickets left! " + customerName + " requested "
        + ticketsToBook + " tickets, but there are only " + availableTickets + " tickets left.");
      return false;
    }

    availableTickets -= ticketsToBook;
    System.out.println("Booked " + ticketsToBook + " tickets for " + customerName + " to see "
      + movieName + ". There are " + availableTickets + " tickets left.");
    return true;
  }

}
