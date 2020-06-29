package com.hiessy.exercise;

public class MyTuple<K, V> {
    private K key;
    private V value;

    public MyTuple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}
