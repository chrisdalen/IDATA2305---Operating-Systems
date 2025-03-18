import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Preemptive Priority Scheduling Algorithm.
 *
 * <p>This version of the algorithm uses smaller numbers to represent higher priority.
 * E.g., Priority 1 is higher than priority 2, and priority 0 is the highest.
 */
public class PreemptivePriority {

  /**
   * Executes the preemptive priority scheduling algorithm.
   *
   * @param processes a list of processes to be scheduled.
   */
  public static void execute(List<Process> processes) {
    int time = 0;
    int numberOfCompleted = 0;
    int numberOfProcesses = processes.size();
    Process currentProcess = null;
    List<Process> readyQueue = new ArrayList<>();

    // Sort processes by arrival time initially
    processes.sort(Comparator.comparingInt(Process::getArrivalTime));

    while (numberOfCompleted < numberOfProcesses) {
      updateReadyQueue(processes, readyQueue, time);
      currentProcess = selectProcess(readyQueue, currentProcess);

      if (currentProcess != null) {
        executeProcess(currentProcess);

        if (currentProcess.getRemainingTime() == 0) {
          completeProcess(currentProcess, time);
          numberOfCompleted++;
          readyQueue.remove(currentProcess);
          currentProcess = null;
        }
      }
      time++;
    }

    printResults(processes);
  }

  /**
   * Adds newly arrived processes to the ready queue and sorts by priority.
   *
   * @param processes a list of all processes.
   * @param readyQueue the list of processes in the ready queue.
   * @param time the current time.
   */
  private static void updateReadyQueue(List<Process> processes, List<Process> readyQueue, int time) {
    for (Process p : processes) {
      if (p.getArrivalTime() == time && !readyQueue.contains(p)) {
        readyQueue.add(p);
      }
    }
    readyQueue.sort(Comparator.comparingInt(Process::getPriority));
  }

  /**
   * Selects the highest priority process for execution.
   *
   * @param readyQueue the list of processes in the ready queue.
   * @param currentProcess the process currently being executed.
   *
   * @return the process with the highest priority.
   */
  private static Process selectProcess(List<Process> readyQueue, Process currentProcess) {
    if (readyQueue.isEmpty()) {
      return null;
    }
    Process selectedProcess = readyQueue.get(0);
    return (currentProcess == null || selectedProcess.getPriority() < currentProcess.getPriority())
      ? selectedProcess
      : currentProcess;
  }

  /**
   * Executes the given process for one unit of time.
   *
   * @param process the process to execute.
   */
  private static void executeProcess(Process process) {
    process.setRemainingTime(process.getRemainingTime() - 1);
  }

  /**
   * Marks a process as completed and calculates its completion times.
   *
   * @param process the process to complete.
   * @param time the current time.
   */
  private static void completeProcess(Process process, int time) {
    process.calculateCompletionTimes(time + 1);
  }

  /**
   * Prints the results of the scheduling algorithm.
   * This method has been modified by ChatGPT for better formatting.
   *
   * @param processes the list of processes.
   */
  private static void printResults(List<Process> processes) {
    double totalWaitingTime = 0;
    double totalTurnaroundTime = 0;
    System.out.printf("%-12s%-15s%-12s%-12s%-18s%-18s%-14s\n",
      "Process ID", "Arrival Time", "Burst Time", "Priority",
      "Completion Time", "Turnaround Time", "Waiting Time");

    for (Process p : processes) {
      System.out.printf("%-12d%-15d%-12d%-12d%-18d%-18d%-14d\n",
        p.getProcessId(),
        p.getArrivalTime(),
        p.getBurstTime(),
        p.getPriority(),
        p.getCompletionTime(),
        p.getTurnaroundTime(),
        p.getWaitingTime());
      totalWaitingTime += p.getWaitingTime();
      totalTurnaroundTime += p.getTurnaroundTime();
    }

    System.out.printf("\nAverage Waiting Time: %.2f\n", totalWaitingTime / processes.size());
    System.out.printf("Average Turnaround Time: %.2f\n", totalTurnaroundTime / processes.size());
  }
}
