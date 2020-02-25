package pl.com.bohdziewicz.magicNumberApp;

import java.io.File;

public class FileToServe {

    private File file;
    private int sizeInBytes;
    private String fileName;
    private String extensionOfFile;

    FileToServe(File file) {

        this.file = file;
    }

    public String getExtensionOfFile() {

        fileName = file.getName();
        return fileName.substring(fileName.length() - 3).toLowerCase();
    }

    int getSizeInBytes() {

        return (int) file.length();
    }

    public File getFile() {

        return file;
    }
}
