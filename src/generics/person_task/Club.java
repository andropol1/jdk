package generics.person_task;

public class Club<T extends Person> extends Place {

    public Club(Person[] arrayT) {
        super(arrayT);
    }

    @Override
    void start() {
        for (int i = 0; i < arrayT.length; i++) {
            arrayT[i].haveRest();
        }
    }
}
