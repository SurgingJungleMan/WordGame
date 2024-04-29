import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.function.BiConsumer;

public class Object {
    /*
    *Object.Treasure class for zork
    */

    //
    public Map<String, BiConsumer<Object, Player>> interactions = new HashMap<>();


    private String Name;
    private Room room;
    private Player owner;

    private String Desc;

    // we need a table to


    public Object (String name, String desc) {

        //
        interactions.put("drop", (player, obj) -> {
            // we have to drop this bruh
            // this is gonna be hard
        });

    }
    
    public String getName(){
        return Name;    
    }
}