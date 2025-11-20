import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class GUIController {

    // Game components
    private Parser parser = new Parser();
    private  ZorkULGame game = new ZorkULGame();





    // GUI elements
    @FXML
    private TextArea outputArea;






    @FXML
    private ImageView imageView;

    @FXML
    private Label currentRoomLabel;


    @FXML
    private TextField inputArea;

    @FXML
    private void handleInput() {
        String text = inputArea.getText();
        if (!text.isEmpty()) {
            //outputArea.appendText(text + "\n");
            handleButtonCommand(text);
            inputArea.clear();
        }
    }






    private void handleButtonCommand(String commandText) {
        // Display what the player "typed"
        outputArea.clear();
        outputArea.appendText("> " + commandText + "\n");

        // Parse and execute the command
        Command command = parser.getCommand(commandText);
        game.processCommand(command);
        setCurrentRoomLabel();
        setRoomImage();

        // Display game output
        outputArea.appendText(game.getGameOutput() + "\n");

        outputArea.setScrollTop(Double.MAX_VALUE);
    }






    @FXML
    private void goNorth() {
        handleButtonCommand("go north");

    }

    @FXML
    private void goSouth() {
        handleButtonCommand("go south");
    }

    @FXML
    private void goEast() {
        handleButtonCommand("go east");
    }

    @FXML
    private void goWest() {
        handleButtonCommand("go west");
    }

    @FXML
    private void search() {
        handleButtonCommand("search");
    }


    @FXML
    private void interact() {
        handleButtonCommand("interact");
        outputArea.clear();
    }

    @FXML
    private void readJournal() {
        Journal journal = game.getJournal();
        String memoryText = journal.readMemoryEntry();
        outputArea.clear();
        outputArea.appendText("Journal: \n" + memoryText + "\n");
    }

    @FXML
    private void setRoomImage() {
        String guiRoom = game.player.getCurrentRoom().getName().toLowerCase();

        switch(guiRoom) {

            case "bench":
                imageView.setImage(new Image(getClass().getResource("/images/PixelBench.png").toExternalForm()));
                break;

            case "warehouse":
                imageView.setImage(new Image(getClass().getResource("/images/Warehouse.jpeg").toExternalForm()));
                break;

            case "police station":
                imageView.setImage(new Image(getClass().getResource("/images/PoliceStation.jpeg").toExternalForm()));
                break;


            case "alley":
                imageView.setImage(new Image(getClass().getResource("/images/Alley.jpeg").toExternalForm()));
                break;


            case "store":
                imageView.setImage(new Image(getClass()
                        .getResource("/images/Store.jpeg").toExternalForm()));
                break;




        }




    }

    @FXML
    private void take() {
        // You might modify this to take a selected item or pass an argument
        handleButtonCommand("take");
    }

    @FXML
    private void drop() {
        handleButtonCommand("drop");
    }

    @FXML
    private void inventory() {
        handleButtonCommand("inventory");
    }

    @FXML
    private void help() {
        handleButtonCommand("help");
    }

    @FXML
    private void getRoomInfo() {
        outputArea.appendText(game.player.getCurrentRoom().getLongDescription() + "\n");
    }

    @FXML
    private void quit() {
        handleButtonCommand("quit");
    }
    @FXML
    private void save() {
        handleButtonCommand("save");
    }
    @FXML
    private void load() {
        handleButtonCommand("load");
    }


    @FXML
    private void initialize() {
        game.printWelcome();
        outputArea.appendText(game.getGameOutput() + "\n");
        inputArea.setOnAction(event -> handleInput());

        setCurrentRoomLabel();






    }

    private void setCurrentRoomLabel() {
        currentRoomLabel.setText(game.player.getCurrentRoom().getName());
    }

}

