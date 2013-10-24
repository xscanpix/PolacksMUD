package Classes.Creatures;

import Classes.Room;

public class Creature {

    private String name;
    private Room currentRoom;

    public void talk(String message) {
        System.out.println(message);
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String _name) {
        this.name = _name;
    }
    public String toString(){
        return name;
    }
}
