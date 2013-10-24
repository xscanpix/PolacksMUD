package Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileHandler {
    
    private Properties books = new Properties();
    private Properties world = new Properties();
    private Properties courses = new Properties();
    private Properties creatures = new Properties();
    private Properties keys = new Properties();
    private FileInputStream in;
    
    public FileHandler() throws FileNotFoundException, IOException {
        try {
            String internalPath = this.getClass().getName().replace(".", File.separator);
            String externalPath = System.getProperty("user.dir") + File.separator + "src";
            String workDir = externalPath + File.separator + internalPath.substring(0, internalPath.lastIndexOf(File.separator));
            in = new FileInputStream(workDir + "/books.properties");
            books.load(in);
            in.close();
            in = new FileInputStream(workDir + "/world.properties");
            world.load(in);
            in.close();
            in = new FileInputStream(workDir + "/courses.properties");
            courses.load(in);
            in.close();
            in = new FileInputStream(workDir + "/creatures.properties");
            creatures.load(in);
            in.close();
            in = new FileInputStream(workDir + "/keys.properties");
            keys.load(in);
            in.close();
            
        } catch (FileNotFoundException e) {
            e.getStackTrace();
            throw new FileNotFoundException();
        }
        //books.list(System.out);
    }
    
    public void printProperties() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.getProperty("book" + (i + 1)));
        }
        for (int i = 0; i < world.size(); i++) {
            System.out.println(world.getProperty("room" + (i + 1)));
        }
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.getProperty("course" + (i + 1)));
        }
        for (int i = 0; i < creatures.size(); i++) {
            System.out.println(creatures.getProperty("creature" + (i + 1)));
        }
    }
    
    public Properties getBooks() {
        return books;
    }
    
    public Properties getWorld() {
        return world;
    }
    
    public Properties getCourses() {
        return courses;
    }
    
    public Properties getCreatures() {
        return creatures;
    }
    public Properties getKeys(){
        return keys;
    }
}
