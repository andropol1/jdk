package generics.person_task;

public class App {
    public static void main(String[] args) {
        Person[] persons = {new Worker(), new Idle(), new Worker(), new Worker()};
        Place<Person> workplace = new Workplace<>(persons);
        Place<Person> club = new Club<>(persons);
        while (workplace.getPlaceIterator().hasNext()){
            workplace.getPlaceIterator().next().doWork();
        }
        System.out.println("---".repeat(5));
        while (club.getPlaceIterator().hasNext()){
            club.getPlaceIterator().next().haveRest();
        }
    }
}
