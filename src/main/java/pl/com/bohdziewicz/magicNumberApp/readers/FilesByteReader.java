package pl.com.bohdziewicz.magicNumberApp.readers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;
import pl.com.bohdziewicz.magicNumberApp.testers.WhatKindOfFileFinder;

class FilesByteReader {

    void readAllBytes() throws IOException {

        WhatKindOfFileFinder whatKindOfFileFinder = new WhatKindOfFileFinder();
        FileListFromResourcesFolder fileListFromResourcesFolder = new FileListFromResourcesFolder();
        File[] allFilesFromResourcesFolder = fileListFromResourcesFolder.getResourcesFolderFiles("files");

        for (File file : allFilesFromResourcesFolder) {
            System.out.println("Ok - lets see at " + file.getName() + " :");
            System.out.println("First six bytes of this file:");
            printBytes(file, 6);
            whatKindOfFileFinder.infoAboutFile(new FileToServe(file));
            System.out.println("=============");
        }
    }

    private void printBytes(File file, int numberOfBytes) throws IOException {

        byte[] allBytes = Files.readAllBytes(file.toPath());
        int i = 0;
        for (byte b : allBytes) {
            if (i < numberOfBytes) {
                System.out.printf("%02x ", b);
                i++;
            } else {
                System.out.println();
                break;
            }
        }
    }
}
