package player;

import casino.player.FileHandlingImpl;
import casino.player.Player;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestFileHandlingImpl {

    Player player = new Player("fileTester");

    @Test
    public void test_file_create_exists() throws IOException {
        FileHandlingImpl fileHandling = new FileHandlingImpl(player);

        assertTrue(fileHandling.writePlayerState());
    }

    @Test
    public void test_read_file_no_file() throws IOException {
        FileHandlingImpl fileHandling = new FileHandlingImpl(player);

        fileHandling.readPlayerState();

        assertEquals(fileHandling.readPlayerState().getName(), player.getName());

    }

    @Test
    public void test_update_from_file() throws IOException {
        FileHandlingImpl fileHandling = new FileHandlingImpl(player);

        player.setBalance(100);
        fileHandling.writePlayerState();

        player.addToBalance(100);

        int unsavedBalance = player.getBalance();
        int balanceFromFile = fileHandling.readPlayerState().getBalance();

        assertEquals(200, unsavedBalance);
        assertEquals(100, balanceFromFile);
    }

    @Test
    public void test_read_player_state_from_file() throws IOException {
        FileHandlingImpl fileHandling = new FileHandlingImpl(player);

        player.setBalance(100);
        fileHandling.writePlayerState();
        player.addToBalance(100);

        Player playerStateFromFile = fileHandling.readPlayerState();
        int balanceFromFile = playerStateFromFile.getBalance();

        player.updatePlayer(playerStateFromFile);

        assertEquals(balanceFromFile, player.getBalance());
    }

    @Test
    public void test_read_neg_bal_from_file() throws IOException {
        String FILE_PATH = "invalid_player_data.txt";
        FileWriter playerFileWriter = new FileWriter(FILE_PATH);

        String result = "invalid" +
                "\n" +
                "-100";
        playerFileWriter.write(result);
        playerFileWriter.close();

        Player invalid = new Player("invalid");
        FileHandlingImpl fileHandling = new FileHandlingImpl(invalid);

        Exception exception = assertThrows(
                IllegalArgumentException.class, fileHandling::readPlayerState);

        String expectedMessage = "Invalid file. Player balance must be positive.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    /*@Test
    public void test_read_invalid_player_state_from_file() throws IOException {
        String FILE_PATH = "invalid_player_data.txt";
        FileWriter playerFileWriter = new FileWriter(FILE_PATH);

        String result = "adfsgqwersdfg" +
                "\n" +
                "asdfasdfqwegsdfg";

        playerFileWriter.write(result);
        playerFileWriter.close();

        Player invalid = new Player("invalid");
        FileHandlingImpl fileHandling = new FileHandlingImpl(invalid);

        Exception exception = assertThrows(IllegalArgumentException.class, fileHandling::readPlayerState);

        String expectedMessage = "Invalid file. Player balance must be an integer.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }*/
}
