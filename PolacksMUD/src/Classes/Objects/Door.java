package Classes.Objects;

public class Door {

    private boolean unlocked;

    public Door(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public void lock() {
        this.unlocked = false;
    }

    public void unlock() {
        this.unlocked = true;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }
}
