import com.sun.source.tree.Tree;

import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Factory<K, V>{

    public Factory(){

    }

    //Post: Retornar un mapa dependiendo de la implementacion solicitada por el usuario.
    //      En caso de que no exista, retornar null.
    public Map<K,V> getMap(int eleccion){
        switch (eleccion){
            case 1: return new HashMap<K,V>();
            case 2: return new TreeMap<K,V>();
            case 3: return new LinkedHashMap<K,V>();
            default: return null;
        }
    }
}