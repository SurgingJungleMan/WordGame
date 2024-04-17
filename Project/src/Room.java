import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;


public class Room {

    private static class promptHandler{

        public ArrayList<String> sortWords(String a, Map<String, Object> items){
            ArrayList<String> wordArrayList = new ArrayList<String>();

            Object item = null;
            
            // loop through what hte player said
            for(String word : a.split(" ")) {
                
                // loop through all the times
                for (Map.Entry<String, Object> object : items.entrySet()) {

                    // if the items name equals a word inside the sentence, store it
                    String name = object.getKey();
                    Object CurrentItem = object.getValue();
                    
                    if (name.equals(word)){
                        item = CurrentItem;
                        wordArrayList.add(word);
                    }

                }
                
            }

            // loop through words again
            for(String word : a.split(" ")) {
                if (item != null){ // if we have an item
                    for (Map.Entry<String, BiConsumer<String, String>> method : item.interactions.entrySet()) {
                        // going to cry
                        String actionName = method.getKey();


                        if (actionName.equals(word)){
                            wordArrayList.add(word);
                        }

                    }
                }
            }
            

            
            return wordArrayList;
        }

    }


    private static Scanner Sc = new Scanner(System.in);
    private String Name;
    private String Desc;

    private Player player;
    private Map<String, Object> Items;
    private Map<String, Room> Directions;
    
    private promptHandler prompting = new promptHandler();

    private void checkPrompt(String a){
        ArrayList<String> results = prompting.sortWords(a, this.Items);
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