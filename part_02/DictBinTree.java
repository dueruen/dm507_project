public class DictBinTree implements Dict {

    private Node root;
    private int nodeCount;
    private int traversalCount;

    public DictBinTree() {

    }

    @Override
    public void insert(int k) {

    }

    @Override
    public int[] orderedTraversal() {
        return null;
    }

    @Override
    public boolean search(int k) {
        return search(root, k);
        
    }

    private boolean search(Node x, int k) { 
        if (x == null || x.key == k) { 
            return true;
        }

        if(k < x.key) { 
            return search(x.leftChild, k);
        }
        else {
            return search(x.rightChild, k);
        }
    }

    private class Node {
        int key;
        Node leftChild;
        Node rightChild;
    }

}