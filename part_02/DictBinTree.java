/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
public class DictBinTree implements Dict {

    private Node root;
    private int nodeCount;
    private int traversalCount;

    @Override
    public void insert(int k) {
        nodeCount++;
        Node z = new Node(k);
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.leftChild;
            } else {
                x = x.rightChild;
            }
        }
        if (y == null) {
            root = z;
        } else if (z.key < y.key) {
            y.leftChild = z;
        } else {
            y.rightChild = z;
        }
    }

    /**
     * This method returns array of all the numbers in the tree in increasing order
     * 
     * @return int[] This is the array this the numbers
     */
    @Override
    public int[] orderedTraversal() {
        // Resets the traversal count to zero
        traversalCount = 0;
        // Call the private orderedTraversal with the root nood and a empty array
        // and returns the result
        return orderedTraversal(root, new int[nodeCount]);
    }

    /**
     * This method is for internal use, it returns array of all the numbers in the
     * tree in increasing order
     * 
     * @param x is the node to expaned from
     * @param a is the ordered array
     * 
     * @return int[] This is the array this the numbers
     */
    private int[] orderedTraversal(Node x, int[] a) {
        // Checks that x isn't null
        if (x != null) {
            // Expaneds the left child node
            orderedTraversal(x.leftChild, a);
            // Sets the x's key accordingly to the current traversalCount
            a[traversalCount] = x.key;
            // The traversalCount is increased
            traversalCount++;
            // Expaneds the right child node
            orderedTraversal(x.rightChild, a);
        }
        // Return the ordered array
        return a;
    }

    @Override
    public boolean search(int k) {
        return search(root, k);
    }

    private boolean search(Node x, int k) {
        if (x == null) {
            return false;
        }
        if (k == x.key) {
            return true;
        }

        if (k < x.key) {
            return search(x.leftChild, k);
        } else {
            return search(x.rightChild, k);
        }
    }

    private class Node {
        public Node(int key) {
            this.key = key;
        }

        int key;
        Node leftChild;
        Node rightChild;
    }

}