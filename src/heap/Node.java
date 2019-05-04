package heap;

public class Node {
    private int nodeId;
    private int cost;

    public Node(int id, int cost){
        this.nodeId=id;
        this.cost=cost;
    }
    public int getCost(){
        return this.cost;
    }
    public int getNodeId(){
        return this.nodeId;
    }
    public void setCost(int cost){
        this.cost=cost;
    }
}
