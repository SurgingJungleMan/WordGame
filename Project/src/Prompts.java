import java.util.ArrayList;
import java.util.Map;
import java.util.function.BiConsumer;

public class Prompts{
    

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
        
        System.out.println("If you said a two word action like pick up, I suggest you saying get!");
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
