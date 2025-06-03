package max_flow;

// Defines the class representing a directed flow network
public class flow_graph {
    private final int nodeCount; // Stores the number of nodes in the graph
    private final int[][] capacityTable; // 2D array to hold the capacity between each pair of vertices
    private final int[][] currentFlow; // 2D array to hold the current flow between each pair of vertices

    // Constructor: initializes a graph with the given number of vertices
    public flow_graph(int vertexCount) {
        this.nodeCount = vertexCount; // Set total node count
        this.capacityTable = new int[vertexCount][vertexCount]; // Initialize all capacities to 0
        this.currentFlow = new int[vertexCount][vertexCount]; // Initialize all flows to 0

    }

    // Adds a directed edge from 'fromVertex' to 'toVertex' with a specified capacity
    public void addConnection(int fromVertex, int toVertex, int edgeCapacity) {
        this.capacityTable[fromVertex][toVertex] += edgeCapacity;  // Add or update capacity
    }

    // returns the number of vertices in the graph
    public int getVertexCount() { return nodeCount;}

    // returns the capacity of the edge from 'fromVertex' to 'toVertex'

    public int getEdgeCapacity(int fromVertex, int toVertex) { return capacityTable[fromVertex][toVertex]; }

    //returns the current flow through the edge from 'fromVertex' to 'toVertex'
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
