package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class MyPreparedStatement {
    private PreparedStatement insertStWorker;
    private PreparedStatement insertStClient;
    private PreparedStatement insertStProject;
    private PreparedStatement insertStProjectWorker;
    public MyPreparedStatement(DataBase dataBase) throws SQLException {
        Connection connection = dataBase.getConnection();

        insertStWorker = connection.prepareStatement(
                "INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES ( ?, ?, ?, ?) "
        );
        insertStClient = connection.prepareStatement(
                "INSERT INTO client (NAME) VALUES ( ?)"
        );
        insertStProject = connection.prepareStatement(
                "INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES ( ?, ?, ?)"
        );
        insertStProjectWorker = connection.prepareStatement(
                "INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES ( ?, ?)"
        );
    }

    public int insertIntoWorker(String name, LocalDate birthday, String level, Integer salary)  {
        try {
            insertStWorker.setString(1, name);
            insertStWorker.setString(2, birthday.toString());
            insertStWorker.setString(3, level);
            insertStWorker.setInt(4, salary);

            return insertStWorker.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
            return -1;
    }

    public int inserIntotClient(String name)  {
        try {
            insertStClient.setString(1, name);

            return insertStClient.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insertIntoProject(int id, LocalDate startDate, LocalDate finishDate)  {
        try {
            insertStProject.setInt(1, id);
            insertStProject.setString(2,startDate.toString());
            insertStProject.setString(3,finishDate.toString());

            return insertStProject.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int insertIntoProjectWorker(int projectID, int workerID)  {
        try {
            insertStProjectWorker.setInt(1, projectID);
            insertStProjectWorker.setInt(2,workerID);

            return insertStProjectWorker.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
