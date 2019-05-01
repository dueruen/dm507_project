import java.io.InputStream;
import java.io.FileInputStream;

public class Decode {

    public Decode(String file) {
        try {
            BitInputStream inFile = new BitInputStream(file);
            inFile.BitInputStream(file);
            inFile.readBit();
            inFile.readint(file);
            inFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
