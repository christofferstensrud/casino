import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


import java.io.FileInputStream;


public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Launch FX GUI. Sets application title and icon
     *
     * @param stage stage
     * @throws Exception If error in FX launch or load
     */
    @Override
    public void start(Stage stage) throws Exception {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

        FileInputStream iconInput = new FileInputStream("src\\main\\resources\\icon.png");
        Image icon = new Image(iconInput);
        stage.getIcons().add(icon);
        stage.setTitle("Casino");
    }
}
