package pl.com.bohdziewicz.magicNumberApp;

import java.util.Map;

class WhatKindOfFileFinder {

    void infoAboutFile(FileToServe fileToServe) {

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
