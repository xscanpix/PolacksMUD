package Classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        WorldCreator world = new WorldCreator();
        boolean running = true;
        //world.printProperties();
        world.initWorld();
        world.putNewPlayer("One", "Svante");
        //world.printRooms();
        world.printPlayer("Svante");
        world.findPlayer("Svante").getCurrentRoom().roomText();

        Scanner sc = new Scanner(System.in);
        while (running) {
            System.out.print("Command: ");
            String[] s = sc.nextLine().split(" ", 2);
            if (s[0].contentEquals("look")) {
                world.findPlayer("Svante").getCurrentRoom().roomText();
            } else if (s[0].contentEquals("move")) {
                if (s[1].contentEquals("north")) {
                    world.findPlayer("Svante").moveNorth();
                    world.findPlayer("Svante").getCurrentRoom().roomText();
                }
                if (s[1].contentEquals("east")) {
                    world.findPlayer("Svante").moveEast();
                    world.findPlayer("Svante").getCurrentRoom().roomText();
                }
                if (s[1].contentEquals("south")) {
                    world.findPlayer("Svante").moveSouth();
                    world.findPlayer("Svante").getCurrentRoom().roomText();
                }
                if (s[1].contentEquals("west")) {
                    world.findPlayer("Svante").moveWest();
                    world.findPlayer("Svante").getCurrentRoom().roomText();
                }
            } else if (s[0].contentEquals("pick")) {
                world.findPlayer("Svante").addToInventory(world.findPlayer("Svante").getCurrentRoom().findObject(s[1]));
                world.findPlayer("Svante").getCurrentRoom().removeObject(s[1]);
            } else if (s[0].contentEquals("inventory")) {
                world.findPlayer("Svante").printInventory();
            } else if (s[0].contentEquals("quit")) {
                System.exit(1);
            } else if(s[0].isEmpty()){
                System.out.println("");
            } else
                System.out.println("I don't understand that.\n");

        }

    }
}
