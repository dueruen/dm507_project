public class DictBinTree implements Dict {

    private Node root;
    private int nodeCount;
    private int traversalCount;

    @Override
    public void insert(int k) {
        nodeCount++;
        Node z = new Node(k);
        if (root == null) {
            root = z;
            return;
        }
        Node y = null;
        Node x = root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.leftChild;
            } else {
                x = x.rightChild;
            }
        }
        if (y == null) {
            root = z;
        } else if (z.key < y.key) {
            y.leftChild = z;
        } else {
            y.rightChild = z;
        }
    }

    @Override
    public int[] orderedTraversal() {
        traversalCount = 0;
        return orderedTraversal(root, new int[nodeCount]);
    }

    private int[] orderedTraversal(Node x, int[] a) {
        if (x != null) {
            orderedTraversal(x.leftChild, a);
            a[traversalCount] = x.key;
            traversalCount++;
            orderedTraversal(x.rightChild, a);
        }
        return a;
    }

    @Override
    public boolean search(int k) {
        return search(root, k);
    }

    private boolean search(Node x, int k) {
        if (x == null) {
            return false;
        }
        if (k == x.key) {
            return true;
        }

        if (k < x.key) {
            return search(x.leftChild, k);
        } else {
            return search(x.rightChild, k);
        }
    }

    private class Node {
        public Node(int key) {
            this.key = key;
        }

        int key;
        Node leftChild;
        Node rightChild;
    }

}