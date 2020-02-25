package pl.com.bohdziewicz.magicNumberApp;

public class FileTester {

    boolean isFileHasCorrectExtension(FileToServe fileToServe) {

        FileTesterInterface testedFile =
                FileTesterFactory.whatExtensionToTest(fileToServe.getExtensionOfFile()).orElseThrow(
                        () -> new IllegalArgumentException("I don't have algorithm for that extension(yet!)"));
        return testedFile.isFileHasCorrectExtension(fileToServe);
    }
}
