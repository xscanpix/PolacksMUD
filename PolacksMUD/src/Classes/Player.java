package Classes;

import Classes.Objects.Objects;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Player {

    private Room currentRoom;
    private List finishedCourses;
    private List unfinishedCourses;
    private String name;
    private int hp;
    private int inventory;
    private List inventoryList;
    private ListIterator iter;

    public Player(Room startRoom, String name) {
        this.hp = 60;
        this.inventory = 0;
        this.currentRoom = startRoom;
        this.name = name;
        finishedCourses = new LinkedList();
        unfinishedCourses = new LinkedList();
        inventoryList = new LinkedList();
    }

    public void moveNorth() {
        if (currentRoom.getNorth() != null) {
            if (currentRoom.getDoorNorth().isUnlocked()) {
                this.currentRoom = currentRoom.getNorth();
            } else {
                System.out.println("Locked.\n");
            }
        } else {
            System.out.println("You can't go there.\n");
        }
    }

    public void moveEast() {
        if (currentRoom.getEast() != null) {
            if (currentRoom.getDoorEast().isUnlocked()) {
                this.currentRoom = currentRoom.getEast();
            } else {
                System.out.println("Locked.\n");
            }
        } else {
            System.out.println("You can't go there.\n");
        }
    }

    public void moveSouth() {
        if (currentRoom.getSouth() != null) {
            if (currentRoom.getDoorSouth().isUnlocked()) {
                this.currentRoom = currentRoom.getSouth();
            } else {
                System.out.println("Locked.\n");
            }
        } else {
            System.out.println("You can't go there.\n");
        }
    }

    public void moveWest() {
        if (currentRoom.getWest() != null) {
            if (currentRoom.getDoorWest().isUnlocked()) {
                this.currentRoom = currentRoom.getWest();
            } else {
                System.out.println("Locked.\n");
            }
        } else {
            System.out.println("You can't go there.\n");
        }
    }

    public String getName() {
        return this.name;
    }

    public void finishCourse(Course c) {
        finishedCourses.add(c);
    }

    public void unfinishCourse(Course c) {
        unfinishedCourses.add(c);
        finishedCourses.remove(c);
    }

    public void addToInventory(Objects obj) {
        inventoryList.add(obj);
    }

    public void removeFromInventory(Objects obj) {
        inventoryList.remove(obj);
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public void printInventory() {
        iter = inventoryList.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    @Override
    public String toString() {
        String s = "Name: " + this.name + "\nHp: " + this.hp + "\nInventory: " + this.inventory + "\nUnfinishedCourses: \n";
        iter = unfinishedCourses.listIterator();
        while (iter.hasNext()) {
            s += iter.next().toString();
        }
        s += "FinishedCourses: \n";
        iter = finishedCourses.listIterator();
        while (iter.hasNext()) {
            s += iter.next().toString();
        }
        return s + "\n";
    }
}