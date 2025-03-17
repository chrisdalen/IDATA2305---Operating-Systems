import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the CPU scheduler.
 *
 * <p>Includes two methods, one for First-Come-First-Served (FCFS) scheduling and one for
 * Preemptive Priority scheduling.
 *
 * <p>Allows the user to select and run multiple times until they choose to exit.
 */
public class CpuScheduler {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\nSelect Scheduling Algorithm:");
      System.out.println("1. First-Come, First-Served (FCFS)");
      System.out.println("2. Preemptive Priority Scheduling");
      System.out.println("3. Exit");
      System.out.print("Enter choice (1, 2, or 3): ");
      int choice = scanner.nextInt();

      if (choice == 1) {
        System.out.println("\nFirst-Come, First-Served (FCFS) Scheduling:");
        scheduleFCFS();
      } else if (choice == 2) {
        System.out.println("\nPreemptive Priority Scheduling:");
        schedulePreemptivePriority();
      } else if (choice == 3) {
        System.out.println("Exiting program...");
        break; // Exit the loop and end the program
      } else {
        System.out.println("Invalid choice! Please enter 1, 2, or 3.");
      }
    }

    scanner.close();
  }

  /**
   * Executes the First-Come-First-Served (FCFS) Scheduling Algorithm.
   */
  public static void scheduleFCFS() {
    List<Process> processes = new ArrayList<>();
    processes.add(new Process(1, 0, 5, 0)); // Priority is ignored in FCFS
    processes.add(new Process(2, 1, 3, 0));
    processes.add(new Process(3, 2, 8, 0));
    processes.add(new Process(4, 3, 6, 0));

    FirstComeFirstServe.execute(processes);
  }

  /**
   * Executes the Preemptive Priority Scheduling Algorithm.
   */
  public static void schedulePreemptivePriority() {
    List<Process> processes = new ArrayList<>();
    processes.add(new Process(1, 0, 5, 2));
    processes.add(new Process(2, 2, 7, 0));
    processes.add(new Process(3, 4, 3, 1));
    processes.add(new Process(4, 6, 6, 3));

    PreemptivePriority.execute(processes);
  }
}
