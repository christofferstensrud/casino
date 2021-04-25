

import games.SlotsMachine;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import player.Player;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField inputBet;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    public SlotsMachine slotsMachine = new SlotsMachine();
    public Player player;

    @FXML
    public void initialize() {
        if(slotsMachine.getRegisteredPlayer() == null){
            player = new Player("player", 50);
            slotsMachine.setRegisteredPlayer(player);
        }
    }

    public void getBet(ActionEvent e) {
        //System.out.println(inputBet.getText());
        //System.out.println(player.getName());

        System.out.println(slotsMachine.play(Integer.parseInt(inputBet.getText())));
    }

    public void gotoMain(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoSlots(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Slots.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void gotoBlackjack(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Blackjack.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playSlots(ActionEvent event) throws IOException {
        String betAmount = inputBet.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Slots.fxml"));
        root = loader.load();


    }

    public void playBlackJack(ActionEvent e) {
        //todo
    }

    public void updateResults(){
        //TODO Path til symboler i SlotsDefaults. Finne bilder, Exit button, Balance visuelt, Resizing (set resizable false)
    }
}
