    /**
     * Private inner Node class
     */
    public class Node {
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
// /**
    //  * Private inner Node class
    //  */
    // public class Node {
    //     /**
    //      * Constructor, initialising the node with it's key
    //      * 
    //      * @param key the nodes key value
    //      */
    //     public Node(int key, int index) {
    //         this.key = key;
    //         this.index = index;
    //     }
    //     private int index;
    //     /**
    //      * Nodes key value
    //      */
    //     private int key;
    //     /**
    //      * The left child of the node
    //      */
    //     private Node leftChild;
    //     /**
    //      * The right child of the node
    //      */
    //     private Node rightChild;

    //     /**
    //      * @return the index
    //      */
    //     public int getIndex() {
    //         return index;
    //     }

    //     /**
    //      * @return the key
    //      */
    //     public int getKey() {
    //         return key;
    //     }

    //     /**
    //      * @return the leftChild
    //      */
    //     public Node getLeftChild() {
    //         //System.out.println("LEFT: " + leftChild);
    //         return leftChild;
    //     }

    //     /**
    //      * @return the rightChild
    //      */
    //     public Node getRightChild() {
    //         //System.out.println("RIGHT: " + rightChild);
    //         return rightChild;
    //     }

    //     /**
    //      * @param leftChild the leftChild to set
    //      */
    //     public void setLeftChild(Node leftChild) {
    //         this.leftChild = leftChild;
    //     }

    //     /**
    //      * @param rightChild the rightChild to set
    //      */
    //     public void setRightChild(Node rightChild) {
    //         this.rightChild = rightChild;
    //     }
    // }