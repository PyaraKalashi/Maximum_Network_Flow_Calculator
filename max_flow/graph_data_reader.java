package max_flow;

import java.io.BufferedReader; // Imports BufferedReader to efficiently read text from files
import java.io.FileReader; // Imports FileReader to read characters from a file
import java.io.IOException; // Imports IOException to handle file reading exceptions
import java.util.ArrayList; // Imports ArrayList to store valid lines temporarily
import java.util.List; // Imports List interface for holding the lines

// Class to read graph data from a file
public class graph_data_reader {
    private static final String COMMENT_MARKER = "#";// Defines the marker for comment lines

    // Static method that builds and returns a FlowGraph object from a given file
    public static flow_graph buildGraphFromFile(String filePath) throws IOException {

        // Open the file for reading
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));

        // List to store non-empty, non-comment lines
        List<String> meaningfulLines = new ArrayList<>();

        // Variable to hold each line temporarily
        String lineContent;

        // Read the file line by line
        while ((lineContent = fileReader.readLine()) != null) {

            // Remove leading and trailing whitespaces
            lineContent = lineContent.trim();
            if (!lineContent.isEmpty() && !lineContent.startsWith(COMMENT_MARKER)) {

                // Add the line if it is not empty and not a comment
                meaningfulLines.add(lineContent);

            }
        }
        // Close the file once reading is complete
        fileReader.close();

        // If the file had no meaningful content, throw an exception
        if (meaningfulLines.isEmpty()) {
            throw  new IllegalArgumentException("Input file contains no valid data");
        }

        // Parse the number of vertices from the first meaningful line
        int vertexCount = Integer.parseInt(meaningfulLines.get(0).trim());

        // Create a new FlowGraph object with the parsed number of vertices
        flow_graph network = new flow_graph(vertexCount);

        // Parse and add each edge from the remaining lines
        for (int i = 1; i < meaningfulLines.size(); i++) {
            // Split the line by whitespace
            String[] edgeInfo = meaningfulLines.get(i).split("\\s+");
            // If the line does not have exactly three parts, throw an exception
            if (edgeInfo.length != 3) {
                throw new IllegalArgumentException("Invalid edge specification at line " + (i +1));
            }

            // Parse source node, destination node, and capacity from the split parts
            int source = Integer.parseInt(edgeInfo[0]);
            int destination = Integer.parseInt(edgeInfo[1]);
            int capacity = Integer.parseInt(edgeInfo[2]);


            // Add this connection to the graph
            network.addConnection(source, destination, capacity);
        }
        // Return the constructed graph
        return network;
    }
}
