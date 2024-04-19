package threads;

public class Philosopher implements Runnable {
    static private final int EATING_TIME = 500;
    private final String name;
    private final int timeToThink;
    public Philosopher(String name, int timeToThink) {
        this.name = name;
        this.timeToThink = timeToThink;
    }
    void think() {
        System.out.println(Thread.currentThread().getName() + " is thinking!");
        try {
            Thread.sleep(timeToThink);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted!");
        }
    }
    static synchronized void haveLunch() {
        try {
            Thread.sleep(EATING_TIME);
        } catch (InterruptedException e) {
            System.out.println("Is interrupted!");
        }
    }

    @Override
    public void run() {
        for (int i = 1; i < 4; i++) {
            haveLunch();
            // После приема пищи снижаем счётчик соответствующий защёлки
            switch (i) {
                case 1: Main.firstMeal.countDown();
                case 2: Main.secondMeal.countDown();
                case 3: Main.thirdMeal.countDown();
            }
            System.out.println(name + " had lunch " + i + " time(s)");
            think();
            try {
                // После размышлений дожидаемся пока все остальные философу поедят по 1 разу.
                switch (i) {
                    case 1:  Main.firstMeal.await();
                    case 2:  Main.secondMeal.await();
                    case 3:  Main.thirdMeal.await();
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted " + Thread.currentThread().getName());
            }
        }
        Main.endAllEat.countDown();
    }
}
