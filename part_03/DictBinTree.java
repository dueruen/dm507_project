/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
public class DictBinTree implements Dict {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public DictBinTree(int key, int index, Element left, Element right) {
        //System.out.println("INDEX: " + index + "  key: " + key);
        root = new Node(key, index);
        //System.out.println("Lefttree " + left.getTree() + " right: " + right.getTree());
        if (left.getTree() == null && right.getTree() == null) {
            root.leftChild = new Node(left.getKey(), left.getIndex());
            root.rightChild = new Node(right.getKey(), right.getIndex());
        } else if (left.getTree() == null) {
            root.leftChild = new Node(left.getKey(), left.getIndex());
            root.rightChild = right.getTree().getRoot();
        } else if (right.getTree() == null) {
            root.leftChild = left.getTree().getRoot();
            root.rightChild = new Node(right.getKey(), right.getIndex());
        } else {
            root.leftChild = left.getTree().getRoot();
            root.rightChild = right.getTree().getRoot();
        }
        System.out.println("Root: " + index + " left " + root.leftChild.index + "  right " + root.rightChild.index);
    }

    // public void createTree(int rootKey, int rootIndex, int leftKey, int leftIndex, int rightKey, int rightIndex) {
    //     root = new Node(rootKey, rootIndex);
    //     root.leftChild = new Node(leftKey, leftIndex);
    //     root.rightChild = new Node(rightKey, rightIndex);
    // }

    /**
     * This method inserts a node in to the binary tree and preserves struckter
     * after the insertion
     * 
     * @param k key for the new node
     */
    @Override
    public void insert(Element e) {
        // New node with a new key
        Node z = e.getTree().getRoot();
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
        //int[] t = TESTorderedTraversal();
        // for (int i : t) {
        //     System.out.println("i: " + i);
        // }

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
            //System.out.println(x.index);
            if (x.index != -1) {
                if (a[x.index] == null) {
                    a[x.index] = "";
                }
                a[x.index] = a[x.index] + "0"; 
            }
            
            // keyWordBuilder.append(0);
            // Expaneds the left child node
            orderedTraversal(x.leftChild, a);
            // Sets the x's key accordingly to the current traversalCount
            
            if (x.index != -1) {
                if (a[x.index] == null) {
                    a[x.index] = "";
                }
                a[x.index] = a[x.index] + "1"; 
            }
            // keyWordBuilder.append(1);
            // Expands the right child node
            orderedTraversal(x.rightChild, a);
        }
        
        // keyWordBuilder = new StringBuilder();
        // Return the ordered array
        return a;
    }

    int traversalCount;

    //@Override
    // public int[] TESTorderedTraversal() {
    //     // Resets the traversal count to zero
    //     traversalCount = 0;
    //     // Call the private orderedTraversal with the root nood and a empty array
    //     // and returns the result
    //     return orderedTraversal(root, new int[256]);
    // }

    /**
     * This method is for internal use, it returns array of all the numbers in the
     * tree in increasing order
     * 
     * @param x is the node to expaned from
     * @param a is the ordered array
     * 
     * @return int[] This is the array this the numbers
     */
    // private int[] orderedTraversal(Node x, int[] a) {
    //     // Checks that x isn't null
    //     if (x != null) {
    //         // Expaneds the left child node
    //         orderedTraversal(x.leftChild, a);
    //         // Sets the x's key accordingly to the current traversalCount
    //         a[traversalCount] = x.key;
    //         // The traversalCount is increased
    //         traversalCount++;
    //         // Expaneds the right child node
    //         orderedTraversal(x.rightChild, a);
    //     }
    //     // Return the ordered array
    //     return a;
    // }

    /**
     * Private inner Node class
     */
    // private class Node {
    //     /**
    //      * Constructor, initialising the node with it's key
    //      * 
    //      * @param key the nodes key value
    //      */
    //     public Node(int key, int index) {
    //         this.key = key;
    //         this.index = index;
    //     }
    //     int index;
    //     /**
    //      * Nodes key value
    //      */
    //     int key;
    //     /**
    //      * The left child of the node
    //      */
    //     Node leftChild;
    //     /**
    //      * The right child of the node
    //      */
    //     Node rightChild;
    // }

}