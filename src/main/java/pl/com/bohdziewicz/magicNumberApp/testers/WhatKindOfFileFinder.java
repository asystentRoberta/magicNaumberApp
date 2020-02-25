package pl.com.bohdziewicz.magicNumberApp.testers;

import java.util.Map;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;

public class WhatKindOfFileFinder {

    public void infoAboutFile(FileToServe fileToServe) {

        for (Map.Entry<String, FileTesterInterface> extensionsMap : FileTesterFactory.extensionsMap.entrySet()) {

            FileTesterInterface fileTesterInterface = (FileTesterInterface) ((Map.Entry) extensionsMap).getValue();
            boolean isFileHasCorrectExtension = fileTesterInterface.isFileHasCorrectExtension(fileToServe);
            System.out.println(
                    "Tested: "
                            + ((Map.Entry) extensionsMap).getKey()
                            + " and result was: "
                            + isFileHasCorrectExtension);
        }
    }
}
