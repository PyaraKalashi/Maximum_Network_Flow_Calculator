/**
 * FlowGraph class represents a flow network graph with capacities and flow adjustments.
 * It allows adding connections between vertices with specified capacities,
 * and tracks current flows along with capacities.
 *
 * Made By :- A.P.K.Perera
 * Student ID :- 20221224
 * UOW ID :- w2052776
 */

package w2052776_20221224_MaxFlow;

public class w2052776_20221224_Flow_Graph { // Defines the class representing a directed flow network
    private final int nodeCount; // Stores the number of nodes in the graph
    private final int[][] capacityTable; // 2D array to hold the capacity between each pair of vertices
    private final int[][] currentFlow; // 2D array to hold the current flow between each pair of vertices

    // Constructor: initializes a graph with the given number of vertices
    public w2052776_20221224_Flow_Graph(int vertexCount) {
        this.nodeCount = vertexCount; // Set total node count
        this.capacityTable = new int[vertexCount][vertexCount]; // Initialize all capacities to 0
        this.currentFlow = new int[vertexCount][vertexCount]; // Initialize all flows to 0

    }

    // Adds a directed edge from 'fromVertex' to 'toVertex' with a specified capacity
    public void addConnection(int fromVertex, int toVertex, int edgeCapacity) {
        this.capacityTable[fromVertex][toVertex] += edgeCapacity;  // Add or update capacity
    }

    // Getter: returns the number of vertices in the graph
    public int getVertexCount() { return nodeCount;}

    // Getter: returns the capacity of the edge from 'fromVertex' to 'toVertex'

    public int getEdgeCapacity(int fromVertex, int toVertex) { return capacityTable[fromVertex][toVertex]; }

    // Getter: returns the current flow through the edge from 'fromVertex' to 'toVertex'
    public int getCurrentFlow(int fromVertex, int toVertex) { return currentFlow[fromVertex][toVertex]; }


    // Modifies the current flow on the edge between two vertices by a given amount (can increase or decrease)
    public void modifyFlow(int fromVertex, int toVertex, int adjustment) {
        currentFlow[fromVertex][toVertex] += adjustment;
    }


    // Prints all edges that have a capacity, along with their current flow values
    public void printFlows() {

        // Iterate over all nodes
        for (int i=0; i<nodeCount; i++) {
            for (int j=0; j<nodeCount; j++) {

                // Only print edges that exist (capacity > 0)
                if (capacityTable[i][j] > 0) {
                    // Prints the flow on edge (i,j) in the format f(i,j) = currentFlow/capacity,
                    // where 'currentFlow' is the actual flow and 'capacity' is the maximum allowed.
                    System.out.printf("f(%d,%d) = %d/%d%n",

                            // Format: f(i,j) = current/capacity
                            i, j, capacityTable[i][j], currentFlow[i][j]);
                }
            }
        }
    }

}
