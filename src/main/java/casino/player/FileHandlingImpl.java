package casino.player;

import casino.interfaces.FileHandlingInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandlingImpl implements FileHandlingInterface {

    private final String FILE_PATH;
    private final Player player;

    public FileHandlingImpl(Player player){
        this.player = player;
        this.FILE_PATH = player.getName() + "_player_data.txt";
    }

    @Override
    public Player readPlayerState() throws IOException {
        List<String> playerData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                playerData.add(line);
            }
        } catch (IOException e){
            printPlayerState();
            throw new FileNotFoundException("Datafile "+FILE_PATH+" for player "+player.getName()+" does not exist.");
        }

        String name = playerData.get(0);
        if(name.isBlank()) {
            throw new IllegalArgumentException("Invalid file. Player name cannot be blank.");
        }

        if (playerData.get(1).contains("[^0-9]")) {
            throw new IllegalArgumentException("Invalid file. Player balance must be an integer.");
        }else {
            int balance = Integer.parseInt(playerData.get(1));

            if (player.isNegative(balance)) {
                throw new IllegalArgumentException("Invalid file. Player balance must be positive.");
            }else {
                return new Player(name, balance);
            }
        }
    }

    @Override
    public boolean printPlayerState() {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);

            String playerData = player.getName() +
                    "\n" +
                    player.getBalance();

            fw.write(playerData);
            fw.close();


            return true;

        }catch (IOException e){
            e.printStackTrace();
        }

        return false;
    }
}
