package graph;

/**
 * A class that represents a graph: stores the array of city nodes, the
 * adjacency list, as well as the hash table that maps city names to node ids.
 * Nodes are cities (of type CityNode); edges connect them and the cost of each edge
 * is the distance between the cities.
 * Fill in code in this class. You may add additional methods and variables.
 * You are required to implement a PriorityQueue from scratch, instead of using Java's built in.
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class Graph {
    private CityNode[] nodes; // nodes of the graph
    private Edge[] adjacencyList; // adjacency list; for each vertex stores a linked list of edges
    private int numEdges; // total number of edges
    // Add other variables as needed


    /**
     * Constructor. Reads graph info from the given file,
     * and creates nodes and edges of the graph.
     *
     * @param filename name of the file that has nodes and edges
     */
    public Graph(String filename) {
       // FILL IN CODE: load the graph from the given file
        double xCor;
        double yCor;
        int i=0;
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        int y=0;
        try {
            File input = new File(filename);
            Scanner sc = new Scanner(input);
            //sc.nextLine();
            while (sc.hasNext()){
                if(sc.nextLine().equals("NODES")){
                    int x=Integer.parseInt(sc.nextLine());
                    nodes= new CityNode[x];
                    Edge adjacencyList[]=new Edge[x];
                    while (sc.hasNext()) {
                        String line = sc.nextLine();
                        String[] words = line.split(" ");
                        xCor= Double.parseDouble(words[1]);
                        yCor= Double.parseDouble(words[2]);
                        nodes[i]= new CityNode(words[0],xCor,yCor);
                        hmap.put(words[0],i);
                        i++;
                    }
                }
                if(sc.nextLine().equals("ARCS")){
                    while(sc.hasNext()){
                        String line= sc.nextLine();
                        String[] words= line.split(" ");
                        String id1=words[0];
                        String id2=words[1];
                        int key= Integer.parseInt(words[2]);
                        int id1Key= hmap.get(id1);
                        int id2Key= hmap.get(id2);
                        adjacencyList[y]= new Edge(id1Key,id2Key,key);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    /**
     * Return the number of nodes in the graph
     * @return number of nodes
     */
    public int numNodes() {

        return nodes.length;
    }

    /** Return the head of the linked list that contains all edges outgoing
     * from nodeId
     * @param nodeId id of the node
     * @return head of the linked list of Edges
     */
    public Edge getFirstEdge(int nodeId){
    return adjacencyList[nodeId];
    }

    /**
     * Return the edges of the graph as a 2D array of points.
     * Called from GUIApp to display the edges of the graph.
     *
     * @return a 2D array of Points.
     * For each edge, we store an array of two Points, v1 and v2.
     * v1 is the source vertex for this edge, v2 is the destination vertex.
     * This info can be obtained from the adjacency list
     */
    public Point[][] getEdges() {
        Point[][] edges2D = new Point[numEdges][2];
        // FILL IN CODE



        return edges2D;
    }

    /**
     * Get the nodes of the graph as a 1D array of Points.
     * Used in GUIApp to display the nodes of the graph.
     * @return a list of Points that correspond to nodes of the graph.
     */
    public Point[] getNodes() {
        if (nodes == null) {
            System.out.println("Graph is empty. Load the graph first.");
            return null;
        }
        Point[] nodes = new Point[this.nodes.length];
        // FILL IN CODE


        return nodes;
    }

    /**
     * Used in GUIApp to display the names of the cities.
     * @return the list that contains the names of cities (that correspond
     * to the nodes of the graph)
     */
    public String[] getCities() {
        if (nodes == null) {
            //System.out.println("Graph is empty, load the graph from the file first");
            return null;
        }
        String[] labels = new String[nodes.length];
        // FILL IN CODE


        return labels;

    }

    /**
     * Return the CityNode for the given nodeId
     * @param nodeId id of the node
     * @return CityNode
     */
    public CityNode getNode(int nodeId) {
        return nodes[nodeId];
    }

}