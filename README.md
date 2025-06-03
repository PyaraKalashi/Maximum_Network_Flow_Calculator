# Max Flow Computation using Edmonds-Karp Algorithm

This Java application calculates the **maximum flow in a directed network** using the **Edmonds-Karp algorithm**, a BFS-based implementation of the Ford-Fulkerson method. It reads a graph from a formatted text file, computes the maximum possible flow from a source node to a sink node, and displays detailed flow information.

---

## 📁 Project Structure

max_flow/

flow_application.java # Main class to run the application
flow_graph.java # Represents the flow graph (network)
graph_data_reader.java # Reads graph structure from a file
calculator_of_the_max_flow.java # Implements the Edmonds-Karp algorithm
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

