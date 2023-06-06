package tasks;

import tasks.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public void initDb(DataBase dataBase){
        try {
            String initDbFilename = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);
            String sql = String.join("\n", Files.readAllLines(Paths.get(initDbFilename)));
            dataBase.executeUpdate(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dataBase.close();
    }
}
