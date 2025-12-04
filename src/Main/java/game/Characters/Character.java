package game.Characters;
import game.Rooms.Room;
import java.io.Serializable;

public class Character implements Serializable {
    protected String name;
    protected Room currentRoom;
    private StringBuilder sb;
    private static final long serialVersionUID = 1L;


    public Character(String name, Room startingRoom) {
        this.name = name;
        this.currentRoom = startingRoom;
        sb = new StringBuilder();
    }

    public Character() {

    }


    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You moved to: " + currentRoom.getDescription());
        } else {
            System.out.println("You can't go that way!");
        }
    }

}

