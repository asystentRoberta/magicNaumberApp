package pl.com.bohdziewicz.magicNumberApp.readers;

import java.io.File;
import java.util.Objects;

import org.junit.Test;

import pl.com.bohdziewicz.magicNumberApp.FileToServe;

import static org.junit.Assert.assertArrayEquals;

public class FileBytesReaderTest {

    @Test
    public void whatIsGoingOnWhenThereIsNoFile() {

        FileBytesReader fileBytesReader = new FileBytesReader();
        FileToServe fileToServe = null;
        final byte[] shouldBeArrayWithZero = fileBytesReader.readAllBytesFromFile(fileToServe);
        assertArrayEquals(shouldBeArrayWithZero, new byte[0]);
    }

    @Test
    public void whatIsGoingOnWhenFileIsNotFile() {

        FileBytesReader fileBytesReader = new FileBytesReader();
        FileToServe fileToServe = new FileToServe(null);
        final byte[] shouldBeArrayWitZero = fileBytesReader.readAllBytesFromFile(fileToServe);
        assertArrayEquals(shouldBeArrayWitZero, new byte[0]);
    }

    @Test
    public void shouldReadAllBytesFromTxtTestFile() {

        FileBytesReader fileBytesReader = new FileBytesReader();
        ClassLoader classloader = getClass().getClassLoader();
        FileToServe fileToServe =
                new FileToServe(new File(Objects.requireNonNull(classloader.getResource("test.txt")).getFile()));
        byte[] expectingBytes = { 97, 98, 99, 119, 48, 49, 120 };
        byte[] allBytesFromFileReadFromTestFile = fileBytesReader.readAllBytesFromFile(fileToServe);

        assertArrayEquals(expectingBytes, allBytesFromFileReadFromTestFile);
    }

    @Test
    public void shouldReadFourBytesFromTxtTestFile() {

        FileBytesReader fileBytesReader = new FileBytesReader();
        ClassLoader classloader = getClass().getClassLoader();
        FileToServe fileToServe =
                new FileToServe(new File(Objects.requireNonNull(classloader.getResource("test.txt")).getFile()));
        byte[] expectingBytes = { 97, 98, 99, 119 };
        byte[] fourBytesFromFileReadFromTestFile = fileBytesReader.readNFirstBytesFromFile(fileToServe, 4);

        assertArrayEquals(expectingBytes,fourBytesFromFileReadFromTestFile);
    }
}