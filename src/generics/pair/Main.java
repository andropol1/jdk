package generics.pair;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pair<String, Integer>> pairList = List.of(new Pair<>("Steak", 7),
                new Pair<>("Mark", 6),
                new Pair<>("House", 8));
        System.out.println(pairList);
    }
}
