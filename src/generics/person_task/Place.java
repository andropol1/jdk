package generics.person_task;

import java.util.NoSuchElementException;

public abstract class Place<T extends Person> {
    T[] arrayT;
    private final PlaceIterator placeIterator = new PlaceIterator();

    public Place(T[] arrayT) {
        this.arrayT = arrayT;
    }
    abstract void start();

    public PlaceIterator getPlaceIterator() {
        return placeIterator;
    }

    public class PlaceIterator{
        private int currentIndex = 0;
        public boolean hasNext() {
            return currentIndex < arrayT.length;
        }
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return arrayT[currentIndex++];
        }
    }
}
