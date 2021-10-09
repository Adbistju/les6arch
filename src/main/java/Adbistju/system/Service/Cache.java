package Adbistju.system.Service;

import Adbistju.system.Figure;

import java.util.HashMap;
import java.util.Objects;

public class Cache {
    public static HashMap<Integer, Figure> figureCache = new HashMap<>();
    public static HashMap<Integer, Figure> figureCacheById = new HashMap<>();


    public static void put(int hash, Figure figure){
        figureCache.put(hash, figure);
        figureCacheById.put(figure.getId(), figure);
    }

    public static void putById(int id, Figure figure){
        figureCacheById.put(id, figure);
        figureCache.put(figure.hashCode(), figure);
    }

    public static Figure getById(int id){
        return figureCacheById.get(id);
    }

    public static Figure get(int hash){
        return figureCache.get(hash);
    }


    public static Figure gets(float square, float width, float height, int angle){
        int hash = Objects.hash(square, width, height, angle);
        return figureCache.get(hash);
    }

    public static Figure getAll(){
        Object[] list = figureCache.values().stream().toArray();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        return null;
    }
}
