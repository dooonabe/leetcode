package com.dooonabe.collection.map;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * Created on 2019/3/24.
 */
abstract class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    private static final int SIZE = 997;
    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    /**
     * {@inheritDoc}
     *
     * @param key
     * @throws ClassCastException   {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @implSpec This implementation iterates over <tt>entrySet()</tt> searching
     * for an entry with the specified key.  If such an entry is found,
     * the entry's value is returned.  If the iteration terminates without
     * finding such an entry, <tt>null</tt> is returned.  Note that this
     * implementation requires linear time in the size of the map; many
     * implementations will override this method.
     */
    @Override
    public V get(Object key) {
        V value = null;
        int index = hash((K) key);
        if (buckets[index] == null) {
        } else {
            ListIterator<MapEntry<K, V>> it = buckets[index].listIterator();
            while (it.hasNext()) {
                MapEntry<K, V> iPair = it.next();
                if (iPair.getKey().equals(key)) {
                    value = iPair.getValue();
                    break;
                }
            }
        }
        return value;
    }

    /**
     * {@inheritDoc}
     *
     * @param key
     * @param value
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @implSpec This implementation always throws an
     * <tt>UnsupportedOperationException</tt>.
     */
    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        //new mapentry
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            // overwrite value
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        //list add
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }
}
