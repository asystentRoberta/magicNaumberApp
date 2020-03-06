package pl.com.bohdziewicz.magicNumberApp.testers;

import java.util.Arrays;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;
import pl.com.bohdziewicz.magicNumberApp.readers.FileBytesReader;

public class JpgTester implements FileTesterInterface {

    private static final byte[] jpgFirstFourBytesFirstSignature = { -1, -40, -1, -40 };
    private static final byte[] jpgFirstFourBytesSecondSignature = { -1, -40, -1, -18 };
    private static final byte[] jpgFirstTwelveBytesThirdSignature = { -1, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1 };
    private FileBytesReader fileBytesReader = new FileBytesReader();

    @Override public boolean isFileHasCorrectExtension(FileToServe fileToServe) {

        final byte[] fourFirstBytesFromFile = fileBytesReader.readNFirstBytesFromFile(fileToServe, 4);
        final byte[] twelveFirstBytesFromFile = fileBytesReader.readNFirstBytesFromFile(fileToServe, 12);

        return Arrays.equals(jpgFirstFourBytesFirstSignature, fourFirstBytesFromFile)
                || Arrays.equals(jpgFirstFourBytesSecondSignature, fourFirstBytesFromFile)
                || Arrays.equals(jpgFirstTwelveBytesThirdSignature, twelveFirstBytesFromFile);
    }
}
//Comments only for reviewers - There is no space for comments in the code ;)
//TODO  "FF D8 FF E1 ?? ?? 45 78 69 66 00 00" ->
//Signature from https://en.wikipedia.org/wiki/List_of_file_signatures