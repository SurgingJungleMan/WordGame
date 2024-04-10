import java.util.Dictionary;
import java.util.Hashtable;
public class Room {
    private String rmName;
    private String rmDesc;

    private Player myPlr;
    private Dictionary<String, Object> rmObjects;
    private Dictionary<String, Room> directions;
    public Room(String name, String desc) {
        rmName = name;
        rmDesc = desc;

    }

    public void setPlayer(Player plr) {
        this.myPlr = plr;
    }

    public void setObjects(Dictionary<String, Object> objects) {
        rmObjects = objects;
    }

    public void setDirections(Dictionary<String, Room> direct){
        directions = direct;
    }
}