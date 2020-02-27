package pl.com.bohdziewicz.magicNumberApp.testers;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class FileTesterFactoryTest {

    private FileTesterInterface fromFactoryTesterUnoptionaled = null;

    @Test
    public void testIsFactoryCreatesGifTester() {

        Optional<FileTesterInterface> fromFactoryTester = FileTesterFactory.whatExtensionToTest("gif");
        fromFactoryTester.ifPresent(fileTesterInterface -> fromFactoryTesterUnoptionaled = fileTesterInterface);
        Assert.assertTrue(fromFactoryTesterUnoptionaled instanceof GifTester);
    }

    @Test
    public void testIsFactoryCreatesTxtTester() {

        Optional<FileTesterInterface> fromFactoryTester = FileTesterFactory.whatExtensionToTest("txt");
        fromFactoryTester.ifPresent(fileTesterInterface -> fromFactoryTesterUnoptionaled = fileTesterInterface);
        Assert.assertTrue(fromFactoryTesterUnoptionaled instanceof TxtTester);
    }

    @Test
    public void testIsFactoryCreatesJpgTester() {

        Optional<FileTesterInterface> fromFactoryTester = FileTesterFactory.whatExtensionToTest("jpg");
        fromFactoryTester.ifPresent(fileTesterInterface -> fromFactoryTesterUnoptionaled = fileTesterInterface);
        Assert.assertTrue(fromFactoryTesterUnoptionaled instanceof JpgTester);
    }
}