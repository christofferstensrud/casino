import games.slot.Slot;
import player.Player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

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
    private ImageView menuImage1 = new ImageView();
    @FXML
    private ImageView menuImage2 = new ImageView();

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

    /**
     * Handles bet input from user and spins the slot machine.
     * Displays images in slots
     */
    @FXML
    public void spin() {
        ArrayList<ImageView> imageViewsList = new ArrayList<>(Arrays.asList(FirstSlot, SecondSlot, ThirdSlot));

        slotsMachine.play(Integer.parseInt(inputBet.getText()));

        for (int i = 0; i<3; i++) {
            imageViewsList.get(i).setImage(new Image(getClass()
                    .getResourceAsStream(slotsMachine
                            .getReelResults()[i]
                            .getPath())));
        }

        wallet.setText("Wallet: " + Double.toString(player.getBalance()));
        multip.setText("Multiplier: " + Double.toString(slotsMachine.getMultiplier()) + "x");
        winComment.setText(slotsMachine.getWinCom());
    }

    /**
     * Scene switch to main menu
     *
     * @param event Button click
     */
    public void gotoMain(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Scene switch to slot game
     *
     * @param event Button click
     */
    public void gotoSlots(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Slots.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Scene switch to Blackjack game. [NOT IN USE]
     *
     * @param event Button click
     */
    public void gotoBlackjack(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Blackjack.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playBlackJack(ActionEvent e) {
        //todo
    }

    /**
     * Close application
     *
     * @param event Button click
     */
    public void logout(ActionEvent event) {
        stage = (Stage) mainPane.getScene().getWindow();
        stage.close();
    }
}
