package pl.com.bohdziewicz.magicNumberApp.readers;

import java.io.IOException;
import java.nio.file.Files;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;

public class FileBytesReader {

    public byte[] readAllBytesFromFile(FileToServe fileToServe) {

        try {
            return Files.readAllBytes(fileToServe.getFile().toPath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new byte[0];
    }

    public byte[] readNFirstBytesFromFile(FileToServe fileToServe, int nBytesToRead) {

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
