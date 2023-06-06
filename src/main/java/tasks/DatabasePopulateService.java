package tasks;

import tasks.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public void inserttDb(DataBase dataBase){
        try {
            String insertDbFilename = new Prefs().getString(Prefs.INSERT_DB_SQL_FILE_PATH);
            String sql = String.join("\n", Files.readAllLines(Paths.get(insertDbFilename)));
            dataBase.executeUpdate(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dataBase.close();
    }
}
