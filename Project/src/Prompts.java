import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Prompts{


    public boolean checkRelationInventory(String a, Player plr){
        // check if we mention the inventory at all...

        List<String> words = Arrays.asList(a.split(" "));


        boolean found = words.contains("Inv")|| words.contains("Inventory") || words.contains("inventory") || words.contains("inv");
        if(found){

            // if we find remove then remove obviously!

            boolean remove = words.contains("remove")|| words.contains("Remove")|| words.contains("drop");

            if (remove){

                //
                System.out.println("Player plans to remove stuff from their inventory, im working on this right now gng....");
                return true;
            }

            boolean view = words.contains("open")|| words.contains("look") || words.contains("view") || words.contains("Open");




            return true;

        }

        return false;
    }

    public BiConsumer<String, String> findAction(ArrayList<String> words, Map<String, Object> items){
        for (String word : words){

            // crying
            for (Map.Entry<String, Object> item : items.entrySet()){
                
                for (Map.Entry<String, BiConsumer<String, String>> method : item.getValue().interactions.entrySet()) {
                    // going to cry
                    String actionName = method.getKey();

                    if (actionName.equals(word)){
                        return method.getValue();
                    }

                }
            }
        }

        return null;
    }

    public ArrayList<String> sortWords(String a, Map<String, Object> items){
        a = a.toLowerCase();

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
