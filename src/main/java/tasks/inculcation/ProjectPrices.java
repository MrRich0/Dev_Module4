package tasks.inculcation;

public class ProjectPrices {
    private int id;
    private int price;

    public ProjectPrices(int id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", price=" + price
                ;
    }
}
