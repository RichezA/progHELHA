package be.helha.theorie4;

import java.util.ArrayList;

class Pair<K extends String, V> {

    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

@FunctionalInterface
interface Function {
    int apply(String s);
    default int apply2(String s) {
        return s.length() + 2;
    }
}

class MaCollection {
    ArrayList<String> tab = new ArrayList<>();

    public MaCollection() {
        tab.add("Fred");
        tab.add("Java Théorie");
    }

    public void map(Function function) {
        for(String s : tab) {
            System.out.println(function.apply(s));
        }
    }
}

public class Main {

    public static void main(String[] args) {

//        Pair p = new Pair("Test", "TTT");
//
//        ArrayList<Pair<String, Integer>> tab = new ArrayList<>();
//        tab.add(new Pair("T", 5));
//        Pair<String, Pair<String, Integer>> ps = new Pair("clé", new Pair<>("valeur", 3));
//        ps.getValue().getValue();

        Function length = new Function() {
            @Override
            public int apply(String s) {
                return s.length();
            }
        };
        Function hasA = new Function() {
            @Override
            public int apply(String s) {
                return s.contains("a") ? 1 : 0;
            }
        };

        MaCollection maCollection = new MaCollection();
        maCollection.map(length);
        maCollection.map(hasA);
        maCollection.map(new Function() {
            @Override
            public int apply(String s1) {
                return s1.length();
            }
        });
        maCollection.map(s -> s.length());
        maCollection.map(s -> {
            return s.length();
        });

        maCollection.map(String::length);
        maCollection.map(Integer::parseInt);

    }
}
