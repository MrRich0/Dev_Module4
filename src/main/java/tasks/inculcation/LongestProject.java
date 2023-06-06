package tasks.inculcation;

public class LongestProject {
    private int id;
    private String startDate;
    private String finishDate;
    private int monthCount;

    public LongestProject(int id, String startDate, String finishDate, int monthCount) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", monthCount=" + monthCount
                ;
    }
}
