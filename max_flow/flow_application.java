package max_flow;

import java.io.IOException;

// Main class for running the maximum flow computation
public class flow_application {

    // Sets vertex 0 as the source node, as per coursework instructions
    private static final int SOURCE_VERTEX = 0;

    public static void main(String[] args) {
        try {

            // Builds a flow network from a text file that contains node count and edge list with capacities
            flow_graph network = graph_data_reader.buildGraphFromFile(
                    "C:\\Users\\kalas\\Desktop\\maximum_network_flow_calculator\\Maximum_Network_Flow_Calculator\\max_flow\\network.txt");

            // Identifies the terminal/sink node as the last node (n-1), as required by the coursework
            int terminalVertex = network.getVertexCount() - 1;

            // Creating the max-flow calculator using the chosen algorithm
            calculator_of_the_max_flow flowEngine = new calculator_of_the_max_flow(network);

            // Compute the maximum flow from the source (0) to the sink (n-1)
            int maxFlowValue = flowEngine.computeMaximumFlow(SOURCE_VERTEX, terminalVertex);

            // Display the total maximum flow result to the user
            System.out.println("Maximum achievable flow from vertex " + SOURCE_VERTEX
                    + " to vertex " + terminalVertex + " : " + maxFlowValue);

            // Display final edge flows after computing the max flow
            System.out.println("\nFinal edge flows :");
            flowEngine.printFinalFlows();// Outputs the actual flow assigned to each edge after execution
        }
        // If there was an error reading the input file, display a message
        catch (IOException fileError) {
            System.err.println("File operation failed: " + fileError.getMessage());
        }
        // If there was an issue with file format
        catch (IllegalArgumentException dataError) {
            System.err.println("Invalid data format: " + dataError.getMessage());
        }
    }
}
