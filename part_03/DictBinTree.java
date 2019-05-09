/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
public class DictBinTree implements Dict {

    //Root node
    private Node root;
    //Used to keep a keyword/path to the root node
    private StringBuilder currentPath = new StringBuilder();
    //Used to travers through the tree 
    private int indexCount;

    /**
     * Creates a new tree
     * @param key of the root
     * @param index of the root
     * @param left element containg the tree that are going to be the left child
     * @param right element containg the tree that are going to be the right child
     */
    public DictBinTree(int key, int index, Element left, Element right) {
        //Instanciates the root
        root = new Node(key, index);
        //if the left and right element's trees aren't created
        if (left.getTree() == null && right.getTree() == null) {
            root.leftChild = new Node(left.getKey(), left.getIndex());
            root.rightChild = new Node(right.getKey(), right.getIndex());
        } else if (left.getTree() == null) { //left tree isn't created
            root.leftChild = new Node(left.getKey(), left.getIndex());
            root.rightChild = right.getTree().root;
        } else if (right.getTree() == null) { //right tree isn't created
            root.leftChild = left.getTree().root;
            root.rightChild = new Node(right.getKey(), right.getIndex());
        } else { //both trees are created
            root.leftChild = left.getTree().root;
            root.rightChild = right.getTree().root;
        }
    }

    /**
     * Traverses thorugh tree nodes, based on the inputbit
     * @param n node from where the traversal is made
     * @param inputBit bit deining whether to go left or right
     * @return the next Node
     */
    public Node nextNode(Node n, int inputBit) {
        //If the bit is zero, go left
        if (inputBit == 0) { 
            return n.leftChild;
        } else { //go right
            return n.rightChild;
        }
    }

    /**
     * This method returns array of all the keywords in the tree
     * 
     * @return String[] This is the array this the keywords
     */
    @Override
    public String[] orderedTraversal() {
        return orderedTraversal(root, new String[256]);
    }

    /**
     * This method is for internal use, it traverses the tree, 
     * and returns array of all the keywords in the tree.
     * 
     * @param x is the node to expanded from
     * @param a is the ordered array
     * 
     * @return String[] This is the array of  keywords
     */
    private String[] orderedTraversal(Node x, String[] a) {
        // Checks that x isn't null
        if (x != null) {
            //sets the global indexCounter, to 
            //maintain knowledge of how far along in the
            //tree thet traversal has come
            indexCount = x.index;

            //adds 0, 
            //and recursively expands left child node
            currentPath.append("0");
            orderedTraversal(x.leftChild, a);

            //adds 0, 
            //and recursively expands right child node
            currentPath.append("1");
            orderedTraversal(x.rightChild, a);    
        }
        //Once again checks for null, to make leaf check
        if (x != null) {
            //If not a leaf
            if (x.index != -1) {
                a[indexCount] = currentPath.toString();   
            }
        }
        //Finally, if the currentPath has a length other than zero, 
        //delete the last char in the path
        if (currentPath.length() != 0){
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
        //Return keyword array
        return a;
    }

    /**
     * @return the root
     */
    public Node getRoot() {
        return root;
    }
}