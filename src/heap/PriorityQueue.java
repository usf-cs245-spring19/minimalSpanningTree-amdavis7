package heap;

/** A priority queue: represented by the min heap.
 *  Used in Prim's algorithm. */
public class PriorityQueue {
	// FILL IN CODE as needed
    private int size;
    private int[] positions;
    private int[] heap;

    public void insert(int value) {
        size++;
        int index = size;
        heap[index] = value;

        bubbleUp();
    }


    public int remove() {
        heap[1] = heap[size];
        heap[size] = '\0';
        size--;
        bubbleDown();
        return heap[1];
    }

    public void reduceKey(int nodeId, int newPriority){
        return;
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
        return heap[parentIndex(i)];
    }
    private int parentIndex(int i) {
        return i / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void bubbleDown() {
        int index = 1;

        while (hasLeftChild(index)) {
            int smallerChild = leftChild(index);

            if (hasRightChild(index) && heap[leftChild(index)]>(heap[rightChild(index)])) {
                smallerChild = rightChild(index);
            }

            if (heap[index] > (heap[smallerChild])) {
                swap(index, smallerChild);
            } else {
                break;
            }

            index = smallerChild;
        }
    }


    private void bubbleUp() {
        int current = this.size;

        while (hasParent(current) && (parent(current)> (heap[current]))) {
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }

    }


}

