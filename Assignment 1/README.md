# Multithreaded vs. Single-threaded Client-Server Arithmetic Calculator

## Description
This project demonstrates the difference in performance between a **single-threaded** and a **multithreaded** server when handling multiple client requests simultaneously. The application consists of:

- A **server** that performs basic arithmetic operations (`+`, `-`, `*`, `/`) based on client input.
- A **client** that sends two numbers and an operator to the server, receives the result, and displays it.

## How It Works
1. The **client** sends a request to the server in the format:  
    `<number1> <number2> <operator>`
- Example: `50 20 A` (for `50 + 20`)

2. The **server** receives the request, performs the requested operation, and returns the result to the client.

3. The experiment is conducted with **10 simultaneous client requests** to measure the performance difference between:
- **Single-threaded server** (processes one client at a time).
- **Multithreaded server** (handles multiple clients concurrently using threads).

4. Execution time is recorded for both implementations to compare performance.

## Files
- `SingleThreadedServer.java` – Handles one client at a time.
- `MultiThreadedServer.java` – Creates a new thread for each client request.
- `Client.java` – Sends requests to the server based on user-input.
- `ClientTester` - Spawns 10 clients to test the server.
- `ClientHandler` - Handles client requests in the multithreaded server.

## Objective
The project highlights the performance advantages of multi-threading in server applications, demonstrating how a **single-threaded server** is slower when handling multiple clients compared to a **multithreaded server**.

### Note
This README file is written by ChatGPT based on the project description. It's not part of the assignment requirements.
