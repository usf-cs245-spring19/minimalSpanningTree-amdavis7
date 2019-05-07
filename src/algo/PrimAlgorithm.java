package algo;

import graph.*;
import heap.PriorityQueue;

/** Subclass of MSTAlgorithm. Uses Prim's algorithm to compute MST of the graph. */
public class PrimAlgorithm extends MSTAlgorithm {
    private int[][] primTable;
    private int sourceVertex;
    private int max= Integer.MAX_VALUE;
    private int numNodes;

    /**
     * Constructor for PrimAlgorithm. Takes the graph
     * //@param //graph input graph
     * //@param //sourceVertex the first vertex of MST
     */

    public PrimAlgorithm(Graph graph, int sourceVertex) {
        super(graph);

        this.sourceVertex = sourceVertex;
        this.numNodes= super.numNodes();
    }

    /**
     * Compute minimum spanning tree for this graph using Prim's algorithm.
     * Add edges of MST to edgesMST list.
     * */
    @Override
    public void computeMST() {
        // FILL IN CODE
        PriorityQueue newPriorityQueue= new PriorityQueue(numNodes);
        primTable=new int[numNodes][3];
        for (int x=0;x<numNodes;x++){
            primTable[x][0]=max;
            primTable[x][1]=-1;
            primTable[x][2]=-1;
            newPriorityQueue.insert(x,max);
        }
        primTable[sourceVertex][0]=0;
        primTable[sourceVertex][1]=-1;
        primTable[sourceVertex][2]=0;
        newPriorityQueue.reduceKey(sourceVertex,0);
       // newPriorityQueue.print();

        for(int i=0; i<numNodes; i++){
            int v = newPriorityQueue.removeMin();
            primTable[v][2]=0;
            //System.out.println(v+ " "+primTable[v][1]);
            //System.out.println(v+" "+ primTable[v][0]);
            if(v!=sourceVertex){
                //System.out.println(primTable[v][1]);
                Edge newEdge= new Edge(v,primTable[v][1],primTable[v][0]);
                addMSTEdge(newEdge);
            }
            Edge head= super.getFirstEdge(v);
           // System.out.println(v);
            //System.out.println(head.getId1());
            while(head!=null){
                //System.out.println(primTable[head.getId2()][1]);
                if (primTable[head.getId2()][2]==-1){
                    if (primTable[head.getId2()][0]>head.getCost()){
                        primTable[head.getId2()][0]=head.getCost();
                        primTable[head.getId2()][1]=head.getId1();
                        newPriorityQueue.reduceKey(head.getId2(),head.getCost());
                    }
                }
                head=head.next();
            }
        }

        // Note: must use a PriorityQueue and be efficient




    }

}
