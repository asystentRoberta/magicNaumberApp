package pl.com.bohdziewicz.magicNumberApp.testers;

import java.io.File;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;

/*
Commentary for educational purposes only.
I feel it is not correct way to test. I have to learn.
 */

public class FileTesterTest {

    @Test
    public void testFileTesterForRecognizeCorrectExtension() {

        File fileWithCorrectExtension = new File(
                Objects.requireNonNull(getClass().getClassLoader().getResource("test.txt")).getFile());
        FileToServe fileToServeWithCorrectExtension = new FileToServe(fileWithCorrectExtension);
        final boolean fileHasCorrectExtension =
                new FileTester().isFileHasCorrectExtension(fileToServeWithCorrectExtension);
        Assert.assertTrue(fileHasCorrectExtension);
    }

    @Test
    public void testFileTesterForRecognizeBadExtension() {

        File fileWithBadExtension = new File(
                Objects.requireNonNull(getClass().getClassLoader().getResource("notTextItIsJpg.jpg")).getFile());
        FileToServe fileWithBadCorrectExtension = new FileToServe(fileWithBadExtension);
        final boolean fileHasBadExtension =
                new FileTester().isFileHasCorrectExtension(fileWithBadCorrectExtension);
        Assert.assertFalse(fileHasBadExtension);
    }
}