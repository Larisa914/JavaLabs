package com.company.dla.lab8;

//todo неиспользуемые generic типы. Или убрать или генерализовать Entry и HashMapImpl
public class Entry<K, V> {
    Object key;
    Object val;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        return key == null ? 0 : 13 * 11 + key.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return this.key == ((Entry) o).key;
    }
}
