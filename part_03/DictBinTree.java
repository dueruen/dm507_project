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
        //if the left and right elements tree's arn't create
        if (left.getTree() == null && right.getTree() == null) {
            root.leftChild = new Node(left.getKey(), left.getIndex());
            root.rightChild = new Node(right.getKey(), right.getIndex());
        } else if (left.getTree() == null) { //left tree arn't create
            root.leftChild = new Node(left.getKey(), left.getIndex());
            root.rightChild = right.getTree().root;
        } else if (right.getTree() == null) { //right tree arn't create
            root.leftChild = left.getTree().root;
            root.rightChild = new Node(right.getKey(), right.getIndex());
        } else { //both tree's are created
            root.leftChild = left.getTree().root;
            root.rightChild = right.getTree().root;
        }
    }

    public Node nextNode(Node n, int inputBit) {
        if (inputBit == 0) {
            return n.leftChild;
        } else {
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
     * This method is for internal use, it returns array of all the keywords in the
     * tree.
     * 
     * @param x is the node to expaned from
     * @param a is the ordered array
     * 
     * @return String[] This is the array this the keywords
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
            //if not a leave
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
     * @return the root
     */
    public Node getRoot() {
        return root;
    }
}