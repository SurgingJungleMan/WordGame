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
        BiConsumer<String, String> method = prompting.findAction(results, this.Items);
        if (method == null){



            boolean worked = prompting.checkRelationInventory(a, this.player);
            if (!worked){
                System.out.println();
                System.out.println("If you said a two word action like pick up, I suggest you saying get!");
                System.out.println("Nothing found sorry gng, no action found -- for the literate");
            }






            return;
        }
        method.accept("A", "A");
        // reprompt
        promptPlayer();
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
}