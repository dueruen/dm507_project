import java.io.FileInputStream;
import java.io.FileOutputStream;
/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
public class Encode extends BasicCode{
    
    public Encode(String[] args) {
        //Creates the frequency foreach charater
        int[] frequency = scanInputFile(args[0]);
        //Generates the huffman tree
        Element e = huffman(frequency);
        //Generates the keywords
        String[] s = generateKeywordTable(e);
        //Writes encoded data to output file
        writeOutputFile(args, s, frequency);
    }

    /**
     * Scans a file and returns the frequency foreach each ascii character
     * @param inputFile the name of the input file
     * @return frequency of each ascii charactter
     */
    private int[] scanInputFile(String inputFile) {
        int[] frequency = new int[256]; 
        try (FileInputStream inFile = new FileInputStream(inputFile)) {
            int b;
            //Loop through the file and 
            //increces the frequency for the found character
			while ((b = inFile.read()) != -1) {
				frequency[b] += 1;
			}
        } catch(Exception e) {
            throw new Error(e);
        }
        return frequency;
    }

    /**
     * Generates the keywords foreach ascii character
     * @param root the root noot
     * @return array with the keywords
     */
    public String[] generateKeywordTable(Element root) { 
        return root.getTree().orderedTraversal();
    }

    /**
     * Writes the encoded data to a file
     * @param args name of the input and output file
     * @param keyTable array with keywords foreach character
     * @param frequency array with the frequency foreach character
     */
    private void writeOutputFile(String[] args, String[] keyTable, int[] frequency) {
        try (
            FileInputStream inFile = new FileInputStream(args[0]); 
            BitOutputStream out = new BitOutputStream(new FileOutputStream(args[1]))
        ) {
            //Writes the frequency as the first 256 bytes
            for (int i : frequency) {
                out.writeInt(i);
            }
            //Goes through the input file 
            //and writes the keyword foreach character in the output file
            int b;
			while ((b = inFile.read()) != -1) {
                //Finds the keyword for a given character and 
                //splits the keyword the single bits and writes them
                for (String s : keyTable[b].split("")) {
                    out.writeBit(Integer.parseInt(s));
                }
			}
        } catch(Exception e) {
            throw new Error(e);
        }
    }

    /**
     * Main class
     * @param args input and output file names
     */
    public static void main(String[] args) { 
        Encode e = new Encode(args);
    }
}