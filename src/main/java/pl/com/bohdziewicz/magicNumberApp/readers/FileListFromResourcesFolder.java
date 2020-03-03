package pl.com.bohdziewicz.magicNumberApp.readers;

import java.io.File;
import java.net.URL;
import java.nio.file.InvalidPathException;
import java.util.Objects;

class FileListFromResourcesFolder {

    File[] getResourcesFolderFiles(String folderNameInResourcesFolder) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(folderNameInResourcesFolder);
        if (url != null) {
            String path = Objects.requireNonNull(url).getPath();
            return new File(path).listFiles();
        } else {
            throw new InvalidPathException(folderNameInResourcesFolder, " doesn't exist in resources folder");
        }
    }
}
