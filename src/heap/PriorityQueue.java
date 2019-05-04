package heap;

/** A priority queue: represented by the min heap.
 *  Used in Prim's algorithm. */
public class PriorityQueue {
	// FILL IN CODE as needed
    private int size=0;
    private int[] positions;
    //private int[] heap;
    private Node[] heap2;
    public PriorityQueue(int size){
        heap2= new Node[size+1];
        heap2[0]=new Node(-1,Integer.MIN_VALUE);
    }
    public void insert(int nodeId, int cost) {
        size++;
        int index = size;
        //heap[index] = nodeId;
        heap2[index]= new Node(nodeId,cost);

        bubbleUp(index);
    }


    public int removeMin() {
        //heap[1] = heap[size];
        //heap[size] = '\0';
        Node x= heap2[1];
        heap2[1]= heap2[size];

        heap2[size]=null;

        size--;
        bubbleDown();
        return x.getNodeId();
    }

    public void reduceKey(int nodeId, int newPriority){

        // Want to do: int i = positions[nodeid];
        for(int i =0; i<=size;i++){
            if (heap2[i].getNodeId()==nodeId){
                heap2[i].setCost(newPriority);
                bubbleUp(i);
                break;
            }
        }

    }

    private boolean hasParent(int i) {
        if (i> 1){
            return true;
        }
        else{
            return false;
        }
    }
    private int leftChild(int i) {
        return i * 2;
    }
    private int rightChild(int i) {
        return i * 2 + 1;
    }
    private boolean hasLeftChild(int i) {
        return leftChild(i) <= size;
    }
    private boolean hasRightChild(int i) {
        return rightChild(i) <= size;
    }
    private int parent(int i) {
        return heap2[parentIndex(i)].getNodeId();
    }
    private int parentIndex(int i) {
        return i / 2;
    }

    private void swap(int index1, int index2) {
        Node temp = heap2[index1];
        heap2[index1] = heap2[index2];
        heap2[index2] = temp;
    }

    private void bubbleDown() {
        int index = 1;

        while (hasLeftChild(index)) {
            int smallerChild = leftChild(index);

            if (hasRightChild(index) && heap2[leftChild(index)].getCost()>(heap2[rightChild(index)]).getCost()) {
                smallerChild = rightChild(index);
            }

            if (heap2[index].getCost() > (heap2[smallerChild]).getCost()) {
                swap(index, smallerChild);
            } else {
                break;
            }

            index = smallerChild;
        }
    }



    private void bubbleUp(int costNode) {
        int current = costNode;
        //System.out.println(current);
        while (hasParent(current) && (heap2[parentIndex(current)].getCost()> (heap2[current]).getCost())) {
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }

    }

    public void print(){
        for(int i=0;i<=size;i++){
            //System.out.println(i);
            System.out.println(heap2[i].getNodeId()+" "+heap2[i].getCost());
        }
    }
    public static void main(String[] args) {
        PriorityQueue newPriorityQueue= new PriorityQueue(5);
        newPriorityQueue.insert(3,5);
        newPriorityQueue.insert(4,6);
        newPriorityQueue.insert(0,2);
        newPriorityQueue.insert(2,4);
        newPriorityQueue.insert(1,3);
        newPriorityQueue.removeMin();
        newPriorityQueue.reduceKey(4,1);
        newPriorityQueue.print();
    }


}

