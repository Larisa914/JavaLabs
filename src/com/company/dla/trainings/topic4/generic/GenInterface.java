package com.company.dla.trainings.topic4.generic;

public class GenInterface {
    interface MinMax<T extends Comparable<T>> {
        T max();
    }
//
//    interface MinMax {
//        Comparable max();
//    }

    static class MyClass<T extends Comparable<T>> implements MinMax<T> {
        //        static T staticT;
        T[] vals;
        MyClass(T[] o) {
//            new T();
            vals = o;
        }

        public T max() {
            T v = vals[0];
            for (int i = 1; i < vals.length; i++) {
                if (vals[i].compareTo(v) > 0) {
                    v = vals[i];
                }
            }
            return v;
        }
    }

//    static class MyClass implements MinMax {
//        Comparable[] vals;
//        MyClass(Comparable[] o) {
//            vals = o;
//        }
//
//        public Comparable max() {
//            Comparable v = vals[0];
//            for (int i = 1; i < vals.length; i++) {
//                if (vals[i].compareTo(v) > 0) {
//                    v = vals[i];
//                }
//            }
//            return v;
//        }
//    }

    public static void main(String args[]) {
        Integer inums[] = { 3, 6, 2, 8, 6 };
        Character chs[] = { 'b', 'r', 'p', 'w' };

        MyClass<Integer> a = new MyClass<>(inums);
//        MyClass a = new MyClass(inums);

        MyClass<Character> b = new MyClass<>(chs);
//        MyClass b = new MyClass(chs);

        System.out.println(a.max());
//        System.out.println((Integer)a.max());

        System.out.println(b.max());
//        System.out.println((Character)b.max());
    }
}
