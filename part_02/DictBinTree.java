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

    /**
     * This method inserts a node in to the binary tree and preserves struckter
     * after the insertion
     * 
     * @param k key for the new node
     */
    @Override
    public void insert(int k) {
        // Increases the nodeCount variable by 1 (used to determine the size of the
        // array in the orderedTraversal method)
        nodeCount++;
        // New node with a new key
        Node z = new Node(k);
        // vallibel used in loops
        Node y = null;
        // Root node of the binary tree
        Node x = root;
        // Checks that x isn't null
        while (x != null) {
            // Sets y = root node
            y = x;
            // If z is smaller than x.
            if (z.key < x.key) {
                // x is the left child
                x = x.leftChild;
                // else x the right child
            } else {
                // x is the right child
                x = x.rightChild;
            }
        }
        // Situation where root is null
        if (y == null) {
            // new node becomes root
            root = z;
            // if the y key is smaler than the root key.
        } else if (z.key < y.key) {
            // y will become y nodes left node
            y.leftChild = z;
            // if not will become the right child in the tree
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

    /**
     * Returns a boolean value, based on whether or not a node with the key k is
     * present in the tree
     * 
     * @param k the key to check for
     * @return boolean based on whether a node with the key is present
     */
    @Override
    public boolean search(int k) {
        // Passes k to private inner function, along with root node of tree
        return search(root, k);
    }

    /**
     * Private recursive function, that returns a boolean based on whether or not a
     * node with the given key exists The search is performed by traversing thorugh
     * the nodes of the tree, staring with the node given as an argument
     * 
     * @param x the node from were the search starts
     * @param k the node-key that the function is searching for
     * @return boolean based on whether a node with the key is present
     */
    private boolean search(Node x, int k) {
        /*
         * If the node that is passed doesn't exist (is null), the search can't be
         * performed, and the node is assumed to be not present in the tree - return
         * false
         */
        if (x == null) {
            return false;
        }
        // Base-case of method, the correct node is found - return true
        if (k == x.key) {
            return true;
        }
        /*
         * If the key of the current node is smaller than the key that is wanted, a
         * recursive call is made passing the current nodes left child node as an
         * argument and with k remaining the same
         */
        if (k < x.key) {
            return search(x.leftChild, k);
            /*
             * If the key of the current node is larger than the key that is wanted, a
             * recursive call is made passing the current nodes right child node as an
             * argument and with k remaining the same
             */
        } else {
            return search(x.rightChild, k);
        }
    }

    /**
     * Private inner Node class
     */
    private class Node {
        /**
         * Constructor, initialising the node with it's key
         * 
         * @param key the nodes key value
         */
        public Node(int key) {
            this.key = key;
        }

        /**
         * Nodes key value
         */
        int key;
        /**
         * The left child of the node
         */
        Node leftChild;
        /**
         * The right child of the node
         */
        Node rightChild;
    }

}