package pl.com.bohdziewicz.magicNumberApp.testers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;
import pl.com.bohdziewicz.magicNumberApp.readers.FileBytesReader;

import static org.mockito.Mockito.when;

/*
Commentary for educational purposes only.
All my tests should be seen by someone smarter
 */

@RunWith(MockitoJUnitRunner.class)
public class GifTesterTest {

    @InjectMocks
    GifTester gifTester = new GifTester();
    @Mock
    private FileBytesReader mockFileBytesReader;
    @Mock
    private FileToServe mockFileToServe;

    @Test
    public void isGifTesterRecognizeHeadersOfGif_firstSignature() {

        when(mockFileBytesReader.readNFirstBytesFromFile(mockFileToServe, 6)).thenReturn(new byte[]{ 71, 73, 70, 56,
                55, 97 });

        final boolean passedTest = gifTester.isFileHasCorrectExtension(mockFileToServe);

        Assert.assertTrue(passedTest);
    }

    @Test
    public void isGifTesterRecognizeHeadersOfGif_secondSignature() {

        when(mockFileBytesReader.readNFirstBytesFromFile(mockFileToServe, 6))
                .thenReturn(new byte[]{ 71, 73, 70, 56, 57, 97 });

        final boolean passedTest = gifTester.isFileHasCorrectExtension(mockFileToServe);

        Assert.assertTrue(passedTest);
    }

    @Test
    public void isGifTesterRecognizeBadHeadersOfGif() {

        when(mockFileBytesReader.readNFirstBytesFromFile(mockFileToServe, 6))
                .thenReturn(new byte[]{ 70, 73, 70, 56, 55, 97 });

        final boolean passedTest = gifTester.isFileHasCorrectExtension(mockFileToServe);

        Assert.assertFalse(passedTest);
    }
}