package com.company.dla.lab8;

public class HashMapImpl {
    private float loadfactor = 0.75f;
    private int capacity = 100;
    private int size = 0;
    private Entry table[] = new Entry[capacity];

    private int Hashing(int hashCode) {
        int location = hashCode % capacity;
        if (location < 0) location = -location;
        System.out.println("Location:"+location);
        return location;
    }

    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }
    public boolean isEmpty() {
        if(this.size == 0) {
            return true;
        }
        return false;
    }

    public boolean containsKey(Object key) {
        if(key == null) {
            if(table[0].getKey() == null) {
                return true;
            }
        }
        int location = Hashing(key.hashCode());
        Entry e = null;
        try {
            e = table[location];
        }catch(NullPointerException ex) {
        }
        if(e!= null && e.getKey() == key) {
            return true;
        }
        return false;
    }
    public boolean containsValue(Object value) {
        for(int i=0; i<table.length;i++) {
            if(table[i] != null && table[i].getVal() == value) {
                return true;
            }
        }
        return false;
    }

    public Object get(Object key) {
        Object ret = null;
        if(key == null) {
            Entry e = null;
            try{
                e = table[0];
            }catch(NullPointerException ex) {
            }
            if(e != null) {
                return e.getVal();
            }
        } else {
            int location = Hashing(key.hashCode());
            Entry e = null;
            try{
                e = table[location];
            }catch(NullPointerException ex) {
            }
            if(e!= null && key.equals(e.getKey())) { //
                return e.getVal();
            }
        }
        return ret;
    }

    public Object put(Object key, Object val) {
        Object ret = null;
        if (key == null) {
            ret = putForNullKey(val);
            return ret;
        } else {
            int location = Hashing(key.hashCode());
            if(location >= capacity) {
                System.out.println("Rehashing required");
                return null;
            }
            Entry e = null;
            try{
                e = table[location];
            }catch(NullPointerException ex) {
            }
            if (e!= null && e.getKey() == key) {
                // корзинка занята и ключ совпал
                ret = e.getVal();
                table[location].setVal(val);
                System.out.println("Для ключа "+ table[location].getKey()+" изменео значение на: "+ table[location].getVal());
                System.out.println("Старое значение: "+ ret);
            } else if (e!= null && e.getKey() != key){
                System.out.println("Локация использована!");
                System.out.println("Одновременная обработка ключей "+ key+" и "+ e.getKey()+ " невозможна");
                return null;
            }
            else
            {
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
        Entry e = null;
        try {
            e = table[0];
        }catch(NullPointerException ex) {
        }
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
        int location = Hashing(key.hashCode());
        Object ret = null;
        if(table[location].getKey() == key) {
            table[location] = null;
            size--;
        }
        return ret;
    }

}
