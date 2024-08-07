package com.iebya.collection.map;

import java.util.HashMap;
import java.util.Map;

public class TraverseMapDemo {
    public static void main(String[] args) {
        // Create a map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Traverse the map using keySet()
        System.out.println("Traverse the map using keySet()");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        // Traverse the map using entrySet()
        System.out.println("Traverse the map using entrySet()");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
    }
}
