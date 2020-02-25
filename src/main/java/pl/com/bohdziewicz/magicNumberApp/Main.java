package pl.com.bohdziewicz.magicNumberApp;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        FileToServe fileToServe = null;

        if (args.length == 1) {
            fileToServe = new FileToServe(new File(args[0]));
        } else {
            System.out.println("Please use as argument exactly one file");
            System.exit(0);
        }
        MainApp mainApp = new MainApp();
        mainApp.printResultOfTestingFile(fileToServe);
    }
}
