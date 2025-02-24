# Movie Ticket Booking

## Description
This is a simple movie ticket booking system.
The system is designed to simulate 4 customers ordering tickets for a movie at once, using threads.
The goal is to demonstrate the use of synchronization and thread management in Java,
and to experiment with the use of the `volatile` keyword.

## How to Run
To run the program, simply run the `Main` class.

## Our Responsibilities
Chris was in charge of `MovieTicketServer`, while Mona was responsible for `MovieTicketClient`.
The `Main` class was taken from the assignment description, and was not modified.

## Our Observations
In the current implementation (the final, delivered version), the MovieTicketServer-class is thread-safe,
with the `syncronized` keyword used. 

Below you can read about our experiments with the keywords and what we observed.

### Synchronized
While the number of tickets left is correctly updated, the order in which the tickets are booked is not predictable,
and because the customers are booking more tickets in total than there are available tickets,
it's guaranteed that there will be 1 customer each time not able to book,
depending wholly on the order in which the threads are executed.

However, we consider this to be correct, as the number of tickets booked will never exceed the number of tickets available,
and the number of tickets left will only wary between 0, 1, and 2, with one customer always being left out.

### Volatile

### Neither synchronized nor volatile
