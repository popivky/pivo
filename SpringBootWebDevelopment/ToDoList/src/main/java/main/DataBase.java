package main;

import main.model.Thing;

import java.util.*;

public class DataBase {
    private static HashMap<Integer,Thing> things = new HashMap<>();

    public static List<Thing> getAllThings(){

        List<Thing> allThings = new ArrayList<>();
        allThings.addAll(things.values());
        return allThings;
    }

    public static int addThing(Thing thing){
        int id = 1;
        if (!things.containsValue(thing)) {

            do {
                Random r = new Random();
                id = r.nextInt(1000);
            } while (things.containsKey(id));
            things.put(id, thing);
        }
        return id;

        }

//    public static void delThing (int id){
//        System.out.println("Дело " + things.get(id).getName() + " удалено" );
//        things.remove(id);
//    }

    public static Thing getThing(int id){
        if(things.containsKey(id)){
            return things.get(id);
        }
        return null;
    }
}
