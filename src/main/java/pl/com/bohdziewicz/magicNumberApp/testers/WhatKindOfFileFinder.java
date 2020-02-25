package pl.com.bohdziewicz.magicNumberApp.testers;

import java.util.Map;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;

public class WhatKindOfFileFinder {

    public void infoAboutFile(FileToServe fileToServe) {

        for (Map.Entry<String, FileTesterInterface> extensionsMap : FileTesterFactory.extensionsMap.entrySet()) {

            FileTesterInterface fileTesterInterface = (FileTesterInterface) ((Map.Entry) extensionsMap).getValue();
            boolean isFileHasCorrectExtension = fileTesterInterface.isFileHasCorrectExtension(fileToServe);
            if (isFileHasCorrectExtension) {
                System.out.println("Extension is "
                        + fileToServe.getExtensionOfFile()
                        + ", while actually it's a "
                        + ((Map.Entry) extensionsMap).getKey()
                        + ".");
            }
        }
    }
}
