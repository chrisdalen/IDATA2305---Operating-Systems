/**
 * Represents a process run by the CPU Scheduler.
 */
public class Process {
  private int processId;
  private int arrivalTime;
  private int burstTime;
  private int priority;

  /**
   * Creates a new process.
   *
   * @param processId   The ID of the process.
   * @param arrivalTime The time the process arrived in the ready queue.
   * @param burstTime   The time the process requires to complete.
   * @param priority    The priority of the process.
   */
  public Process(int processId, int arrivalTime, int burstTime, int priority) {
    this.processId = processId;
    this.arrivalTime = arrivalTime;
    this.burstTime = burstTime;
    this.priority = priority;
  }

  /**
   * Gets the process ID.
   *
   * @return The process ID.
   */
  public int getProcessId() {
    return processId;
  }

  /**
   * Gets the arrival time of the process.
   *
   * @return The arrival time of the process.
   */
  public int getArrivalTime() {
    return arrivalTime;
  }

  /**
   * Gets the burst time of the process.
   *
   * @return The burst time of the process.
   */
  public int getBurstTime() {
    return burstTime;
  }

  /**
   * Gets the priority of the process.
   *
   * @return The priority of the process.
   */
  public int getPriority() {
    return priority;
  }

  /**
   * Sets the process ID.
   *
   * @param processId The process ID.
   */
  public void setProcessId(int processId) {
    this.processId = processId;
  }

  /**
   * Sets the arrival time of the process.
   *
   * @param arrivalTime The arrival time of the process.
   */
  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  /**
   * Sets the burst time of the process.
   *
   * @param burstTime The burst time of the process.
   */
  public void setBurstTime(int burstTime) {
    this.burstTime = burstTime;
  }

  /**
   * Sets the priority of the process.
   *
   * @param priority The priority of the process.
   */
  public void setPriority(int priority) {
    this.priority = priority;
  }
}
