import games.blackjack.Blackjack;
import games.slot.Slot;
import javafx.scene.control.TextField;
import player.Player;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.util.Arrays;

public class Main extends Application{

    //Setup for slots

    //slotsMachine.setRegisteredPlayer(player);



    public static void main(String[] args) {
        launch(args);



        /*Player pTest = new Player("Test Testenson");
        pTest.addToBalance(30);

        SlotsMachine slotsMachine = new SlotsMachine();
        slotsMachine.setRegisteredPlayer(pTest);
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));
        System.out.println(slotsMachine.play(5));

        Blackjack bj = new Blackjack();
        bj.setRegisteredPlayer(pTest);
        bj.generateSortedDeck();
        bj.generateMultipleDecks(8);
        System.out.println(bj.playableDeck);
        bj.start();*/







        /*Random functions testing*/
        //slotsMachine.randomXTimes(100);
        //System.out.println(Arrays.toString(RandomFunc.randomBetweenMultipleTimes(0, 10, 25)));

    }



    @Override
    public void start(Stage stage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }


        //Set app icon and title
        FileInputStream iconInput = new FileInputStream("src\\main\\resources\\icon.png");
        Image icon = new Image(iconInput);
        stage.getIcons().add(icon);
        stage.setTitle("Casino");






    }
}
