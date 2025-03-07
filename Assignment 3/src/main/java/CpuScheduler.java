import java.util.ArrayList;
import java.util.List;

/**
 * Main class for the CPU scheduler.
 *
 * <p>Includes two methods, one for First-Come-First-Served (FCFS) scheduling and one for
 * Preemptive Priority scheduling.
 *
 * <p>Running the main method will execute both of them.
 */
public class CpuScheduler {

  /**
   * Main method for the CPU scheduler.
   *
   * @param args the input arguments (unused).
   */
  public static void main(String[] args) {
    System.out.println("Preemptive Priority Scheduling: ");
    schedulePreemptivePriority();
  }

  /**
   * Executes the Preemptive Priority Scheduling Algorithm.
   */
  public static void schedulePreemptivePriority() {
    // Create a list of processes
    List<Process> processes = new ArrayList<>();
    processes.add(new Process(1, 0, 5, 2));
    processes.add(new Process(2, 2, 7, 0));
    processes.add(new Process(3, 4, 3, 1));
    processes.add(new Process(4, 6, 6, 3));

    // Execute the algorithm
    PreemptivePriority.execute(processes);
  }

}
