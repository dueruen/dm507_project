import java.lang.Math;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Encode {
    public Encode(String[] args) {

    }

    private int[] scanInputFile(String inputFile) {
        int[] frequency = new int[256]; 
        try (FileInputStream inFile = new FileInputStream(inputFile)) {
            int b;
			while ((b = inFile.read()) != -1) {
				frequency[b] += 1;
			}
        } catch(Exception e) {
            System.out.println(e);
        }
        return frequency;
    }

    private void writeOutputFile(String[] args, String[] keyTable, int[] frequency) {
        try (
            FileInputStream inFile = new FileInputStream(args[0]); 
            BitOutputStream out = new BitOutputStream(new FileOutputStream(args[1]))
        ) {
            for (int i : frequency) {
                out.writeInt(i);
            }
            int b;
			while ((b = inFile.read()) != -1) {
                for (String s : keyTable[b].split("")) {
                    out.writeBit(Integer.parseInt(s));
                }
			}
        } catch(Exception e) {
            System.out.println(e);
        }
    }
  
    public Element huffman(int[] input) { 
        int n = Math.abs(input.length);
        PQ q = populateQueue(input);
        for(int i = 0; i < n; i++) {
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
        for (int i: input) { 
            q.insert(new Element(i, null));
        }
        return q;
    }
    


    public static void main(String[] args) { 
        Encode e = new Encode(args);
    }
}