import java.util.*;

public class Game
{
    // static dictionary to hold all of the rooms
    static Map<String, Room> Rooms= new Hashtable<>();


    
    public Game(){
        /*

        Rooms.add(new Room());



         */
        Player player = new Player();
        
        
        Room Bedroom = new Room("Bedroom", 
                "A simple homey room. Theres a bed, closet and nightstand.");
        
        Room Bathroom = new Room("Bathroom", 
                "A white tiled bathroom with a sink, towels, and bathtub, each faucet emits a foul smell, it reminds you of blood.");
        
        Room LivingRoom = new Room("Living Room", 
                "A comforting forest toned room. You see a couch with a cat toy on it facing a TV propped on a stand." +"\n a kitten gives you an inquiring stare from the center of the carpet");
        
        Room KitchenN = new Room("Kitchen North", 
                "A long stretching room, you are on the north side. you can see a table set for a meal. various cabinets lay against the walls behind it");
        Room KitchenS = new Room("Kitchen South",
         "A long stretching room, you are on the south side. You can see a walk in pantry and a fridge,");

        // spawn in bedroom
        Bedroom.setPlayer(player);

        // objects //
        Map<String, Object> BedroomObjects = new HashMap<String, Object>();

        Object Closet = new Object("Closet", "");
        Closet.interactions.put("carry", (s,l) -> {
           System.out.println("Why would you think we can pick this up.");
        });
        Closet.interactions.put("go", (s,l) -> {
                   System.out.println("Why would you think we can pick this up.");
        });

        Closet.interactions.put("open", (s,l) -> {
            System.out.println("Inside this closet is a knife!");

            // set up the found knife // lmaooo!
            Object Knife = new Object("Knife", "A simple knife.");
            Knife.interactions.put("get", (plr, object) -> {


                //plr.insertInventory(object);
                System.out.println("Added to inventory.");

            });

            // hahaahahahaha
            BedroomObjects.put("knife", Knife);
        });

        //Closet.interactions.get("Pick Up").accept("Hello!", "Bye bye!");

        //
        BedroomObjects.put("closet", Closet);
        Bedroom.setObjects(BedroomObjects);
        
        Bedroom.promptPlayer();
        

    }

}
