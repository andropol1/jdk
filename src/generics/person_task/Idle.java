package generics.person_task;

public class Idle implements Person {
    @Override
    public void doWork() {
        System.out.println("I can't work");
    }
}
