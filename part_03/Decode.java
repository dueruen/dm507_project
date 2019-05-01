import java.io.FileInputStream;
public class Decode {
    /**
     * TEST TEST READING FIRST 255 bytes
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{ 
        FileInputStream inFile = new FileInputStream(args[0]);
        BitInputStream in = new BitInputStream(inFile);
        for (int q = 0; q < 255; q++) {
            System.out.println(in.readInt());
        }
        in.close();
    }

}