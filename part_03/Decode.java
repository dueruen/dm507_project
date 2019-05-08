import java.io.InputStream;
import java.io.FileInputStream;

public class Decode {

    public Decode(String inputFile) {
        try {
            FileInputStream fin = new FileInputStream(inputFile);
            BitInputStream inFile = new BitInputStream(fin);
            for()
            inFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Element huffman(int[] input) {
        int n = Math.abs(input.length);
        PQ q = populateQueue(input);
        for (int i = 0; i < n; i++) {
            Element left = q.extractMin();
            Element x = left;
            Element right = q.extractMin();
            Element y = right;
            int key = x.getKey() + y.getKey();

            DictBinTree tree = new DictBinTree();
            tree.insert(key);
            tree.insert(x.getKey());
            tree.insert(y.getKey());

            q.insert(new Element(key, tree));

        }
        return q.extractMin();
    }

    private PQ populateQueue(int[] input) {
        PQ q = new PQHeap(input.length);
        for (int i : input) {
            q.insert(new Element(i, null));
        }
        return q;
    }
}
