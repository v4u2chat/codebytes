package com.test.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

// https://tom-e-white.com/2007/11/consistent-hashing.html
public class ConsistentHash<T> {

    private final HashFunction hashFunction;
    private final SortedMap<String, T> circle = new TreeMap<>();

    public ConsistentHash(HashFunction hashFunction, Collection<T> tables) {
        this.hashFunction = hashFunction;
        for (T table : tables) {
            add(table);
        }
    }

    public void add(T table) {
        circle.put(hashFunction.hash(table.toString()), table);
    }

    public void remove(T table) {
        circle.remove(hashFunction.hash(table.toString()));
    }

    public T get(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        String hash = hashFunction.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<String, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    public static void main(String[] args) {
        HashFunction hashFunction = new HashFunction();
        String[] tables = new String[] { "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T0" };
        ConsistentHash<String> consistentHash = new ConsistentHash<String>(hashFunction, Arrays.asList(tables));

        System.out.println(consistentHash.get("key1"));
        System.out.println(consistentHash.get("key2"));
        System.out.println(consistentHash.get("key3"));

        System.out.println(consistentHash.get("key1"));
        System.out.println(consistentHash.get("key2"));
        System.out.println(consistentHash.get("key3"));
    }
}
