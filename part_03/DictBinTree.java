/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
public class DictBinTree implements Dict {

    private Node root;
    private StringBuilder keyWordBuilder;
    
    /**
     * This method inserts a node in to the binary tree and preserves struckter
     * after the insertion
     * 
     * @param k key for the new node
     */
    @Override
    public void insert(int k, int index) {
        // New node with a new key
        Node z = new Node(k, index);
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
            // if the y key is smaller than the root key.
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
    public String[] orderedTraversal() {
        // Call the private orderedTraversal with the root nood and a empty array
        // and returns the result
        return orderedTraversal(root, new String[256]);
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
    private String[] orderedTraversal(Node x, String[] a) {
        // Checks that x isn't null
        if (x != null) {
            keyWordBuilder.append(0);
            // Expaneds the left child node
            orderedTraversal(x.leftChild, a);
            // Sets the x's key accordingly to the current traversalCount
            
            keyWordBuilder.append(1);
            // Expands the right child node
            orderedTraversal(x.rightChild, a);
        }
        a[x.index] = keyWordBuilder.toString();
        keyWordBuilder = new StringBuilder();
        // Return the ordered array
        return a;
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
        public Node(int key, int index) {
            this.key = key;
            this.index = index;
        }
        int index;
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