package generics.pair;

public class Pair<T1, T2> {
    private T1 valueT1;
    private T2 valueT2;
    private static int pairCounter;
    private int pairID;


    public Pair(T1 valueT1, T2 valueT2) {
        this.valueT1 = valueT1;
        this.valueT2 = valueT2;
        pairID = ++pairCounter;
    }

    public T1 getFirst() {return valueT1;}

    public T2 getSecond() {return valueT2;}

    @Override
    public String toString() {
        return "Pair " + pairID + ": (" +
                "First value: " + valueT1 +
                ", Second value: " + valueT2 +
                ')';
    }
}
