package player;

import interfaces.FileHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileHandlingImpl implements FileHandling {

    private final String FILE_NAME;
    private final Player player;

    public FileHandlingImpl(Player player){
        this.player = player;
        this.FILE_NAME = player.getName() + "_player_data.txt";
    }

    @Override
    public Player readPlayerState() throws IOException {
        List<String> playerData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                playerData.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }

        String name = playerData.get(0);
        double balance = Double.parseDouble(playerData.get(1));

        return new Player(name, balance);
    }

    @Override
    public boolean printPlayerState() {
        try {
            FileWriter playerFileWriter = new FileWriter(FILE_NAME);

            String result = player.getName() +
                    "\n" +
                    player.getBalance();

            playerFileWriter.write(result);
            playerFileWriter.close();


            return true;

        }catch (IOException e){
            e.printStackTrace();
        }

        return false;
    }
}
