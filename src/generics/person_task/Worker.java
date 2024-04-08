package generics.person_task;

public class Worker implements Person {
    @Override
    public void haveRest() {
        System.out.println("I always work");
    }
}
