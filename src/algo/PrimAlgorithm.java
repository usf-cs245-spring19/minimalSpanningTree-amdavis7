package algo;

import graph.*;
import heap.PriorityQueue;

/** Subclass of MSTAlgorithm. Uses Prim's algorithm to compute MST of the graph. */
public class PrimAlgorithm extends MSTAlgorithm {
    private int[][] primTable;
    private int sourceVertex;
    private int max= Integer.MAX_VALUE;

    /**
     * Constructor for PrimAlgorithm. Takes the graph
     * //@param //graph input graph
     * //@param //sourceVertex the first vertex of MST
     */
    public PrimAlgorithm(Graph graph, int sourceVertex) {
        super(graph);
        PriorityQueue newPriorityQueue= new PriorityQueue();
        this.sourceVertex = sourceVertex;
        int numNodes= super.numNodes();
        primTable=new int[numNodes][2];
        for (int x=0;x<numNodes;x++){
            primTable[x][1]=max;
            primTable[x][2]=-1;
        }
        primTable[sourceVertex][1]=0;
        primTable[sourceVertex][2]=-1;
        for(int i=0; i<numNodes; i++){
            int v = newPriorityQueue.remove();
            Edge head= super.getFirstEdge(v);

            while(head!=null){
                if (primTable[head.getId2()][2]==-1){
                    if (primTable[head.getId2()][1]>head.getCost()){
                        primTable[head.getId2()][1]=head.getCost();
                        primTable[head.getId2()][2]=head.getId1();
                    }
                }
            }
        }

    }

    /**
     * Compute minimum spanning tree for this graph using Prim's algorithm.
     * Add edges of MST to edgesMST list.
     * */
    @Override
    public void computeMST() {
        // FILL IN CODE
        // Note: must use a PriorityQueue and be efficient




    }

}
