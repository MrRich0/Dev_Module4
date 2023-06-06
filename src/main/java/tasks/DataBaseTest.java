package tasks;

public class DataBaseTest {
    public static void main(String[] args) {
        DataBase dataBase = DataBase.getInstance();


        //System.out.println(new DatabaseQueryService().findMaxSalary(dataBase));
        //System.out.println(new DatabaseQueryService().findLongestProject(dataBase));
        //System.out.println(new DatabaseQueryService().findMaxProjectClient(dataBase));
        //System.out.println(new DatabaseQueryService().findMYoungestEldestWorkers(dataBase));
        System.out.println(new DatabaseQueryService().printProjectPrices(dataBase));
    }
}
