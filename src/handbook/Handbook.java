package handbook;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Handbook {
    private ArrayList<Employee> staff;

    public Handbook(ArrayList<Employee> staff) {
        this.staff = staff;
    }
    public List<Employee> getStaffBySeniority(int seniority){
        List<Employee> result = new ArrayList<>();
        for (Employee employee : staff) {
            if (employee.getSeniority() == seniority){
                result.add(employee);
            }
        }
        if (result.isEmpty()){
            System.out.printf("There is no employees with %d years of seniority here", seniority);
            System.out.println();
        }
        return result;
    }
    public List<Employee> getPhoneNumberByName(String name){
        List<Employee> result = new ArrayList<>();
        for (Employee employee : staff) {
            if (employee.getName().equals(name)){
                result.add(employee);
            }
        }
        if (result.isEmpty()){
            System.out.printf("There is no employees whose name is %s", name);
            System.out.println();
        }
        return result;
    }
    public String getEmployeeByServiceNumber(int num){
        for (Employee employee : staff) {
            if (employee.getServiceNumber() == num){
                return employee.toString();
            }
        }
        return "There is no employees with " + num + " service number";
    }

    public void addNewEmployee(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите табельный номер сотрудника: ");
        int service_num = scan.nextInt();
        scan.nextLine();
        System.out.println("Введите номер телефона сотрудника: ");
        String phone_num = scan.nextLine();
        System.out.println("Введите имя сотрудника: ");
        String name = scan.nextLine();
        System.out.println("Введите стаж сотрудника: ");
        int exp= scan.nextInt();
        scan.nextLine();
        Employee employee = new Employee(service_num, phone_num, name, exp);
        staff.add(employee);
        System.out.println("Сотрудник добавлен, вот информация о нем: ");
        System.out.println(employee.toString());
    }
}