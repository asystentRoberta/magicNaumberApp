package pl.com.bohdziewicz.magicNumberApp;

import java.io.IOException;
import java.nio.file.Files;

public class FileBytesReader {

    private byte[] readAllBytesFromFile(FileToServe fileToServe) {

        try {
            return Files.readAllBytes(fileToServe.getFile().toPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new byte[0];
    }

    byte[] readNFirstBytesFromFile(FileToServe fileToServe, int nBytesToRead) {

        byte[] allBytesFile = readAllBytesFromFile(fileToServe);
        byte[] nBytesToReturn = new byte[nBytesToRead];

        int i = 0;
        for (byte b : allBytesFile) {
            if (i < nBytesToRead) {
                nBytesToReturn[i] = b;
                i++;
            } else {
                break;
            }
        }
        return nBytesToReturn;
    }
}
