import java.util.List;

/**
 * First-Come, First-Served (FCFS) Scheduling Algorithm.
 */
public class FirstComeFirstServe {

  /**
   * Executes the FCFS scheduling algorithm.
   *
   * @param processes The list of processes.
   */
  public static void execute(List<Process> processes) {
    // Sort processes by arrival time
    processes.sort((p1, p2) -> Integer.compare(p1.getArrivalTime(), p2.getArrivalTime()));

    int currentTime = 0;
    double totalWaitingTime = 0;
    double totalTurnaroundTime = 0;

    System.out.printf("%-12s%-15s%-12s%-18s%-18s%-14s\n",
        "Process ID", "Arrival Time", "Burst Time",
        "Completion Time", "Turnaround Time", "Waiting Time");

    for (Process p : processes) {
      if (currentTime < p.getArrivalTime()) {
        currentTime = p.getArrivalTime();
      }

      int completionTime = currentTime + p.getBurstTime();
      int turnaroundTime = completionTime - p.getArrivalTime();
      int waitingTime = turnaroundTime - p.getBurstTime();

      // Update process values
      p.calculateCompletionTimes(completionTime);

      totalWaitingTime += waitingTime;
      totalTurnaroundTime += turnaroundTime;

      System.out.printf("%-12d%-15d%-12d%-18d%-18d%-14d\n",
          p.getProcessId(), p.getArrivalTime(), p.getBurstTime(),
          completionTime, turnaroundTime, waitingTime);

      currentTime = completionTime;
    }

    // Print average waiting and turnaround times
    System.out.printf("\nAverage Waiting Time: %.2f\n", totalWaitingTime / processes.size());
    System.out.printf("Average Turnaround Time: %.2f\n", totalTurnaroundTime / processes.size());
  }
}
