package sets;

/** A class that represents the Disjoint Sets data structure. Please refer
 * to the lecture slides.
 * This class is used in Kruskal's.
 * */
public class DisjointSets {
    private int[] parent;

    public DisjointSets(int x){
        parent= new int[x];
        createSets(x);
    }
    public void createSets(int n) {
        // FILL IN CODE
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * Returns the root of the "tree" that x belongs to. Uses path compression
     * heuristic.
     * @param x node id
     * @return root of the tree that x belongs to
     */
    public int find(int x) {
        // FILL IN CODE
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x]; // change
    }

    /**
     * Merges the trees of x and y.
     * @param x node id
     * @param y node id
     */
    public void union(int x, int y) {
        // FILL IN CODE
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot){
            return;
        }
        if (parent[xRoot] < parent[yRoot]){
            parent[xRoot] = yRoot;
        }
        else if (parent[yRoot] < parent[xRoot]){
            parent[yRoot] = xRoot;
        }
        else{
            parent[yRoot] = xRoot;
        }
    }

    public static void main(String[] args) {
        DisjointSets set= new DisjointSets(5);
        set.union(1,3);
        set.union(3,4);
        System.out.println(set.find(1));

    }

}

