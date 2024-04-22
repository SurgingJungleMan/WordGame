import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class Player {

    private Map<String, Object> Inventory= new Hashtable<>();
    
    public Player(){
        
    }

    public void insertInventory(Object item){
        Inventory.put(item.getName(), item);
    }

    public void viewInventory(){
        for (Map.Entry<String,Object> entry : Inventory.entrySet()){
            System.out.println(entry.getKey());
        }
    }
}
