package Classes;

import Classes.Creatures.Creature;
import Classes.Creatures.Teacher;
import Classes.Objects.Door;
import Classes.Objects.Objects;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Room {

    private Room roomNorth;
    private Room roomEast;
    private Room roomSouth;
    private Room roomWest;
    private Door doorNorth;
    private Door doorEast;
    private Door doorSouth;
    private Door doorWest;
    private String name;
    private List<Objects> objects;
    private List<Creature> creatures;
    private ListIterator iter;

    public Room(String _name, Room rNorth, Room rEast, Room rSouth, Room rWest,
            Door dNorth, Door dEast, Door dSouth, Door dWest) {
        this.name = _name;
        this.roomNorth = rNorth;
        this.roomSouth = rSouth;
        this.roomEast = rEast;
        this.roomWest = rWest;
        this.doorNorth = dNorth;
        this.doorEast = dEast;
        this.doorSouth = dSouth;
        this.doorWest = dWest;
        objects = new LinkedList();
        creatures = new LinkedList();
    }

    public Room getNorth() {
        return roomNorth;
    }

    public Room getEast() {
        return roomEast;
    }

    public Room getSouth() {
        return roomSouth;
    }

    public Room getWest() {
        return roomWest;
    }

    public Door getDoorNorth() {
        return doorNorth;
    }

    public Door getDoorEast() {
        return doorEast;
    }

    public Door getDoorSouth() {
        return doorSouth;
    }

    public Door getDoorWest() {
        return doorWest;
    }

    public void lockNorth() {
        doorNorth.lock();
    }

    public void lockEast() {
        doorEast.lock();
    }

    public void lockSouth() {
        doorSouth.lock();
    }

    public void lockWest() {
        doorWest.lock();
    }

    public void unlockNorth() {
        doorNorth.unlock();
    }

    public void unlockEast() {
        doorEast.unlock();
    }

    public void unlockSouth() {
        doorSouth.unlock();
    }

    public void unlockWest() {
        doorWest.unlock();
    }

    public void setRoomNorth(Room r) {
        this.roomNorth = r;
    }

    public void setRoomEast(Room r) {
        this.roomEast = r;
    }

    public void setRoomSouth(Room r) {
        this.roomSouth = r;
    }

    public void setRoomWest(Room r) {
        this.roomWest = r;
    }

    public String getName() {
        return this.name;
    }

    public void addCreature(Creature c) {
        creatures.add(c);
    }

    public void removeCreature(String name) {
        iter = creatures.listIterator();
        while (iter.hasNext() && !creatures.isEmpty()) {
            Creature c = (Creature) iter.next();
            if (c.getName().contentEquals(name)) {
                iter.remove();
            }
        }
    }

    public boolean existsCreatures() {
        return !creatures.isEmpty();
    }

    public void addObject(Objects obj) {
        objects.add(obj);
    }

    public void removeObject(String name) {
        iter = objects.listIterator();
        while (iter.hasNext() && !objects.isEmpty()) {
            Objects obj = (Objects) iter.next();
            if (obj.getName().contentEquals(name)) {
                iter.remove();
            }
        }
    }

    public boolean existsObjects() {
        return !objects.isEmpty();
    }

    public void roomText() {
        System.out.println("You are in room " + name);
        listExits();
        listObjects();
        listCreatures();
        System.out.println();
    }

    public void listExits() {
        String s = "";

        if (roomNorth != null) {
            s += "There is a door to the north. ";
            if (doorNorth.isUnlocked()) {
                s += "\n";
            } else {
                s += "It is locked\n";
            }
        }
        if (roomEast != null) {
            s += "There is a door to the east. ";
            if (doorEast.isUnlocked()) {
                s += "\n";
            } else {
                s += "It is locked\n";
            }
        }
        if (roomSouth != null) {
            s += "There is a door to the south. ";
            if (doorSouth.isUnlocked()) {
                s += "\n";
            } else {
                s += "It is locked\n";
            }
        }
        if (roomWest != null) {
            s += "There is a door to the west. ";
            if (doorWest.isUnlocked()) {
                s += "\n";
            } else {
                s += "It is locked\n";
            }
        }
        System.out.print(s);
    }

    public void listObjects() {
        if (!objects.isEmpty()) {
            iter = objects.listIterator();
            while (iter.hasNext()) {
                System.out.print("You see a " + iter.next());
            }
        }
    }

    public void listCreatures() {
        if (!creatures.isEmpty()) {
            iter = creatures.listIterator();
            while (iter.hasNext()) {
                System.out.print("You see " + iter.next() + "\n");
            }
        }
    }

    public Objects findObject(String name) {
        iter = objects.listIterator();
        while (iter.hasNext()) {
            Objects obj = (Objects) iter.next();
            if (obj.getName().contentEquals(name)) {
                objects.remove(obj);
                return obj;
            }

        }
        return null;
    }

    public String toString() {
        String s = "";
        s += "Room(";
        s += (name + ",");
        if (roomNorth == null) {
            s += "X,";
        } else {
            s += roomNorth.getName() + ",";
        }
        if (roomEast == null) {
            s += "X,";
        } else {
            s += roomEast.getName() + ",";
        }
        if (roomSouth == null) {
            s += "X,";
        } else {
            s += roomSouth.getName() + ",";
        }
        if (roomWest == null) {
            s += "X,";
        } else {
            s += roomWest.getName() + ",";
        }
        s += doorNorth.isUnlocked() + ",";
        s += doorEast.isUnlocked() + ",";
        s += doorSouth.isUnlocked() + ",";
        s += doorWest.isUnlocked() + ")";
        return s;

    }
}
