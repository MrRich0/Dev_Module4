package tasks.inculcation;

public class MaxSalary {
    private String name;
    private int salary;

    public MaxSalary(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", salary=" + salary
                ;
    }
}
