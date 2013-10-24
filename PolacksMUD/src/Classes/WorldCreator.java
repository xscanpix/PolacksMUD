package Classes;

import Classes.Creatures.Creature;
import Classes.Creatures.Student;
import Classes.Creatures.Teacher;
import Classes.Objects.Book;
import Classes.Objects.Door;
import Classes.Objects.Key;
import Classes.Objects.Objects;
import Properties.FileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class WorldCreator {

    private FileHandler fh;
    private List<Room> map;
    //private List<Objects> objectList;
    private List<Course> courseList;
    private List<Book> bookList;
    private List<Creature> creatureList;
    private List<Player> playerList;
    private List<Key> keyList;

    public WorldCreator() throws FileNotFoundException, IOException {
        fh = new FileHandler();
        map = new LinkedList();
        //objectList = new LinkedList();
        bookList = new LinkedList();
        courseList = new LinkedList();
        playerList = new LinkedList();
        creatureList = new LinkedList();
        keyList = new LinkedList();
    }

    public void initWorld() {
        this.initRooms();
        this.initObjects();
        this.initCreatures();
        this.putObjects();
        this.putCreatures();
    }

    private void initObjects() {
        this.initCourses();
        this.initBooks();
        this.initKeys();
    }

    private void putObjects() {
        this.putBooks();
        this.putKeys();
    }

    private void putBooks() {
        ListIterator iter = bookList.listIterator();
        for (int i = 0; i < bookList.size(); i++) {
            map.get(new Random().nextInt(map.size())).addObject((Objects) iter.next());
        }
    }
    private void putKeys(){
        ListIterator iter = keyList.listIterator();
        for (int i = 0; i < keyList.size(); i++) {
            map.get(new Random().nextInt(keyList.size())).addObject((Objects) iter.next());
        }
    }

    private void putCreatures() {
        ListIterator<Creature> iter = creatureList.listIterator();
        System.out.print(creatureList.size());

        for (int i = 0; i < creatureList.size(); i++) {
            Creature c = iter.next();
            c.getCurrentRoom().addCreature(c);
        }
    }

    public void putNewPlayer(String room, String name) {
        playerList.add(new Player(findRoom(room), name));
    }

    public Player findPlayer(String name) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getName().contentEquals(name)) {
                return playerList.get(i);
            }
        }
        return null;
    }

    private Course findCourse(String title) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getTitle().contentEquals(title)) {
                return courseList.get(i);
            }
        }
        return null;
    }

    private Book findBook(String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().contentEquals(title)) {
                return bookList.get(i);
            }
        }
        return null;
    }

    private Room findRoom(String name) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getName().contentEquals(name)) {
                return map.get(i);
            }
        }
        return null;
    }

    private void initCourses() {
        for (int i = 0; i < fh.getCourses().size(); i++) {
            String[] s = fh.getCourses().getProperty("course" + (i + 1)).split(",");
            courseList.add(new Course(s[0], s[1], Integer.parseInt(s[2])));
        }
    }

    private void initBooks() {
        for (int i = 0; i < fh.getBooks().size(); i++) {
            String[] s = fh.getBooks().getProperty("book" + (i + 1)).split(",");
            bookList.add(new Book(s[0], s[1], s[2], Integer.parseInt(s[3]), findCourse(s[0])));
        }
    }

    private void initKeys() {
        int n = Integer.parseInt(fh.getKeys().getProperty("keys"));
        for (int j = 0; j < n; j++) {
            keyList.add(new Key());
        }
    }

    private void initRooms() {
        for (int i = 0; i < fh.getWorld().size(); i++) {
            String[] s1 = fh.getWorld().getProperty("room" + (i + 1)).split(",");
            map.add(new Room(s1[0], null, null, null, null,
                    new Door(Boolean.valueOf(s1[5])),
                    new Door(Boolean.valueOf(s1[6])),
                    new Door(Boolean.valueOf(s1[7])),
                    new Door(Boolean.valueOf(s1[8]))));
        }

        for (int i = 0; i < fh.getWorld().size(); i++) {
            String[] s1 = fh.getWorld().getProperty("room" + (i + 1)).split(",");
            for (int j = 0; j < fh.getWorld().size(); j++) {
                if (j != i) {
                    String[] s2 = fh.getWorld().getProperty("room" + (j + 1)).split(",");
                    if (s1[1].contentEquals(s2[0])) {
                        findRoom(s1[0]).setRoomNorth(findRoom(s2[0]));
                    }
                    if (s1[2].contentEquals(s2[0])) {
                        findRoom(s1[0]).setRoomEast(findRoom(s2[0]));
                    }
                    if (s1[3].contentEquals(s2[0])) {
                        findRoom(s1[0]).setRoomSouth(findRoom(s2[0]));
                    }
                    if (s1[4].contentEquals(s2[0])) {
                        findRoom(s1[0]).setRoomWest(findRoom(s2[0]));
                    }
                }
            }
        }
    }

    private void initCreatures() {
        for (int i = 0; i < fh.getCreatures().size(); i++) {
            String[] s1 = fh.getCreatures().getProperty("creature" + (i + 1)).split(",");

            if (s1[0].contentEquals("teacher")) {
                creatureList.add(new Teacher(s1[2], findRoom(s1[1])));
            }
            if (s1[0].contentEquals("student")) {
                creatureList.add(new Student(s1[2], findRoom(s1[1])));
            }

        }
    }

    public void printProperties() {
        fh.printProperties();
    }

    public void printCourses() {
        ListIterator iter = courseList.listIterator();
        while (iter.hasNext()) {
            Course c = (Course) iter.next();
            System.out.print(c);
        }
    }

    public void printBooks() {
        ListIterator iter = bookList.listIterator();
        while (iter.hasNext()) {
            Book b = (Book) iter.next();
            System.out.println(b);
        }
    }

    public void printRooms() {
        ListIterator iter = map.listIterator();
        while (iter.hasNext()) {
            Room room = (Room) iter.next();
            System.out.println(room);
            room.roomText();
        }
    }

    public void printCreatures() {
        ListIterator iter = creatureList.listIterator();
        while (iter.hasNext()) {
            Creature c = (Creature) iter.next();
            System.out.print(c);
        }
    }

    public void printPlayer(String name) {
        System.out.println(findPlayer(name));
    }
}
