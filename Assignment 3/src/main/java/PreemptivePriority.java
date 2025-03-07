import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Preemptive Priority Scheduling Algorithm.
 *
 * <p>This version of the algorithm uses smaller numbers to represent higher priority.
 * E.g. Priority 1 is higher than priority 2, and priority 0 is the highest.
 */
public class PreemptivePriority {

  /**
   * Executes the preemptive priority scheduling algorithm.
   *
   * @param processes an array of processes to be scheduled.
   */
  public static void execute(List<Process> processes) {
    int time = 0;
    int completed = 0;
    Process currentProcess = null;
    int n = processes.size();

    // Initialize the ready queue
    List<Process> readyQueue = new ArrayList<>();

    // Sort by arrival time initially
    processes.sort(Comparator.comparingInt(Process::getArrivalTime));

    while (completed < n) {
      // Add all processes that have arrived at the current time to the ready queue
      for (Process p : processes) {
        if (p.getArrivalTime() == time) {
          readyQueue.add(p);
          readyQueue.sort(Comparator.comparingInt(Process::getPriority)); // Sort by priority
        }
      }

      if (!readyQueue.isEmpty()) {
        // Select the process with the highest priority (lowest priority number)
        Process selectedProcess = readyQueue.get(0);

        if (currentProcess == null || selectedProcess.getPriority() < currentProcess.getPriority()) {
          currentProcess = selectedProcess;
        }

        // Execute the selected process for 1 unit of time
        currentProcess.setRemainingTime(currentProcess.getRemainingTime() - 1);

        if (currentProcess.getRemainingTime() == 0) {
          // Process completed
          currentProcess.calculateCompletionTimes(time + 1);
          completed++;

          readyQueue.remove(currentProcess);
          currentProcess = null;
        }
      }
      time++;
    }

    // Print results
    printResults(processes);
  }

  /**
   * Prints the results of the scheduling algorithm.
   *
   * @param processes the list of processes.
   */
  private static void printResults(List<Process> processes) {
    double totalWaitingTime = 0;
    double totalTurnaroundTime = 0;
    System.out.println("PID\tAT\tBT\tPR\tCT\tTAT\tWT");

    for (Process p : processes) {
      System.out.println(p.getProcessId() + "\t" + p.getArrivalTime() + "\t"
        + p.getBurstTime() + "\t" + p.getPriority() + "\t"
        + p.getCompletionTime() + "\t" + p.getTurnaroundTime() + "\t" + p.getWaitingTime());
      totalWaitingTime += p.getWaitingTime();
      totalTurnaroundTime += p.getTurnaroundTime();
    }
    System.out.println("Average Waiting Time: " + (totalWaitingTime / processes.size()));
    System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / processes.size()));
  }
}