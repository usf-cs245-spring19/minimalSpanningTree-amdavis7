package heap;

/** A priority queue: represented by the min heap.
 *  Used in Prim's algorithm. */
public class PriorityQueue {
	// FILL IN CODE as needed
    private int size=0;
    private int[] positions;
    //private int[] heap;
    private Node[] heap2= new Node[22];

    public void insert(int nodeId, int cost) {
        size++;
        int index = size;
        //heap[index] = nodeId;
        heap2[index]= new Node(nodeId,cost);

        bubbleUp();
    }


    public int removeMin() {
        //heap[1] = heap[size];
        //heap[size] = '\0';
        heap2[1]= heap2[size];
        heap2[size]=null;
        size--;
        bubbleDown();
        return heap2[1].getNodeId();
    }

    public void reduceKey(int nodeId, int newPriority){
        for(int i =0; i< heap2.length;i++){
            if (heap2[i].getNodeId()==nodeId){
                heap2[i].setCost(newPriority);
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



    private void bubbleUp() {
        int current = this.size;
        //System.out.println(current);
        while (hasParent(current) && (heap2[parentIndex(current)].getCost()> (heap2[current]).getCost())) {
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }

    }


}

