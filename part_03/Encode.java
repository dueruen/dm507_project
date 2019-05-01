import java.lang.Math;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Encode {
    
    public Encode(String[] args) {
        int[] frequency = scanInputFile(args[0]);
        Element e = huffman(frequency);
        String[] s = generateKeywordTable(e);
        writeOutputFile(args, s, frequency);
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

    public Element huffman(int[] input) { 
        int n = Math.abs(input.length);
        PQ q = populateQueue(input);
        for(int i = 0; i < n - 1; i++) {
            Element x = q.extractMin();
            Element y = q.extractMin();
            int key = x.getKey() + y.getKey();

            // DictBinTree tree = new DictBinTree();
            // tree.insert(key, -1);
            // tree.insert(x.getKey(), x.getIndex());
            // tree.insert(y.getKey(), y.getIndex());

            DictBinTree tree = new DictBinTree(key, -1, x, y);
            // tree.insert(x);
            // tree.insert(y);

            q.insert(new Element(key, tree, -1));
        }
        return q.extractMin();   
    }

    public String[] generateKeywordTable(Element root) { 
        String[] s = root.getTree().orderedTraversal();
        System.out.println("generateKeywordTable: " + s[0]);
        return s;
    }

    private void writeOutputFile(String[] args, String[] keyTable, int[] frequency) {
        try (
            FileInputStream inFile = new FileInputStream(args[0]); 
            BitOutputStream out = new BitOutputStream(new FileOutputStream(args[1]))
        ) {
            for (int i : frequency) {
                System.out.println(i);
                out.writeInt(i);
            }
            // int b;
			// while ((b = inFile.read()) != -1) {
            //     for (String s : keyTable[b].split("")) {
            //         out.writeBit(Integer.parseInt(s));
            //     }
			// }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private PQ populateQueue(int[] input) { 
        PQ q = new PQHeap(input.length);
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            // if (input[i] == 0) {
            //     continue;
            // }
            System.out.println("INDEX: " + input[i] );
            q.insert(new Element(input[i], null, i));
            count++;
        }
        System.out.println("Count: " + count);
        return q;
    }

    public static void main(String[] args) { 
        Encode e = new Encode(args);
    }
}