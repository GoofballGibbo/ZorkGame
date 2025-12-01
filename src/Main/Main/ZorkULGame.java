package Main.Main;


/* This game is a classic text-based adventure set in a university environment.
 The player starts outside the main entrance and can navigate through different rooms like a
 lecture theatre, campus pub, computing lab, and admin office using simple text commands (e.g., "go east", "go west").
 The game provides descriptions of each location and lists possible exits.

Key features include:
Room navigation: Moving among interconnected rooms with named exits.
Simple command parser: Recognizes a limited set of commands like "go", "help", and "quit".
Player character: Tracks current location and handles moving between rooms.
Text descriptions: Provides immersive text output describing the player's surroundings and available options.
Help system: Lists valid commands to guide the player.
Overall, it recreates the classic Zork interactive fiction experience with a university-themed setting,
emphasizing exploration and simple command-driven gameplay
*/

import java.util.*;
import java.io.*;
import Main.Characters.*;
import Main.Commands.*;
import Main.CommandsInterface.Command;
import Main.CommandsInterface.CommandHandler;
import Main.Parser.*;
import Main.Rooms.*;
import Main.Items.*;
import Main.Audio.*;

public class ZorkULGame{
    private Parser parser;
    protected Player player;
    private StringBuilder sb;
    private Map<String, CommandHandler> commandHandlers = new HashMap<>();
    protected HashMap<String, Room> allRooms;
    protected String fileName;
    private AudioPlayer audio;
    private ZorkULGame game;
    private Journal journal;
    private MemoryBlock benchMemory;
    private MemoryBlock storeMemory;
    private MemoryBlock alleyMemory;
    private MemoryBlock policeMemory;
    private MemoryBlock motelLobbyMemory;
    private MemoryBlock motelRoomMemory;
    private MemoryBlock warehouseMemory;
    private MemoryBlock churchInteriorMemory;
    protected Room bench;
    protected Room store;
    protected Room alley;
    protected Room policeStation;
    protected Room motelLobby;
    protected Room motelRoom;
    protected Room warehouse;
    protected Room pinCode;
    protected Room floristStore;
    protected Room church;
    protected Room churchInterior;
    protected Room cemetary;




    public ZorkULGame() {
        allRooms = new HashMap<>();
        journal = new Journal();
        createRooms();
        parser = new Parser();
        sb = new StringBuilder();
        fileName = "Savegame.dat";
        initCommands();

        audio = new AudioPlayer("/AudioFiles/Background.wav");
        audio.setVolume(-12.0f);
        audio.playLoop();
    }



