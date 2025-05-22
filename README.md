# Max Flow Computation using Edmonds-Karp Algorithm

This Java application calculates the **maximum flow in a directed network** using the **Edmonds-Karp algorithm**, a BFS-based implementation of the Ford-Fulkerson method. It reads a graph from a formatted text file, computes the maximum possible flow from a source node to a sink node, and displays detailed flow information.

---

## 📁 Project Structure

w2052776_20221224_MaxFlow/

w2052776_20221224_Flow_Application.java # Main class to run the application
w2052776_20221224_Flow_Graph.java # Represents the flow graph (network)
w2052776_20221224_GraphData_Reader.java # Reads graph structure from a file
w2052776_20221224_CalculatorOfThe_Max_flow.java # Implements the Edmonds-Karp algorithm
network.txt # Input file containing graph data


---

## 🧠 Features

- Reads a graph from a text file with specified nodes and capacities.
- Implements Edmonds-Karp (BFS) algorithm to compute max flow.
- Shows:
  - Augmenting paths per iteration.
  - Bottleneck capacities.
  - Final edge flows after computation.

---

## 📥 Input File Format (`network.txt`)

Example Input File
5
0 1 10
0 2 8
1 2 5
1 3 5
2 4 10
3 4 7


- First line: Number of vertices.
- Each following line: `<source> <destination> <capacity>`
- Lines starting with `#` are treated as comments.

---

## ▶️ How to Run

1. Ensure your working directory contains `network.txt` under `src/w2052776_20221224_MaxFlow/`.
2. Compile the Java classes:

```bash
javac w2052776_20221224_MaxFlow/*.java

java w2052776_20221224_MaxFlow.w2052776_20221224_Flow_Application

