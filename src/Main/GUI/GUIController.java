package Main.GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import Main.Parser.*;
import Main.Main.*;
import Main.Commands.*;
import Main.CommandsInterface.*;
import Main.Items.*;
import Main.Characters.*;
import Main.Rooms.*;
import javafx.scene.layout.FlowPane;

public class GUIController {

    // Game components
    private Parser parser = new Parser();
    private  ZorkULGame game = new ZorkULGame();





    // GUI elements
    @FXML
    private TextArea outputArea;

    @FXML
    private Label inventorySlot1;

    @FXML
    private FlowPane inventoryPane;


    @FXML
    private ImageView imageView;

    @FXML
    private Label currentRoomLabel;

    @FXML
    private Label memoryProgress;


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


    private void inventoryGUI() {
        inventoryPane.getChildren().clear();

        inventoryPane.setHgap(15);   // space between icons left–right
        inventoryPane.setVgap(15);   // space between icons top–bottom
        inventoryPane.setPrefWrapLength(200); // optional: controls wrapping

        for (Item item : game.getPlayer().getInventory().getAllItems()) {
            String path = item.getImagePath();
            if (path != null) {
                ImageView icon = new ImageView(new Image(getClass().getResource(path).toExternalForm()));
                icon.setFitWidth(50);
                icon.setFitHeight(50);
                icon.setPreserveRatio(true);

                //Optional click handler
                icon.setOnMouseClicked(e -> {
                    //outputArea.appendText("You dropped: " + item.getName() + "\n");
                    handleButtonCommand("drop " + item.getName().toLowerCase());
                });


                inventoryPane.getChildren().add(icon);
            }
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
        inventoryGUI();
        memoryRecovered();

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
        String guiRoom = game.getPlayer().getCurrentRoom().getName().toLowerCase();

        switch(guiRoom) {

            case "church":
                imageView.setImage(new Image(getClass().getResource("/images/Church.jpeg").toExternalForm()));
                break;

            case "cemetery":
                imageView.setImage(new Image(getClass().getResource("/images/Cemetary.jpeg").toExternalForm()));
                break;
            case "church interior":
            imageView.setImage(new Image(getClass().getResource("/images/ChurchInterior.jpeg").toExternalForm()));
            break;

            case "florist store":
                imageView.setImage(new Image(getClass().getResource("/images/FloristImage.jpeg").toExternalForm()));
                break;

            case "motel room":
                imageView.setImage(new Image(getClass().getResource("/images/MotelRoom.jpeg").toExternalForm()));
                break;

            case "motel lobby":
                imageView.setImage(new Image(getClass().getResource("/images/MotelLobby.jpeg").toExternalForm()));
                break;

            case "pin":
                imageView.setImage(new Image(getClass().getResource("/images/PinCode.jpeg").toExternalForm()));
                break;

            case "bench":
                imageView.setImage(new Image(getClass().getResource("/images/PixelBench.png").toExternalForm()));
                break;

            case "warehouse":
                imageView.setImage(new Image(getClass().getResource("/images/WarehouseStranger.PNG").toExternalForm()));
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
        // You might modify this to take a selected item or pass an argumenta
        handleButtonCommand("take");
        inventoryGUI();
    }

    @FXML
    private void memoryRecovered() {
        int answer = game.getPlayer().getJournal().memoryEntrySize();
        memoryProgress.setText(answer + " / 8 memories");
    }

    @FXML
    private void drop() {
        handleButtonCommand("drop");
        inventoryGUI();
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
        outputArea.appendText(game.getPlayer().getCurrentRoom().getLongDescription() + "\n");
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
        inventoryGUI();
        setCurrentRoomLabel();
        memoryRecovered();






    }

    private void setCurrentRoomLabel() {
        currentRoomLabel.setText(game.getPlayer().getCurrentRoom().getName());
    }

}

