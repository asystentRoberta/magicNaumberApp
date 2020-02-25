package pl.com.bohdziewicz.magicNumberApp.testers;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;
import pl.com.bohdziewicz.magicNumberApp.readers.FileBytesReader;

public class TxtTester implements FileTesterInterface {

    @Override public boolean isFileHasCorrectExtension(FileToServe fileToServe) {

        FileBytesReader fileBytesReader = new FileBytesReader();
        final byte[] allBytesFromFile = fileBytesReader.readAllBytesFromFile(fileToServe);

        CharsetDecoder charsetDecoder = StandardCharsets.UTF_8.newDecoder();

        try {
            charsetDecoder.decode(ByteBuffer.wrap(allBytesFromFile));
        } catch (CharacterCodingException ex) {
            return false;
        }
        return true;
    }
}
