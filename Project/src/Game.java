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
        Room Bathroom = new Room("Bathroom", "A white tiled bathroom with a sink, towels, and bathtub, each faucet emits a foul smell, it reminds you of blood.");
        Room LivingRoom = new Room("Living Room", "A comforting forest toned room. You see a couch with a cat toy on it facing a TV propped on a stand." +"\n a kitten gives you an inquiring stare from the center of the carpet");
        Room Kitchen = new Room("Kitchen", "A long stretching room, you enter from the north side. you can see a table set for a meal. various cabinets lay against the walls behind it");


        // spawn in bedroom
        Bedroom.setPlayer(player);

        // objects //
        Object Closet = new Object("Closet", "Common");
        Closet.interactions.put("Pick Up", (s,l) -> {
           System.out.println("Why would you think we can pick this up.");
        });

        Closet.interactions.put("Open", (s,l) -> {
            System.out.println("Inside this closet is a");
        });

        Dictionary<String, Object> BedroomObjects = new Dictionary<>;

        // Closet.interactions.get("Open").accept("Hello!", "Bye bye!");


    }

}
