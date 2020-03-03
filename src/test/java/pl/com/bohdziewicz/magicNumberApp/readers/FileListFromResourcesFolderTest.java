package pl.com.bohdziewicz.magicNumberApp.readers;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileListFromResourcesFolderTest {

    @Test
    public void shouldReturnListOfFilesFromResourcesFilesFolder() {

        FileListFromResourcesFolder fileListFromResourcesFolder = new FileListFromResourcesFolder();
        final File[] resourcesFolderFiles = fileListFromResourcesFolder.getResourcesFolderFiles("files");
        assertEquals(3, resourcesFolderFiles.length);
        Arrays.sort(resourcesFolderFiles);
        assertEquals("a.txt", resourcesFolderFiles[0].getName());
        assertEquals("b.txt", resourcesFolderFiles[1].getName());
        assertEquals("c.txt", resourcesFolderFiles[2].getName());
    }

    @Test(expected = InvalidPathException.class)
    public void shouldThrowInvalidPathExceptionIfFolderFilesDoesntExistInResourcesFolder() {

        FileListFromResourcesFolder fileListFromResourcesFolder = new FileListFromResourcesFolder();
        final File[] resourcesFolderFiles = fileListFromResourcesFolder.getResourcesFolderFiles("notExistingFolder");
    }

    /*
    I have to ask someone clever then me. When I start a test below - everyting is going in "out" folder (and if I have
     an empty folder in test/resources/emptyFolder, in out folder it won't create. A test will failed.
     I didn't know that folder "out" is used to tests...
     */

//    @Test
//    public void shouldReturnEmptyList(){
//        FileListFromResourcesFolder fileListFromResourcesFolder = new FileListFromResourcesFolder();
//        final File[] resourcesFolderFiles = fileListFromResourcesFolder.getResourcesFolderFiles("emptyFolder");
//
//    }
}