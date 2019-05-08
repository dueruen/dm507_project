import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
public class Decode extends BasicCode{

    public Decode(String[] args) {
        decode(args);
    }

    private void decode(String[] args) {
        try (
            FileInputStream inFile = new FileInputStream(args[0]); 
            BitInputStream in = new BitInputStream(inFile);
            FileOutputStream outFile = new FileOutputStream(args[1]); 
        ) {
            int[] frequency = new int[256];
            int totalBytes = 0;
            for (int i = 0; i < 256; i++) {
                int f = in.readInt();
                frequency[i] = f;
                totalBytes += f;
            }
            Element e = huffman(frequency);
            int b;
            Node currentNode = e.getTree().getRoot();
            int currentByte = 0;
            while ((b = in.readBit()) != -1 && currentByte != totalBytes ) {
                currentNode = e.getTree().nextNode(currentNode, b);
                if (b == 0 && currentNode.leftChild == null) {
                    outFile.write(currentNode.index);
                    currentNode = e.getTree().getRoot();
                    currentByte++;
                    continue;
                } else if (b == 1 && currentNode.rightChild == null) {
                    outFile.write(currentNode.index);
                    currentNode = e.getTree().getRoot();
                    currentByte++;
                    continue;
                }
            }
        } catch(Exception e) {
            throw new Error(e);
        }
    }
    public static void main(String[] args) { 
        Decode e = new Decode(args);
    }
}