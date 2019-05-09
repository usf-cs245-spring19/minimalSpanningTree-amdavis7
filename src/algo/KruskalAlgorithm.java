package algo;

import graph.*;
import sets.DisjointSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/** Subclass of MSTAlgorithm. Computes MST of the graph using Kruskal's algorithm. */
public class KruskalAlgorithm extends MSTAlgorithm {
    private int numNodes;
    //private Edge[] adjacencyList;
    /**
     * Constructor for KruskalAlgorithm. Takes the graph
     * @param graph input graph
     */
    public KruskalAlgorithm(Graph graph) {
        super(graph);
        numNodes=super.numNodes();
        //adjacencyList= new Edge[numNodes];
    }

    /**
     * Compute minimum spanning tree for this graph. Add edges of MST to
     * edgesMST list. Should use Kruska's algorithm and DisjointSet class.
     */
    @Override
    public void computeMST() {
        // FILL IN CODE
        DisjointSets sets= new DisjointSets(numNodes);
        sets.createSets(numNodes);
        ArrayList<Edge> Edges=new ArrayList<Edge>();
        for(int i=0;i<numNodes;i++){
            Edge head= super.getFirstEdge(i);
            while (head!=null){
                Edges.add(head);
                head=head.next();
            }

        }
        Collections.sort(Edges);
        for (int z=0;z<Edges.size();z++){
            int x=Edges.get(z).getId1();
            int y=Edges.get(z).getId2();
            if(sets.find(x)!=sets.find(y)){
                addMSTEdge(Edges.get(z));
                sets.union(x,y);
            }
        }

    }

}
