import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Game
{
    // static dictionary to hold all of the rooms
    static Dictionary<String, Room> Rooms= new Hashtable<>();


    
    public Game(){
        /*

        Rooms.add(new Room());



         */
        Player player = new Player();
        Room Bedroom = new Room("Bedroom", "A simple homey room. Theres a bed, closet and nightstand.");
        Bedroom.setPlayer(player);

        // objects //
        Object Closet = new Object("Closet", "Common");
        



    }

}
