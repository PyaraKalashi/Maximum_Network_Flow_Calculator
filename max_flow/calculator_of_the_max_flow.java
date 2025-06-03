/**
 * MaxFlowCalculator class implements the Edmonds-Karp algorithm (BFS-based Ford-Fulkerson)
 * to compute the maximum flow from a source to a sink in a given flow network.
 * It uses augmenting paths to update flows until no more paths exist.
 *
 * Made By :- A.P.K.Perera
 * Student ID :- 20221224
 * UOW ID :- w2052776
 */
package max_flow;

import java.util.ArrayDeque; // Imports ArrayDeque for efficient BFS queue
import java.util.Arrays; // Imports Arrays utility for initializing arrays
import java.util.Queue;  // Imports Queue interface for BFS

public class calculator_of_the_max_flow {  // Class for computing max flow using BFS-based Ford-Fulkerson

    // Reference to the flow graph
    private final flow_graph graph;

    // Array to store parent nodes used in BFS path reconstruction
    private final int[] predecessorNodes;

    // Constructor that takes the flow graph and initializes the predecessor array
    public calculator_of_the_max_flow(flow_graph network) {
        this.graph = network;
        this.predecessorNodes = new int[network.getVertexCount()];
    }


    // Main method to compute the maximum flow from startNode (source) to endNode (sink)
    public int computeMaximumFlow(int startNode, int endNode) {
        int totalFlow = 0;
        int iteration = 1;

        // While there's an augmenting path from source to sink
        while (findAugmentingPath(startNode, endNode)) {
            System.out.println("\nIteration: " + iteration++ + ":");

            // Set initial bottleneck (min capacity) to a large number
            int pathFlow = Integer.MAX_VALUE;

            // Start from sink to trace back path
            int currentNode = endNode;


            // First pass: Trace back from sink to source to find the bottleneck capacity
            while (currentNode != startNode) {

                // Get previous node on the path
                int previousNode = predecessorNodes[currentNode];

                // Calculate available (residual) capacity
                int residual = graph.getEdgeCapacity(previousNode, currentNode)
                        - graph.getCurrentFlow(previousNode, currentNode);

                // Update path flow with minimum residual found
                pathFlow = Math.min(pathFlow, residual);

                // Move backward along the path
                currentNode=previousNode;
            }

            // Build and print the augmenting path in forward order
            System.out.print("Augmenting path: ");

            // Reset to sink
            currentNode = endNode;

            // StringBuilder to construct the path
            StringBuilder pathBuilder = new StringBuilder();
            while (currentNode != startNode) {

                // Insert current node at the start
                pathBuilder.insert(0, "->" + currentNode);

                // Move to predecessor
                currentNode = predecessorNodes[currentNode];
            }
            // Insert source at the beginning
            pathBuilder.insert(0, startNode);

            // Print the full augmenting path
            System.out.println(pathBuilder.toString());

            // Print the bottleneck capacity
            System.out.println("Flow to add: " + pathFlow);

            // Second pass: Update the actual flow in the graph along the path
            currentNode = endNode; // Reset to sink
            while (currentNode != startNode) {

                // Get predecessor node
                int previousNode = predecessorNodes[currentNode];

                // Add flow in the forward direction
                graph.modifyFlow(previousNode, currentNode, pathFlow);

                // Add reverse flow (used for backtracking in residual graph)
                graph.modifyFlow(currentNode, previousNode, -pathFlow);
                currentNode = previousNode; // Move backward
            }

            // Add this path's flow to total max flow
            totalFlow += pathFlow;


            // Display current state of all edge flows after update
            System.out.println("Current flows: ");
            graph.printFlows();
        }

        // When no more augmenting paths are found, return total flow
        return totalFlow;
    }


    // Private method to find if an augmenting path exists from startNode to endNode using BFS
    private boolean findAugmentingPath(int startNode, int endNode) {

        // Reset predecessor array for new BFS run
        Arrays.fill(predecessorNodes, -1);

        // Track visited nodes
        boolean[] visited = new boolean[graph.getVertexCount()];

        // Queue for BFS traversal
        Queue<Integer> explorationQueue = new ArrayDeque<>();

        // Start BFS from source
        explorationQueue.offer(startNode);

        // Mark source as visited
        visited[startNode] = true;

        // Perform BFS to find a path to sink
        while (!explorationQueue.isEmpty()) {

            // Dequeue current node
            int current = explorationQueue.poll();

            // Check all neighbors of the current node
            for (int neighbor = 0; neighbor < graph.getVertexCount(); neighbor++) {
                // Compute residual capacity of the edge
                int remainingCapacity = graph.getEdgeCapacity(current, neighbor)
                        - graph.getCurrentFlow(current, neighbor);

                // If neighbor hasn't been visited and residual capacity exists
                if (!visited[neighbor] && remainingCapacity > 0) {

                    // Enqueue neighbor for further exploration
                    explorationQueue.offer(neighbor);

                    // Set predecessor for path reconstruction
                    predecessorNodes[neighbor] = current;

                    // Mark as visited
                    visited[neighbor] = true;

                    // If we've reached the sink, path is found
                    if (neighbor == endNode) {
                        return true;
                    }
                }
            }
        }
        // No path found from source to sink
        return false;
    }
    // Utility method to print final flows at the end of max-flow computation
    public void printFinalFlows() { graph.printFlows(); }
}
