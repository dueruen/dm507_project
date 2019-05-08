import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Encode extends BasicCode{
    
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
            throw new Error(e);
        }
        return frequency;
    }

    public String[] generateKeywordTable(Element root) { 
        return root.getTree().orderedTraversal();
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
            throw new Error(e);
        }
    }

    public static void main(String[] args) { 
        Encode e = new Encode(args);
    }
}