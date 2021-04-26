package player;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestFileHandlingImpl {


    @Test
    public void test_file_create_exists() throws IOException {
        Player player = new Player("test");
        FileHandlingImpl fileHandling = new FileHandlingImpl(player);

        assertTrue(fileHandling.printPlayerState());
    }

    @Test
    public void test_read_file_no_file() throws IOException {
        Player player = new Player("test");
        FileHandlingImpl fileHandling = new FileHandlingImpl(player);

        Exception exception = assertThrows(
                FileNotFoundException.class, fileHandling::readPlayerState);

        String expectedMessage = player.getName()+"_player_data.txt";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
