package pl.com.bohdziewicz.magicNumberApp;

import pl.com.bohdziewicz.magicNumberApp.testers.FileTester;
import pl.com.bohdziewicz.magicNumberApp.testers.WhatKindOfFileFinder;

class MainApp {

    void printResultOfTestingFile(FileToServe fileToServe) {

        FileTester fileTester = new FileTester();
        WhatKindOfFileFinder whatKindOfFileFinder = new WhatKindOfFileFinder();
        final boolean isFileHasCorrectExtension = fileTester.isFileHasCorrectExtension(fileToServe);

        if (isFileHasCorrectExtension) {
            System.out.println("My algorithm said that the file has correct extension");
        } else {
            System.out.println("My algorithm said that the file has not correct extensions");
            whatKindOfFileFinder.infoAboutFile(fileToServe);
        }
    }
}
