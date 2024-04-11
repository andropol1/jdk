package handbook;
public class Employee {
    private int serviceNumber;
    private String phoneNumber;
    private String name;
    private int seniority;

    public Employee(int serviceNumber, String phoneNumber, String name, int seniority) {
        this.serviceNumber = serviceNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.seniority = seniority;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getSeniority() {
        return seniority;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "serviceNumber=" + serviceNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", seniority=" + seniority +
                '}';
    }
}
