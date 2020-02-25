package pl.com.bohdziewicz.magicNumberApp.readers;

import java.io.File;
import java.net.URL;
import java.util.Objects;

class FileListFromResourcesFolder {

    File[] getResourcesFolderFiles(String folder) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(folder);
        String path = Objects.requireNonNull(url).getPath();
        return new File(path).listFiles();
    }
}
