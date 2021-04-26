import games.slot.Slot;
import player.FileHandlingImpl;
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

import java.io.IOException;
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
    private ImageView menuImage1;
    @FXML
    private ImageView menuImage2;

    @FXML
    Stage stage;
    @FXML
    Scene scene;
    @FXML
    Parent root;

    private Slot slotsMachine = new Slot();
    private Player player;
    private FileHandlingImpl fileHandling;


    @FXML
    public void initialize() throws IOException {
        if(slotsMachine.getRegisteredPlayer() == null){
            player = new Player("player", 100);
            slotsMachine.setRegisteredPlayer(player);
            fileHandling = new FileHandlingImpl(player);
            readPlayerState();
        }


    }

    /**
     * Handles bet input from user and spins the slot machine.
     * Displays images in slots
     */
    @FXML
    public void spin() {
        if(slotsMachine.play(Integer.parseInt(inputBet.getText()))){
            ArrayList<ImageView> imageViewsList = new ArrayList<>(Arrays.asList(FirstSlot, SecondSlot, ThirdSlot));
            for (int i = 0; i<3; i++) {
                imageViewsList.get(i).setImage(new Image(getClass()
                        .getResourceAsStream(slotsMachine
                                .getReelResults()[i]
                                .getPath())));
            }

            wallet.setText("Wallet: " + player.getBalance());
            multip.setText("Multiplier: " + slotsMachine.getMultiplier() + "x");
            winComment.setText(slotsMachine.getWinCom());
        } else {
            winComment.setText("Balance too low!");
        }
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
    public void gotoSlots(ActionEvent event) throws IOException {
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
        player.updatePlayer(fileHandling.readPlayerState());
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

    /*public void playBlackJack(ActionEvent e) {
        //todo
    }*/

    /**
     * Print player state to file. (Name, wallet balance)
     * Read and import player state from file.
     * Updates on screen comment and wallet amount.
     */
    public void printPlayerState() {
        fileHandling.printPlayerState(player);
        winComment.setText("Printed player info to file.");
    }

    public void readPlayerState() throws IOException {
        player.updatePlayer(fileHandling.readPlayerState());
        wallet.setText("Wallet: " + player.getBalance());
        winComment.setText("loaded player state from file.");
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
