package tasks;

import tasks.prefs.Prefs;

import java.sql.*;

public class DataBase {
    private static final DataBase INSTANCE = new DataBase();

    private Connection connection;

    private DataBase(){
        try {
            String connectionUrl = new Prefs().getString(Prefs.JDBC_CONNECTION_URL);
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static DataBase getInstance(){
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public int executeUpdate(String sql){
        try (Statement st = connection.createStatement()){
            return st.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public ResultSet executeQuery(String sql){
            try {
                return connection.createStatement().executeQuery(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
