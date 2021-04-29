package com.company.dla.lab8;

public class HashMapImpl {
    private static final int CAPACITY = 100;
    private final Entry[] table = new Entry[CAPACITY];
    private int size = 0;

    private int hashing(int hashCode) {
        int location = hashCode % CAPACITY;
        if (location < 0) location = -location;
        System.out.println("Location:" + location);
        return location;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean containsKey(Object key) {
        if (key == null) {
            if (table[0].getKey() == null) {
                return true;
            }
        }
        int location = hashing(key.hashCode());
        Entry e = table[location];
        return e != null && e.getKey() == key;
    }

    public boolean containsValue(Object value) {
        for (Entry entry : table) {
            if (entry != null && entry.getVal() == value) {
                return true;
            }
        }
        return false;
    }

    public Object get(Object key) {
        if (key == null) {
            Entry e = table[0];
            if (e != null) {
                return e.getVal();
            }
        } else {
            int location = hashing(key.hashCode());
            Entry e = table[location];
            if (e != null && key.equals(e.getKey())) { //
                return e.getVal();
            }
        }
        return null;
    }

    public Object put(Object key, Object val) {
        Object ret = null;
        if (key == null) {
            ret = putForNullKey(val);
            return ret;
        } else {
            int location = hashing(key.hashCode());
            if (location >= CAPACITY) {
                System.out.println("Rehashing required");
                return null;
            }
            Entry e = table[location];
            if (e != null && e.getKey() == key) {
                // корзинка занята и ключ совпал
                ret = e.getVal();
                table[location].setVal(val);
                System.out.println("Для ключа " + table[location].getKey() + " изменео значение на: " + table[location].getVal());
                System.out.println("Старое значение: " + ret);
            } else if (e != null && e.getKey() != key) {
                System.out.println("Локация использована!");
                System.out.println("Одновременная обработка ключей " + key + " и " + e.getKey() + " невозможна");
                return null;
            } else {
                Entry eNew = new Entry();
                eNew.setKey(key);
                eNew.setVal(val);
                table[location] = eNew;
                size++;
            }
        }
        return ret;
    }

    private Object putForNullKey(Object val) {
        Entry e = table[0];
        Object ret = null;
        if (e != null && e.getKey() == null) {
            ret = e.getVal();
            e.setVal(val);
            return ret;
        } else {
            Entry eNew = new Entry();
            eNew.setKey(null);
            eNew.setVal(val);
            table[0] = eNew;
            size++;
        }
        return ret;
    }

    public Object remove(Object key) {
        int location = hashing(key.hashCode());
        Object ret = null;
        if (table[location].getKey() == key) {
            ret = table[location].getVal();
            table[location] = null;
            size--;
        }
        return ret;
    }

}
