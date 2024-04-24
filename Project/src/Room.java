import javax.swing.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BiConsumer;


public class Room {

    private static Scanner Sc = new Scanner(System.in);
    private String Name;
    private String Desc;


    private Player player;
    private Map<String, Object> Items;
    private Map<String, Room> Directions;
    
    private Prompts prompting = new Prompts();

    private void checkPrompt(String a){
        ArrayList<String> results = prompting.sortWords(a, this.Items);
        Object foundItem = prompting.findItem(results, this.Items);
        BiConsumer<Object, Player> method = prompting.findAction(results, this.Items);


        if (method == null){



            BiConsumer<Player, Room> worked = prompting.checkRelationInventory(a, this.player);
            worked.accept(this.player, this);


        }else{


            method.accept(foundItem, this.player);
            // reprompt
            promptPlayer();

        }

    }

    public void promptPlayer(){
        if(this.player == null){
            System.out.println("Player is not in this room...");
            return;
        }

        System.out.println(this.Desc);
        String answer = Sc.nextLine();
        checkPrompt(answer);
    }

    public Room(String name, String desc) {
        Name = name;
        Desc = desc;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setObjects(Map<String, Object> objects) {
        Items = objects;
    }

    public Map<String, Object> getObjects(){
        return Items;
    }
}