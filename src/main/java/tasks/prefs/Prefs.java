package tasks.prefs;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    public static final String JDBC_CONNECTION_URL = "jdbcUrl";
    public static final String INIT_DB_SQL_FILE_PATH = "initDbSql";
    public static final String INSERT_DB_SQL_FILE_PATH = "insertDbSql";
    public static final String  MAX_SALARY_SQL_FILE_PATH = "maxSalaryDb";
    public static final String LONGEST_PROJECT_SQL_FILE_PATH = "longestProjectDb";
    public static final String MAX_PROJECT_CLIENT_SQL_FILE_PATH = "maxProjectsClientDb";
    public static final String YOUNGEST_ELDEST_WORKER_SQL_FILE_PATH = "youngestEldestWorkerDb";
    public static final String PROJECT_PRICES_SQL_FILE_PATH = "projectPricesDb";
    private Map<String, Object> prefs = new HashMap<>();

    public Prefs(){
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String filename) {
        try {
            String json = String.join("\n", Files.readAllLines(Paths.get(filename)));
            prefs = new Gson().fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getString(String key){
        return  prefs.get(key).toString();
    }
}
