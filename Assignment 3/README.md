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
A menu will appear, allowing you to choose which algorithm to run:  

Select Scheduling Algorithm:

- **Enter `1`** to run **FCFS**.
- **Enter `2`** to run **Preemptive Priority Scheduling**.
- **Enter `3`** to **exit the program**.

After an algorithm completes, you can **choose again without restarting the program**.

Feel free to modify the methods in `CpuScheduler` to test different scenarios,  
e.g. different burst times, priorities, or arrival times, or to add more processes.

## Preemptive Priority Scheduling
Preemptive scheduling works by assigning each process a priority. If a process with a higher
priority arrives, it will preempt the current process and start executing.
If a process with the same priority arrives, it will be added to the queue.

If you run the main method as is, you will see the following output:

![img.png](img.png)

## First-Come, First-Served (FCFS) Scheduling
FCFS works by **executing processes in the order they arrive**.
- Once a process starts, it **runs to completion** without interruption.
- This is a **non-preemptive scheduling algorithm**.

If you run FCFS Scheduling, you will see the following output:  

![image2.png](image2.png)