    public void createRooms() {


        //Items

        Item motelKey = new Item("Motel key", "A small brass key. It has something engraved on it - Silver Lantern Motel", "/ItemImages/MotelKey.png");
        Item pocket_watch = new Item("Pocket watch", "A ticking pocket watch engraved with initials. It seems peculiar.", "/ItemImages/Pocketwatch.png");
        Item sandwich = new Item("Sandwich", "An ordinary chicken and tomato sandwich", "/ItemImages/Sandwich.png");
        Item photoID = new Item("Photo", "A worn out photo of you", "/ItemImages/Photo.png");
        Item crumpledBill = new Item("20$ bill", "A crumpled 20$ bill", "/ItemImages/20bill.png");
        Item crispMoney = new Item("€5 bill", "A fresh €5 euro bill", "/ItemImages/5bill.png");
        Item flowers = new Item("White Lillies", "A beautiful bouquet of white lillies. Simple and austere but execeptionally beautiful", "/ItemImages/Flower.png");
        Item churchKey = new Item("Church key", "A rusty key - it has a cross on it - it might be worth finding out if it's important", "/ItemImages/ChurchKey.png");

        //Room outside, theatre, pub, lab, office, studentcentre, bench, store;


        // create rooms
        bench = new Room("Bench","You wake on a bench beneath a dying streetlight.\nA name is scrawled on your arm, but it isn’t yours.\nYour head throbs — memories flash, fade, vanish.\nYou’re not sure what you’ve lost... only that someone took it.");

        motelLobby = new Room("Motel Lobby","The lobby is dimly lit; carpet threadbare and faded.\n" +
                "A neon \"Vacancy\" sign flickers weakly overhead.\n" +
                "Room 23 stands closed, ordinary yet heavy with importance.\n" + "The manager peers at you from behind the counter");

        alley = new Room("Alley","A narrow alley between crumbling buildings.\n" +
                "Trash litters the ground, smells of rust and damp fill the air.\n" +
                "A figure stirs in the shadows… a man wrapped in layers of rags.");

        policeStation = new Room("Police Station","The station smells of paper, disinfectant, and stale coffee.\n" +
                "Metal drawers line the walls; one seems slightly out of place.\n" +
                "A weary clerk watches you, suspicious, but curious.");

        motelRoom = new Room("Motel room", "The door creaks as you enter.\n" +
                "Dust motes float in the weak sunlight filtering through torn curtains.\n" +
                "A journal lies open on the table; words smudged with tears and time.\n" +
                "Fragments of memory whisper here, but the picture is incomplete.");

        store = new Room("Store","The flicker of fluorescent lights bathes the convenience store in a tired, sickly glow. \n" +
                "Rows of dusty shelves lean under the weight of forgotten snacks and canned goods.\n" +
                "Behind the counter, the store keeper watches you — expression unreadable, ledger open,\n" +
                "as though he's been waiting for you to walk through the door again.");

        pinCode = new Room("Pin", "pincode room");

        warehouse = new Room("Warehouse", "The warehouse smells of oil and metal. Empty crates cast long shadows under harsh overhead lights.\n" +
                "The air feels thick with anticipation, as if the walls themselves remember what you have forgotten. A figure lingers near the far corner, half-hidden in shadow. " +
                "Their face is obscured, movements deliberate and slow, and when they glance at you, it’s with eyes that seem to know more than they should. " +
                "You can’t tell if they are friend or foe, but their presence makes the fleeting clarity in this room feel even more fragile. " +
                "Here, everything you’ve gathered comes together, yet the stranger’s silence reminds you that some pieces of the puzzle may never be yours to hold.");

        floristStore = new Room("Florist Store", "The flower shop is bright, almost too bright, petals spilling from shelves in every direction. The scent should be pleasant, but it stirs something sharp in your skull. Behind the counter stands a woman in a pale green apron, hands stained with pollen. Her smile freezes when she sees you—recognition flickering in her eyes long before it reaches yours. For a moment, you can’t tell if she’s relieved… or frightened.");
        church = new Room("Church", "An old church. It feels like something important was left behind here.", churchKey, null);
        churchInterior = new Room("Church Interior", "A large statue of a some idol stands here. You can sense there's something here for you to find.");

        cemetary = new Room("Cemetery", "A place filled with dozens of lost souls. A part of you was left here. One of the tombstones elicits a feeling of sadness in you. Maybe you should pay respect to it", flowers, churchKey);



        //Memories

        benchMemory = new MemoryBlock("You wake up on this bench, the streetlight flickering above. The sensation of being watched… but by who?");
        storeMemory = new MemoryBlock("The smell of old snacks triggers a flash: a face you vaguely recognize smiles at you behind the counter.");
        alleyMemory = new MemoryBlock("A man wrapped in rags whispers your name. Something about a meeting at midnight.");
        policeMemory = new MemoryBlock("A drawer slightly ajar… you remember hiding something important here long ago.");
        motelLobbyMemory = new MemoryBlock("The neon light flickers. Room 23… your old room. You recall a promise made here.");
        motelRoomMemory = new MemoryBlock("Dust motes dance in the sunlight. Fragments of a journal you once wrote float into your mind.");
        warehouseMemory = new MemoryBlock("Crates stacked high. You see a logo that sparks a memory of someone guiding you here before…");
        churchInteriorMemory = new MemoryBlock("You feel a chill go up your spine. There's something amiss here. ");


        store.addItem(pocket_watch);


        List<Item> clerkRewards = new ArrayList<>();
        clerkRewards.add(motelKey);
        clerkRewards.add(crispMoney);

        //NPC initialisation

        //==============================================
        //===============================================
        Clerk clerk = new Clerk(policeStation, photoID, motelKey, crispMoney, policeMemory);


        clerk.addDialogue("The clerk eyes you carefully. 'I can't just hand this over to anyone…'");
        clerk.addDialogue("You notice a small key glinting on the counter behind him.");
        clerk.addDialogue("'If you want that key, you'll need to show me some identification…'");
        clerk.addDialogue(clerk.itemRequirement(photoID));

        policeStation.addNPC(clerk);

        List<Item> vagrantRewards = new ArrayList<>();
        vagrantRewards.add(photoID);


        Vagrant vagrant = new Vagrant( alley, sandwich, photoID, alleyMemory);

        vagrant.addDialogue("‘Got anything to eat?’ he croaks, eyes glinting under the flicker of a streetlamp.");
        vagrant.addDialogue("‘A bite for a bit of truth, yeah? I can tell you things.’");
        vagrant.addDialogue(vagrant.itemRequirement(sandwich));

        alley.addNPC(vagrant);

        MotelManager motelManager = new MotelManager(motelLobby, motelKey, motelRoom, motelLobbyMemory);

        motelManager.addDialogue("‘Back again, huh?’ she says slowly. ‘You look… different this time.’");
        motelManager.addDialogue("Her eyes flick toward a small box on the shelf.");
        motelManager.addDialogue("‘Tell me — you still have the key, don’t you?’");
        motelManager.addDialogue(motelManager.itemRequirement(motelKey));


        motelLobby.addNPC(motelManager);

        List<Item> storeRewards = new ArrayList<>();
        storeRewards.add(sandwich);
        storeRewards.add(pocket_watch);

        StoreKeeper storeKeeper = new StoreKeeper(store, crumpledBill, sandwich, storeMemory);
        storeKeeper.addDialogue("The store keeper looks up from a worn ledger.");
        storeKeeper.addDialogue("'Back again, are you?' he asks, squinting. 'You always come by when the nights are long.'");
        storeKeeper.addDialogue("He hesitates, searching your face. 'You… don’t remember me, do you?'");
        storeKeeper.addDialogue("The hum of the refrigerator grows louder.");
        storeKeeper.addDialogue("'Well, no matter. You look hungry. Want to buy something? A sandwich, maybe?'");
        storeKeeper.addDialogue(storeKeeper.itemRequirement(crumpledBill));

        store.addNPC(storeKeeper);


        Florist florist = new Florist(floristStore, crispMoney,flowers, null);


        florist.addDialogue(florist.getName());
        florist.addDialogue("Hello, are you looking for something to buy?");
        florist.addDialogue(florist.itemRequirement(crispMoney));

        floristStore.addNPC(florist);



        //==============================================

        bench.setExit("north", store);
        bench.setExit("east", motelLobby);

        store.setExit("south", bench);
        store.setExit("north", floristStore);

        floristStore.setExit("south", store);
        floristStore.setExit("east", church);

        church.setExit("west", floristStore);
        church.setExit("north", alley);
        church.setExit("south", cemetary);

        cemetary.setExit("north", church);

        alley.setExit("east", motelLobby);
        alley.setExit("north", policeStation);
        alley.setExit("south", pinCode);

        pinCode.setExit("north", alley);

        policeStation.setExit("south", alley);

        motelLobby.setExit("south", alley);
        motelLobby.setExit("west", bench);

       // motelLobby.setExit("east", motelRoom);

        //motelRoom.setExit("west", motelLobby);


        allRooms.put(bench.getName(), bench);
        allRooms.put(alley.getName(), alley);
        allRooms.put(policeStation.getName(), policeStation);
        allRooms.put(store.getName(), store);
        allRooms.put(motelLobby.getName(), motelLobby);
        allRooms.put(motelRoom.getName(), motelRoom);
        allRooms.put(warehouse.getName(), warehouse);
        allRooms.put(floristStore.getName(), floristStore);
        allRooms.put(church.getName(), church);
        allRooms.put(cemetary.getName(), cemetary);
        allRooms.put(churchInterior.getName(), churchInterior);

/*
 outside = new Room("outside the main entrance of the university");
 theatre = new Room("in a lecture theatre");
 pub = new Room("in the campus pub");
 lab = new Room("in a computing lab");
 office = new Room("in the computing admin office");


 // initialise room exits
 outside.setExit("east", theatre);
 outside.setExit("south", lab);
 outside.setExit("west", pub);
 outside.setExit("north", bench);
 bench.setExit("north", store);


 theatre.setExit("west", outside);

 pub.setExit("east", outside);

 lab.setExit("north", outside);
 lab.setExit("east", office);

 office.setExit("west", lab);


*/
        // create the player character and start outside
        player = new Player("player", bench, journal);
        player.addToInventory(crumpledBill);
        player.addToInventory(journal);
        journal.addMemory(benchMemory);;


    }



    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        sb.append("Thank you for playing. Goodbye.\n");
        //System.out.println("Thank you for playing. Goodbye.\n");
    }

    public Journal getJournal() {
        return journal;

    }

    public void printWelcome() {

        sb.append(player.getCurrentRoom().getLongDescription()).append("\n");
        sb.append("\n");
        sb.append("Welcome to Memento!\n");

        sb.append("Type 'help' if you need help.\n");
        //System.out.print("Welcome to Memento!\n");
        //System.out.println("Type 'help' if you need help.\n");
        //System.out.println(player.getCurrentRoom().getLongDescription());
    }
    public String getGameOutput() {
        String output = sb.toString();
        sb.setLength(0);
        return output;
    }


    public void clearGameOutput() {
        sb.setLength(0);
    }


    public boolean processCommand(Command command) {
        String commandWord = command.getCommandWord();
        String[] input = command.getArgs();
        Room currentRoom = player.getCurrentRoom();


        // If commandWord is null, let normal handling continue


        if (commandWord == null) {
            sb.append("I don't know what you mean.\n");
            return false;
        }

        commandWord = commandWord.toLowerCase().trim();



        CommandHandler handler = commandHandlers.get(commandWord);

        if ("quit".equals(commandWord)) {
            player.setQuit(true);
            return true;
        }


        if (handler == null) {
            //System.out.println("I don't know what you mean.\n");
            sb.append("I don't know what you mean.\n");
            return false;
        }
        try {
            String result = handler.execute(command, player);
            sb.append(result).append("\n");


            if (player.getCurrentRoom() == motelRoom) {
                player.getJournal().addMemory(motelRoomMemory);
            }

            Room current = player.getCurrentRoom();


            if (current == church) {
                Item key = church.getRequiredItem();


                // Check both inventory and room items (in case key was dropped)
                boolean hasKey = player.hasItemInInventory(key) || current.containsItems(key);

                System.out.println(player.hasItemInInventory(key));
                System.out.println(current.containsItems(key));

                if (hasKey) {
                    //System.out.println("debug check1:");
                    sb.append("You use the church key to unlock the church interior.\n");

                    // Remove the key from inventory or floor
                    if (player.hasItemInInventory(key)) player.removeFromInventory(key);
                    if (current.containsItems(key)) current.removeItems(key);

                    player.setCurrentRoom(churchInterior);

                    // Unlock the interior
                    church.setExit("east", churchInterior);
                    churchInterior.setExit("west", church);
                }
            }

            if (player.getCurrentRoom() == cemetary) {
                if (player.getCurrentRoom().containsItems(cemetary.getRequiredItem())) {
                    player.addToInventory(cemetary.getRewardItem());
                    sb.append("Recieved: ").append(cemetary.getRewardItem().getName()).append("\n");
                }
            }

            if (player.getCurrentRoom() == churchInterior) {
                player.getJournal().addMemory(churchInteriorMemory);
            }


            if (player.getCurrentRoom() == warehouse) {
                journal.addMemory(warehouseMemory);
                sb.append(gameEnding()).append("\n");
                player.setQuit(true);  //

            }
        } catch (Exception e) {
            //System.out.println("Invalid command: " + commandWord);
            e.printStackTrace();
            sb.append("Invalid command: ").append(commandWord).append("\n");


            sb.append("I don't know what you mean.\n");
        }
        return player.hasQuit();


    }

    public String printHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("Your command words are: ");
        sb.append(parser.showCommands());
        return sb.toString();
    }


    public void initCommands() {
        commandHandlers.put("go", new GoCommand());
        commandHandlers.put("interact", new InteractCommand());
        commandHandlers.put("inventory", new InventoryCommand());
        commandHandlers.put("take", new TakeItemCommand());
        commandHandlers.put("search", new SearchCommand());
        commandHandlers.put("inspect", new TakeItemCommand.InspectCommand());
        commandHandlers.put("drop", new DropCommand());
        commandHandlers.put("save", new SaveCommand(this));
        commandHandlers.put("load", new LoadCommand(this));
        commandHandlers.put("code", new CodeCommand("4815", allRooms));
        commandHandlers.put("help", new HelpCommand(this));
        commandHandlers.put("cheat", new CheatCommand(this));

        //commandHandlers.put("load", new LoadCommand());


    }

    public Player getPlayer() {
        return player;
    }



    public String gameEnding() {
        int memoryCount = journal.memoryEntrySize();
        Stranger stranger = new Stranger(warehouse);
        stranger.updateMemoryLevel(memoryCount);

        StringBuilder ending = new StringBuilder();
        ending.append("You enter the warehouse, the final place your memories have guided you to.\n\n");
        for(String line : stranger.getDialogue()) {
            ending.append(line).append("\n");
        }
        //ending.append(stranger.getDialogue()).append("\n");
        stranger.clearDialogue();

        /*if(memoryCount < 3) {
            ending.append("Despite your efforts, many memories remain lost. Some truths may never be recovered.\n");
            ending.append("But perhaps that’s a part of life—you can only move forward with what you know.\n");
        } else if(memoryCount < 7) {
            ending.append("You’ve remembered enough to understand most of your journey.\n");
            ending.append("Pieces fall into place, but a few shadows linger. Still, you feel ready to move on.\n");
        } else {
            ending.append("Every memory aligns. The fragments finally form a complete picture.\n");
            ending.append("You understand your past, your actions, and yourself. This is closure.\n");
            ending.append("You leave the warehouse knowing who you are, finally free to move forward.\n");
        }*/

        ending.append("=== THE END ===");
        return ending.toString();
    }


    public String saveGame() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this.allRooms);
            out.writeObject(this.player);
            out.writeObject(journal);
            return "Game saved successfully";

        } catch (IOException i) {
            i.printStackTrace();
            return "Failed to save game";
        }
    }

    public String loadGame() {

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            allRooms = (HashMap<String, Room>) input.readObject();
            player = (Player) input.readObject();
            journal = (Journal) input.readObject();
            return "Game loaded successfully" + "\n" + player.getCurrentRoom().getLongDescription();

        } catch (IOException  | ClassNotFoundException i) {
            i.printStackTrace();
            return "Failed to load game";
        }

    }

    public void cheat() {
        player.getJournal().addMemory(benchMemory);
        player.getJournal().addMemory(storeMemory);
        player.getJournal().addMemory(alleyMemory);
        player.getJournal().addMemory(policeMemory);
        player.getJournal().addMemory(motelLobbyMemory);
        player.getJournal().addMemory(motelRoomMemory);
        player.getJournal().addMemory(warehouseMemory);
        player.getJournal().addMemory(churchInteriorMemory);

        player.setCurrentRoom(warehouse);



        benchMemory = new MemoryBlock("You wake up on this bench, the streetlight flickering above. The sensation of being watched… but by who?");
        storeMemory = new MemoryBlock("The smell of old snacks triggers a flash: a face you vaguely recognize smiles at you behind the counter.");
        alleyMemory = new MemoryBlock("A man wrapped in rags whispers your name. Something about a meeting at midnight.");
        policeMemory = new MemoryBlock("A drawer slightly ajar… you remember hiding something important here long ago.");
        motelLobbyMemory = new MemoryBlock("The neon light flickers. Room 23… your old room. You recall a promise made here.");
        motelRoomMemory = new MemoryBlock("Dust motes dance in the sunlight. Fragments of a journal you once wrote float into your mind.");
        warehouseMemory = new MemoryBlock("Crates stacked high. You see a logo that sparks a memory of someone guiding you here before…");
        churchInteriorMemory = new MemoryBlock("You feel a chill go up your spine. There's something amiss here. ");


    }




    public static void main(String[] args) {
        //ZorkULGame game = new ZorkULGame();

         //game.play();
 }
}