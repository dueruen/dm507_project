import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
public class Decode extends BasicCode {

    public Decode(String[] args) {
        decode(args);
    }

    /**
     * Scans a file and decodes it by using the frequency from the file and the
     * Huffman algorithm.
     * 
     * @param infile    The name of the incoming file
     * @param frequency Array with the frequency foreach character
     * @param e         Element that have all of the previous Elements as parts of
     *                  it's Tree
     * 
     */
    private void decode(String[] args) {
        try (FileInputStream inFile = new FileInputStream(args[0]);
                BitInputStream in = new BitInputStream(inFile);
                FileOutputStream outFile = new FileOutputStream(args[1]);) {
            // creates int array for freqency
            int[] frequency = new int[256];
            int totalBytes = 0;
            // for loop for adding the first 256 bytes in to the frequency array.
            for (int i = 0; i < 256; i++) {
                int f = in.readInt();
                frequency[i] = f;
                totalBytes += f;
            }
            /**
             * Uses the Huffman algorithm with the frequency from the stream and sets it to
             * Element e
             */

            Element e = huffman(frequency);
            // int used to iterate through the tree
            int b;
            // Sets the current node to the root of e
            Node currentNode = e.getTree().getRoot();
            int currentByte = 0;
            // runs loop as long as are bits and currentByte is not equel to
            // totalBytes
            while ((b = in.readBit()) != -1 && currentByte != totalBytes) {
                // moves to a new node
                currentNode = e.getTree().nextNode(currentNode, b);
                // if b equels 0 and the currentNodes does not have a left child.
                if (b == 0 && currentNode.leftChild == null) {
                    // write the the index of the current node.
                    outFile.write(currentNode.index);
                    // sets currentNode back to the root of element e
                    currentNode = e.getTree().getRoot();
                    // add 1 to currentByte
                    currentByte++;
                    continue;
                    // if b is one 1 and and there is right child
                } else if (b == 1 && currentNode.rightChild == null) {
                    // writes the index of currentNode.
                    outFile.write(currentNode.index);
                    // sets currentNode back to the root of element e.
                    currentNode = e.getTree().getRoot();
                    // add 1 to currentByte
                    currentByte++;
                    continue;
                }
            }
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        Decode e = new Decode(args);
    }
}