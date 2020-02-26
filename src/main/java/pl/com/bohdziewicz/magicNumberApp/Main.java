package pl.com.bohdziewicz.magicNumberApp;

import java.io.File;

import pl.com.bohdziewicz.magicNumberApp.readers.SourceFolderReader;

public class Main {

    public static void main(String[] args) {

        FileToServe fileToServe = null;
        SourceFolderReader sourceFolderReader = new SourceFolderReader();

        if (args.length == 1) {
            fileToServe = new FileToServe(new File(args[0]));
        } else {
            System.out.println("Please use as argument exactly one file");
            System.exit(0);
        }

        if (args[0].equals("sourceFolder")) {
            sourceFolderReader.infoAboutFiles();
        } else {

            MainApp mainApp = new MainApp();
            mainApp.runApp(fileToServe);
        }
    }
}
