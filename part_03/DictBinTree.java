/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
public class DictBinTree implements Dict {

    private Node root;

    public DictBinTree(int key, int index, Element left, Element right) {
        root = new Node(key, index);
        if (left.getTree() == null && right.getTree() == null) {
            root.leftChild = new Node(left.getKey(), left.getIndex());
            root.rightChild = new Node(right.getKey(), right.getIndex());
        } else if (left.getTree() == null) {
            root.leftChild = new Node(left.getKey(), left.getIndex());
            root.rightChild = right.getTree().root;
        } else if (right.getTree() == null) {
            root.leftChild = left.getTree().root;
            root.rightChild = new Node(right.getKey(), right.getIndex());
        } else {
            root.leftChild = left.getTree().root;
            root.rightChild = right.getTree().root;
        }
    }

    /**
     * This method returns array of all the numbers in the tree in increasing order
     * 
     * @return int[] This is the array this the numbers
     */
    @Override
    public String[] orderedTraversal() {
        String[] te = orderedTraversal(root, new String[256]);
        return te;
    }

    private StringBuilder currentPath = new StringBuilder();
    private int indexCount;
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
            indexCount = x.index;
            currentPath.append("0");
            orderedTraversal(x.leftChild, a);

            currentPath.append("1");
            orderedTraversal(x.rightChild, a);    
        }

        if (x != null) {
            if (x.index != -1) {
                a[indexCount] = currentPath.toString();   
            }
        }
        if (currentPath.length() != 0){
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
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