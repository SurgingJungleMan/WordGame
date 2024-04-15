import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Objects;

public class Room {
    private String Name;
    private String Desc;

    private Player Me;
    private Dictionary<String, Object> Items;
    private Dictionary<String, Room> Directions;



    public Room(String name, String desc) {
        Name = name;
        Desc = desc;

    }

    public void setPlayer(Player player) {
        Me = player;
    }

    public void setObjects(Dictionary<String, Object> objects) {
        Items = objects;
    }
}