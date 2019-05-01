import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Decode {
    public static void main(String[] args) throws Exception{ 
        FileInputStream inFile = new FileInputStream(args[0]);
        //FileOutputStream outFile = new FileOutputStream(args[1]);
    
        // Wrap the new bit streams around the input/output streams.
        BitInputStream in = new BitInputStream(inFile);
        //BitOutputStream out = new BitOutputStream(outFile);
    
        // First read a full int (i.e., four bytes) from input file
        // using the library method readInt().
        int i = in.readInt();
    
        // Print the value on screen (probably multi-digit integer, if
        // run on a textfile, as four bytes representing some chars
        // are ususally the bit pattern of some big integer).
        System.out.println(i);
    
        // Write the int again to output file (as same four bytes, so
        // bytes should appear again in output file exactly they were
        // in input file) using the library method writeInt().
       // out.writeInt(i);
    
        // Now read last bits of input file. Do this bit by bit using
        // the library method readBit(). At the same time write them
        // again on the output file using the library method
        // writeBit(). Note the while-expression going through the
        // file until no more bits are available (signaled by
        // returning -1 instead of 0 or 1).
        int bit;
        for (int q = 0; q < 255; q++) {
            System.out.println(in.readInt());
        }
            

        in.close();
    }

}