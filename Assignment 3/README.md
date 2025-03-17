# CPU Scheduling
## Introduction
This is a small project to simulate two CPU scheduling algorithms:
1. Preemptive Priority Scheduling
2. First Come First Serve (FCFS)

## Our Contributions
Chris was in charge of the preemptive priority scheduling algorithm,
while Mona was in charge of the FCFS algorithm.
Chris also created the `Process` class and the `CpuScheduler` class,
but we each created our own methods within that class for our respective algorithms.

## How to Run
To run the program, simply run the `main` method in the `CpuScheduler` class.
It will run both algorithms, and print out the results of each.

Feel free to modify the two methods in `CpuScheduler` to test different scenarios,
e.g. different burst times, priorities, or arrival times, or to add more processes.

## Preemptive Priority Scheduling
Preemptive scheduling works by assigning each process a priority. If a process with a higher
priority arrives, it will preempt the current process and start executing.
If a process with the same priority arrives, it will be added to the queue.

If you run the main method as is, you will see the following output:

![img.png](img.png)


