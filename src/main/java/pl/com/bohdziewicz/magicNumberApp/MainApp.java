package pl.com.bohdziewicz.magicNumberApp;

import pl.com.bohdziewicz.magicNumberApp.testers.FileTester;
import pl.com.bohdziewicz.magicNumberApp.testers.WhatKindOfFileFinder;

class MainApp {

    private FileToServe fileToServe;

    void runApp(FileToServe fileToServe) {

        this.fileToServe = fileToServe;

        if (fileToServe.isItSafeToServeThisFile()) {
            printResultOfTestingFile();
        } else {
            System.out.println("Something wrong with your file (maybe it is to big?) - I can't proceed.");
            System.exit(0);
        }
    }

    private void printResultOfTestingFile() {

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
