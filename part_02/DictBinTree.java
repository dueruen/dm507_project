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
        return false;
    }

    private class Node {
        int key;
        Node leftChild;
        Node rightChild;
    }

}