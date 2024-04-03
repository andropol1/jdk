package program_interface;

abstract class Developer implements Backendable, Frontendable {
    String name;
    int age;

    public Developer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void developGUI(){
        this.doBackendWork();
        this.doFrontendWork();
    }
}
