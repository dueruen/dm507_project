/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
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