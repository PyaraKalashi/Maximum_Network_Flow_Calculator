/**
 * This is the main application class to compute the maximum flow in a network.
 * It reads a graph from a file, calculates the max flow from source to sink,
 * and prints the result along with the final flows through each edge.
 *
 * Made By :- A.P.K.Perera
 * Student ID :- 20221224
 * UOW ID :- w2052776
 */

package w2052776_20221224_MaxFlow;// Task 1: Defines the package for the flow project

import java.io.IOException; // Imports IOException class for handling file read errors

// Main class for running the maximum flow computation
public class w2052776_20221224_Flow_Application {

    // Sets vertex 0 as the source node, as per coursework instructions
    private static final int SOURCE_VERTEX = 0;

    public static void main(String[] args) {
        try {

            // Task 3: Load and parse graph data from the formatted input file
            // Builds a flow network from a text file that contains node count and edge list with capacities
            w2052776_20221224_Flow_Graph network = w2052776_20221224_GraphData_Reader.buildGraphFromFile(
                    "src/w2052776_20221224_MaxFlow/network.txt");

            // Identifies the terminal/sink node as the last node (n-1), as required by the coursework
            int terminalVertex = network.getVertexCount() - 1;

            // Task 4: Create the max-flow calculator using the chosen algorithm
            w2052776_20221224_CalculatorOfThe_Max_flow flowEngine = new w2052776_20221224_CalculatorOfThe_Max_flow (network);

            // Compute the maximum flow from the source (0) to the sink (n-1)
            int maxFlowValue = flowEngine.computeMaximumFlow(SOURCE_VERTEX, terminalVertex);

            // Task 4: Display the total maximum flow result to the user
            System.out.println("Maximum achievable flow from vertex " + SOURCE_VERTEX
                    + " to vertex " + terminalVertex + " : " + maxFlowValue);

            // Display final edge flows after computing the max flow
            System.out.println("\nFinal edge flows :");
            flowEngine.printFinalFlows();// Task 4: Outputs the actual flow assigned to each edge after execution
        }
        // If there was an error reading the input file, display a message
        catch (IOException fileError) {
            System.err.println("File operation failed: " + fileError.getMessage());
        }
        // If there was an issue with file format (e.g., missing values, invalid integers)
        catch (IllegalArgumentException dataError) {
            System.err.println("Invalid data format: " + dataError.getMessage());
        }
    }
}
