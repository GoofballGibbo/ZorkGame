package game.Characters;

import game.Rooms.Room;
import game.Items.*;



public class MotelManager extends NPC {

    private Room motelRoom;
    private Room startingRoom;
    private StringBuilder sb = new StringBuilder();

    public MotelManager(Room startingRoom, Item desiredItem, Room motelRoom, MemoryBlock memoryBlock) {

        super("Motel Manager", startingRoom, desiredItem, null, memoryBlock);
        this.startingRoom = startingRoom;
        this.motelRoom = motelRoom;
    }

    @Override
    public void checkTrade(Player player) {
        if (currentRoom.containsItems(getDesiredItem())) {
            currentRoom.removeItems(getDesiredItem().getName());
            getInventory().add(getDesiredItem());
            player.getJournal().addMemory(memoryBlock);




            clearDialogue();
            addDialogue("'Ah, I see you still have the key.'");
            addDialogue("'Good, this will let you access the motel safely.'");



            dialogueReady = true;

            player.setCurrentRoom(motelRoom);
            motelRoom.setExit("west", startingRoom);
            startingRoom.setExit("east", motelRoom);





        }
    }
}
