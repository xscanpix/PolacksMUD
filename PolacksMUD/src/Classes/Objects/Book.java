package Classes.Objects;

import Classes.Course;

public class Book extends Objects {

    private Course course;
    private String author;
    private String year;

    public Book(String title, String author, String year, int volume, Course c) {
        super(title, volume);
        this.course = c;
        this.author = author;
        this.year = year;
        this.setVolume(volume);
    }
    
    
    public Course getCourse(){
        return course;
    }

    public String toString() {
        return "Book(" + this.getName() + "," + author + "," + year + ")\n";
    }
}
