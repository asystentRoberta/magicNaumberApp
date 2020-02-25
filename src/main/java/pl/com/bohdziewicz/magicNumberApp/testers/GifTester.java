package pl.com.bohdziewicz.magicNumberApp.testers;

import java.util.Arrays;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;
import pl.com.bohdziewicz.magicNumberApp.readers.FileBytesReader;

public class GifTester implements FileTesterInterface {

    //Hex signature -> Dec signature (using BYTE) (for example FF->-1 or 47->71
    private static final byte[] gifFirstSixBytesFirstSignature = { 71, 73, 70, 56, 55, 97 };
    private static final byte[] gifFirstSixBytesSecondSinature = { 71, 73, 70, 56, 57, 97 };

    @Override public boolean isFileHasCorrectExtension(FileToServe fileToServe) {

        FileBytesReader fileBytesReader = new FileBytesReader();
        final byte[] sixFirstBytesOfTestedFile = fileBytesReader.readNFirstBytesFromFile(fileToServe, 6);

        return Arrays.equals(gifFirstSixBytesFirstSignature, sixFirstBytesOfTestedFile) || Arrays
                .equals(gifFirstSixBytesSecondSinature, sixFirstBytesOfTestedFile);
    }
}
