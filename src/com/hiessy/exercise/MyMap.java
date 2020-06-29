package com.hiessy.exercise;

import java.util.NoSuchElementException;

public class MyMap<K, V> {
    private static final int LIST_INCREMENTAL_MULTIPLIER = 2;
    private int DEFAULT_SIZE = 10;
    private MyTuple<K ,V>[] tupleList = new MyTuple[DEFAULT_SIZE];

    public MyMap() {
    }

    public MyMap(int size) {
        DEFAULT_SIZE = size;
    }

    public void put(MyTuple<K, V> tuple) {
        int index = getIndexHash(tuple.getKey());
        if (tupleList[index] != null && !tupleList[index].getKey().equals(tuple.getKey())) {
            index = findEmpty(index);
        }
        if (index == -1) {
            doubleListSize(tuple);
        } else
            tupleList[index] = tuple;
    }

    public Object get(Object key) {
        int index = getIndexHash(key);
        if (tupleList[index].getKey().equals(key))
            return tupleList[index].getValue();
        else {
            for (MyTuple<K, V> tuple : tupleList)
                if ( tuple != null && tuple.getKey().equals(key))
                    return tuple.getValue();
        }
        throw new NoSuchElementException("The key: " + key + " was not found.");
    }

    public int fullSize() {
        return tupleList.length;
    }

    public int occupiedSize() {
        int counter = 0;
        for (MyTuple<K, V> tuple : tupleList)
            if (tuple != null)
                counter++;
        return counter;
    }

    private int findEmpty(int startingIndex) {
        for (int x = startingIndex + 1; x < tupleList.length; x++) {
            if (tupleList[x] == null)
                return x;
        }
        for (int x = 0; x < startingIndex; x++) {
            if (tupleList[x] == null)
                return x;
        }
        return -1;
    }

    private void doubleListSize(MyTuple<K, V> tupleToInsert) {
        MyTuple<K, V>[] oldTupleList = tupleList;
        tupleList = new MyTuple[tupleList.length * LIST_INCREMENTAL_MULTIPLIER];
        for (MyTuple<K, V> tuple : oldTupleList) {
            this.put(tuple);
        }
        this.put(tupleToInsert);
    }

    private int getIndexHash(Object key) {
        return key.hashCode() % tupleList.length;
    }

}
