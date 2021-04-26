package player;

import interfaces.FileHandling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandlingImpl implements FileHandling {

    private final String FILE_NAME;

    public FileHandlingImpl(Player player){
        FILE_NAME = player.getName() + "_player_data.txt";
    }

    @Override
    public Player readPlayerState() throws IOException {
        //FileReader playerFileReader = new FileReader(FILE_NAME);
        List<String> playerData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                playerData.add(line);
            }
        }

        String name = playerData.get(0);
        double balance = Double.parseDouble(playerData.get(1));

        return new Player(name, balance);
    }

    @Override
    public boolean printPlayerState(Player player) {
        try {
            FileWriter playerFileWriter = new FileWriter(FILE_NAME);
            //File playerFile = new File(FILE_NAME);

            String result = player.getName() +
                    "\n" +
                    player.getBalance();

            playerFileWriter.write(result);
            playerFileWriter.close();


            //playerFile.getPath();
            return true;

        }catch (IOException e){
            e.printStackTrace();
        }

        return false;
    }
}
