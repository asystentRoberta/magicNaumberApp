package pl.com.bohdziewicz.magicNumberApp;

import java.io.File;

/*
Commentary for educational purposes
Consider:
+ delete this class and use File instead
+ extends File

 */

public class FileToServe {

    private final File file;

    public FileToServe(File file) {

        this.file = file;
    }

    public String getExtensionOfFile() {

        String fileName = file.getName();
        return fileName.substring(fileName.length() - 3).toLowerCase();
    }

    private int getSizeInBytes() {

        return (int) file.length();
    }

    public File getFile() {

        return file;
    }

    boolean isItSafeToServeThisFile() {

        return getSizeInBytes() <= 3932160;  //3932160 bytes => 30MB
    }

    public boolean isItFile() {

        if (file != null) {
            return file.isFile();
        }
        return false;
    }
}
