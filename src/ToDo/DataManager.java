package ToDo;

public class DataManager {
    private int ID;
    private String name;
    private boolean isActive;

    public DataManager( int ID, String name, boolean isActive) {
        this.ID = ID;
        this.name = name;
        this.isActive = isActive;
    }
    public DataManager (String ID, String name, boolean isActive){
        this.ID = Integer.valueOf(ID);
        this.name = name;
        this.isActive = isActive;
    }

    public DataManager() {
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

