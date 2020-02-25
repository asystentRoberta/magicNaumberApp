package pl.com.bohdziewicz.magicNumberApp.readers;

import java.io.IOException;

public class SourceFolderReader {

    private FilesByteReader filesByteReader = new FilesByteReader();

    public void infoAboutFiles() {

        try {
            filesByteReader.readAllBytes();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
