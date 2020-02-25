package pl.com.bohdziewicz.magicNumberApp;

import java.io.File;

class FileToServe {

    private File file;
    private int sizeInBytes;
    private String fileName;
    private String extensionOfFile;

    FileToServe(File file) {

        this.file = file;
    }

    String getExtensionOfFile() {

        fileName = file.getName();
        return fileName.substring(fileName.length() - 3).toLowerCase();
    }

    int getSizeInBytes() {

        return (int) file.length();
    }

    File getFile() {

        return file;
    }
}
