package Classes.Objects;

public class Objects {

    private String name;
    private int volume;
    
    public Objects(String name, int volume){
        this.name = name;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
