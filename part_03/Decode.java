import java.io.InputStream;
import java.io.FileInputStream;

public class Decode {

    public Decode(String inputFile) {
        try {
            FileInputStream fin = new FileInputStream(inputFile);
            BitInputStream inFile = new BitInputStream(fin);
            inFile.readBit();
            inFile.readint(fin);
            Encode.houfman();
            inFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
