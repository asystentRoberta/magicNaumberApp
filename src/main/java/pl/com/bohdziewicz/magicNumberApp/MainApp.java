package pl.com.bohdziewicz.magicNumberApp;

class MainApp {

    void printResultOfTestingFile(FileToServe fileToServe) {

        FileTester fileTester = new FileTester();
        final boolean isFileHasCorrectExtension = fileTester.isFileHasCorrectExtension(fileToServe);

        if (isFileHasCorrectExtension) {
            System.out.println("My algorithm says that the file has correct extension");
        } else {
            System.out.println("My algorithm says that the file has not correct extensions");
        }
    }
}
