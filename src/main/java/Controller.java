import games.slot.Slot;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import player.Player;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    ImageView FirstSlot;
    @FXML
    ImageView SecondSlot;
    @FXML
    ImageView ThirdSlot;

    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField inputBet;
    @FXML
    private TextField wallet = new TextField();
    @FXML
    private Text multip = new Text();
    @FXML
    private Text winComment = new Text();
    @FXML
    Stage stage;
    @FXML
    Scene scene;
    @FXML
    Parent root;

    public Slot slotsMachine = new Slot();
    public Player player;

    @FXML
    public void initialize() {
        if(slotsMachine.getRegisteredPlayer() == null){
            player = new Player("player", 100);
            slotsMachine.setRegisteredPlayer(player);
        }
    }

    @FXML
    public void getBet() {
        if(inputBet.getText() != "") { //TODO Fix validation
            slotsMachine.play(Integer.parseInt(inputBet.getText()));
        } else {
            multip.setText("Bet a valid number!");
        }

        Image slot1im = new Image(getClass().getResourceAsStream(slotsMachine.getReelResults()[0].getPath()));
        Image slot2im = new Image(getClass().getResourceAsStream(slotsMachine.getReelResults()[1].getPath()));
        Image slot3im = new Image(getClass().getResourceAsStream(slotsMachine.getReelResults()[2].getPath()));

        FirstSlot.setImage(slot1im);
        SecondSlot.setImage(slot2im);
        ThirdSlot.setImage(slot3im);

        wallet.setText("Wallet: " + Double.toString(player.getBalance()));
        winComment.setText(slotsMachine.getWinCom());
        multip.setText("Multiplier" + Double.toString(slotsMachine.getMultiplier()) + "x");

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

    public void logout(ActionEvent event) {
        stage = (Stage) mainPane.getScene().getWindow();
        stage.close();
    }
}
