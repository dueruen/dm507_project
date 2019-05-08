public abstract class BasicCode{
    public Element huffman(int[] input) { 
        int n = input.length;
        PQ q = populateQueue(input);
        for(int i = 0; i < n - 1; i++) {
            Element x = q.extractMin();
            Element y = q.extractMin();
            int key = x.getKey() + y.getKey();

            DictBinTree tree = new DictBinTree(key, -1, x, y);
            q.insert(new Element(key, tree, -1));
        }
        return q.extractMin();   
    }

    private PQ populateQueue(int[] input) { 
        PQ q = new PQHeap(input.length);
        for (int i = 0; i < input.length; i++) {
            q.insert(new Element(input[i], null, i));
        }
        return q;
    }
}