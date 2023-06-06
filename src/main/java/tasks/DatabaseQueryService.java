package tasks;

import tasks.inculcation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tasks.prefs.Prefs;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class DatabaseQueryService {
    public List<MaxSalary> findMaxSalary(DataBase dataBase){

        List<MaxSalary> listOfMaxSalary = new ArrayList<>();

        try {
            String maxSalaryFilename = new Prefs().getString(Prefs.MAX_SALARY_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(maxSalaryFilename)));

            ResultSet rs = dataBase.executeQuery(sql);
            while (rs.next()){
                listOfMaxSalary.add(new MaxSalary(
                        rs.getString("name"),
                        rs.getInt("salary")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        dataBase.close();
        return listOfMaxSalary;
    }

    public List<LongestProject> findLongestProject(DataBase dataBase){

        List<LongestProject> listOfLongestProject = new ArrayList<>();

        try {
            String longestProjectFilename = new Prefs().getString(Prefs.LONGEST_PROJECT_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(longestProjectFilename)));

            ResultSet rs = dataBase.executeQuery(sql);
            while (rs.next()){
                listOfLongestProject.add(new LongestProject(
                        rs.getInt("id"),
                        rs.getString("start_date"),
                        rs.getString("finish_date"),
                        rs.getInt("month_count")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        dataBase.close();
        return listOfLongestProject;
    }

    public List<MaxProjectClient> findMaxProjectClient(DataBase dataBase){

        List<MaxProjectClient> listOfMaxProjectClient = new ArrayList<>();

        try {
            String maxProjectClientFilename = new Prefs().getString(Prefs.MAX_PROJECT_CLIENT_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(maxProjectClientFilename)));

            ResultSet rs = dataBase.executeQuery(sql);
            while (rs.next()){
                listOfMaxProjectClient.add(new MaxProjectClient(
                        rs.getString("name"),
                        rs.getInt("project_count")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        dataBase.close();
        return listOfMaxProjectClient;
    }

    public List<YoungestEldestWorkers> findMYoungestEldestWorkers(DataBase dataBase){

        List<YoungestEldestWorkers> listOfYoungestEldestWorkers = new ArrayList<>();

        try {
            String youngestEldestWorkersFilename = new Prefs().getString(Prefs.YOUNGEST_ELDEST_WORKER_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(youngestEldestWorkersFilename)));

            ResultSet rs = dataBase.executeQuery(sql);
            while (rs.next()){
                listOfYoungestEldestWorkers.add(new YoungestEldestWorkers(
                        rs.getString("type"),
                        rs.getString("name"),
                        rs.getString("birthday")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        dataBase.close();
        return listOfYoungestEldestWorkers;
    }

    public List<ProjectPrices> printProjectPrices(DataBase dataBase){

        List<ProjectPrices> listOfProjectPrices = new ArrayList<>();

        try {
            String projectPricesFilename = new Prefs().getString(Prefs.PROJECT_PRICES_SQL_FILE_PATH);
            String sql = String.join(
                    "\n", Files.readAllLines(Paths.get(projectPricesFilename)));

            ResultSet rs = dataBase.executeQuery(sql);
            while (rs.next()){
                listOfProjectPrices.add(new ProjectPrices(
                        rs.getInt("id"),
                        rs.getInt("price")));
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        dataBase.close();
        return listOfProjectPrices;
    }
}
