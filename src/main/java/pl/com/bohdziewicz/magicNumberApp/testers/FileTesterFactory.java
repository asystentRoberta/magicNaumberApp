package pl.com.bohdziewicz.magicNumberApp.testers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class FileTesterFactory {

    static final Map<String, FileTesterInterface> extensionsMap = new HashMap<>();

    static {
        extensionsMap.put("gif", new GifTester());
        extensionsMap.put("jpg", new JpgTester());
        extensionsMap.put("txt", new TxtTester());
    }

    static Optional<FileTesterInterface> whatExtensionToTest(String extensionOfFile) {

        return Optional.ofNullable(extensionsMap.get(extensionOfFile));
    }
}
