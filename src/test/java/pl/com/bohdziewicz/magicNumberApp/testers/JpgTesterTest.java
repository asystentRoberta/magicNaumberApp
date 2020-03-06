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

@RunWith(MockitoJUnitRunner.class)
public class JpgTesterTest {

    @InjectMocks
    JpgTester jpgTester = new JpgTester();
    @Mock
    private FileBytesReader mockFileBytesReader;
    @Mock
    private FileToServe mockFileToServe;

    @Test
    public void isJpgTesterRecognizeHeadersOfJpg_firstSignature() {

        when(mockFileBytesReader.readNFirstBytesFromFile(mockFileToServe, 4))
                .thenReturn(new byte[]{ -1, -40, -1, -40 });

        boolean passedTest = jpgTester.isFileHasCorrectExtension(mockFileToServe);

        Assert.assertTrue(passedTest);
    }

    @Test
    public void isJpgTesterRecognizeHeadersOfJpg_secondSignature() {

        when(mockFileBytesReader.readNFirstBytesFromFile(mockFileToServe, 4))
                .thenReturn(new byte[]{ -1, -40, -1, -18 });

        boolean passedTest = jpgTester.isFileHasCorrectExtension(mockFileToServe);

        Assert.assertTrue(passedTest);
    }

    @Test
    public void isJpgTesterRecognizeHeadersOfJpg_thirdSignature() {

        when(mockFileBytesReader.readNFirstBytesFromFile(mockFileToServe, 12))
                .thenReturn(new byte[]{ -1, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1 });

        boolean passedTest = jpgTester.isFileHasCorrectExtension(mockFileToServe);

        Assert.assertTrue(passedTest);
    }

    @Test
    public void isJpgTesterRecognizeBadSignatureWithFourBytes() {

        when(mockFileBytesReader.readNFirstBytesFromFile(mockFileToServe, 4))
                .thenReturn(new byte[]{ -1, -40, -1, -32 });

        boolean passedTest = jpgTester.isFileHasCorrectExtension(mockFileToServe);

        Assert.assertFalse(passedTest);
    }

    @Test
    public void isJpgTesterRecognizeBadSignatureWithTwelveBytes() {

        when(mockFileBytesReader.readNFirstBytesFromFile(mockFileToServe, 12))
                .thenReturn(new byte[]{ -9, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1 });

        boolean passedTest = jpgTester.isFileHasCorrectExtension(mockFileToServe);

        Assert.assertFalse(passedTest);
    }
}