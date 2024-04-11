package handbook;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Handbook handbook = new Handbook(new ArrayList<>(Arrays.asList(new Employee(14,
                "554637", "Alex", 4), new Employee(15,"554638",
                "Andrey", 5))));
        // Поиск сотрудников по стажу
        for (Employee employee : handbook.getStaffBySeniority(4)) {
            System.out.println(employee.toString());
        }
        System.out.println("----".repeat(5));
        // Поиск номеров телефона по имени сотрудника
        for (Employee employee : handbook.getPhoneNumberByName("Alex")) {
            System.out.println(employee.getPhoneNumber());
        }
        System.out.println("----".repeat(5));
        // Поиск сотрудника по табельному номеру
        System.out.println(handbook.getEmployeeByServiceNumber(14));
        System.out.println("----".repeat(5));
        // Добавление нового сотрудника
        handbook.addNewEmployee();
    }
}
