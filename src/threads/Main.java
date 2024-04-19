package threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/* Задание 1. В качестве задачи предлагается решить
классическую задачу про обедающих философов
Условие:
● Есть пять философов (потоки), которые могут либо
обедать (выполнение кода) либо размышлять
(ожидание).
● Каждый философ должен пообедать три раза. Каждый
прием пищи длиться 500 миллисекунд
● После каждого приема пищи философ должен
размышлять
● Не должно возникнуть общей блокировки
● Философы не должны есть больше одного раза подряд
*/
public class Main {
    static CountDownLatch endAllEat = new CountDownLatch(5);
    static CountDownLatch firstMeal = new CountDownLatch(5);
    static CountDownLatch secondMeal = new CountDownLatch(5);
    static CountDownLatch thirdMeal = new CountDownLatch(5);
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            String name = "philosopher" + i;
            new Thread(new Philosopher(name, new Random().nextInt(1500) + 500), name).start();

        }
        // Проверка на корректность завершения работы всех потоков
        try {
            endAllEat.await();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted!");
        }
    }
}