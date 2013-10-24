package Classes.Creatures;

import Classes.Room;

public class Student extends Creature {
    
    public Student(String name, Room startRoom){
        this.setName(name);
        this.setCurrentRoom(startRoom);
    }
    
    public void talk(String message) {
        System.out.println(message);
    }
    
    public String toString() {
        return this.getName();
    }
}
