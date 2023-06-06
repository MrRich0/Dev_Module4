package tasks.inculcation;

public class MaxProjectClient {
    private String name;
    private int projectCount;

    public MaxProjectClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", projectCount=" + projectCount
                ;
    }
}
