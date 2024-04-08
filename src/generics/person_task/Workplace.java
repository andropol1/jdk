package generics.person_task;

public class Workplace<T extends Person> extends Place {
    public Workplace(T[] arrayT) {
        super(arrayT);
    }

    @Override
    void start() {
        for (int i = 0; i < arrayT.length; i++) {
            arrayT[i].doWork();
        }
    }
}
