package casino;

import casino.games.slot.Slot;
import casino.player.FileHandlingImpl;
import casino.player.Player;

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
    private TextField betTextField;
    @FXML
    private TextField balanceTextField = new TextField();
    @FXML
    private Text multiplierText = new Text();
    @FXML
    private Text resultText = new Text();


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
        if(slotsMachine.play(Integer.parseInt(betTextField.getText()))){
            ArrayList<ImageView> imageViewsList = new ArrayList<>(Arrays.asList(FirstSlot, SecondSlot, ThirdSlot));
            for (int i = 0; i < imageViewsList.size(); i++) {
                imageViewsList.get(i).setImage(new Image(getClass()
                        .getResourceAsStream(slotsMachine
                                .getReelResults()[i]
                                .getPath())));
            }

            balanceTextField.setText("Balance: $" + player.getBalance());
            multiplierText.setText("Multiplier: " + slotsMachine.getMultiplier() + "x");
            resultText.setText(slotsMachine.getResultCommentText());
        } else {
            resultText.setText("Balance too low!");
        }
    }

    /**
     * Scene switch to main menu
     *
     * @param event Button click
     */
    public void gotoMain(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("App.fxml"));
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
     * Print player state to file. (Name, wallet balance)
     * Read and import player state from file.
     * Updates on screen comment and wallet amount.
     */
    public void writePlayerState() {
        fileHandling.printPlayerState();
        resultText.setText("Printed player info to file.");
    }

    public void readPlayerState() throws IOException {
        player.updatePlayer(fileHandling.readPlayerState());
        balanceTextField.setText("Wallet: " + player.getBalance());
        resultText.setText("loaded player state from file.");
    }

    /**
     * Close application
     *
     */
    public void logout() {
        stage = (Stage) mainPane.getScene().getWindow();
        stage.close();
    }
}
