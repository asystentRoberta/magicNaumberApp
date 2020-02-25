package pl.com.bohdziewicz.magicNumberApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class FileTesterFactory {

    private static Map<String, FileTesterInterface> extensionsMap = new HashMap<>();

    static {
        extensionsMap.put("gif", new GifTester());
    }

    static Optional<FileTesterInterface> whatExtensionToTest(String extensionOfFile) {

        return Optional.ofNullable(extensionsMap.get(extensionOfFile));
    }
}
