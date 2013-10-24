package Classes;

public class Course {

    private String courseName;
    private String title;
    private int hp;

    public Course(String courseName, String title, int hp) {
        this.courseName = courseName;
        this.title = title;
        this.hp = hp;
    }

    public String getTitle(){
        return title;
    }
    
    public String getCourseName() {
        return courseName;
    }

    public String toString() {
        return "Course(" + courseName + "," + title + "," + hp + ")\n";
    }
}
