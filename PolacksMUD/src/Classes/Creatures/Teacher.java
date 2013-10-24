package Classes.Creatures;

import Classes.Room;

public class Teacher extends Creature {

    public Teacher(String _name, Room startRoom) {
        this.setName(_name);
        this.setCurrentRoom(startRoom);
    }

    public void talk(String message) {
        System.out.println(message);
    }

    public String toString() {
        return this.getName();
    }
}
