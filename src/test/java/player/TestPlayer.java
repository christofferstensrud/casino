package player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayer {

    private Player player;

    @BeforeEach
    public void setUp(){
       // player = new Player("test");
    }

    @Test
    public void test_new_player() {
        Player player_only_name = new Player("test");

        assertEquals("test", player_only_name.getName());
        assertEquals(0, player_only_name.getBalance(), 0);
    }

    @Test
    public void test_new_player_blank_name() {
        Player[] player = new Player[2];

        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    player[0] = new Player("");
                    player[1] = new Player("",100);
                });

        String expectedMessage = "Players name must not be blank.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertNull(player[0]);
        assertNull(player[1]);

    }

    @Test
    public void test_new_player_0_bal() {
        Player player_only_name = new Player("test");
        Player player_bal_0 = new Player("test",0);

        assertEquals(player_only_name.getBalance(), player_bal_0.getBalance(),0);
    }

   @Test
    public void test_new_player_neg_bal() {
        Player[] player = new Player[1];

        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    player[0] = new Player("test",-100);
                });

        String expectedMessage = "Players balance must be positive.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertNull(player[0]);
    }


    @Test
    public void test_add_to_balance() {
        Player player = new Player("test");
        player.addToBalance(10);
        player.addToBalance(999);

        assertEquals(1009, player.getBalance(),0);

        player.addToBalance(0);
        assertEquals(1009, player.getBalance(),0);
    }

    @Test
    public void test_add_to_balance_neg() {
        Player player = new Player("test",100);

        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    player.addToBalance(-100);;
                });

        String expectedMessage = "Value to be added must be positive.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(100, player.getBalance(),0);
    }


    @Test
    public void test_remove_from_balance() {
        Player player = new Player("test",100);

        player.removeFromBalance(99);
        assertEquals(1, player.getBalance(),0);

        player.removeFromBalance(0);
        assertEquals(1, player.getBalance(),0);
    }

    @Test
    public void test_remove_from_balance_greater_than() {
        Player player = new Player("test",10);

        Exception exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    player.removeFromBalance(11);;
                });

        String expectedMessage = "Value to be removed cannot be greater than the players balance.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(10, player.getBalance(),0);
    }
}
