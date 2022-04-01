package com.springboot.workers.jdbcexample.repository;

import java.sql.*;
import java.util.*;
import org.springframework.stereotype.Repository;

import com.springboot.workers.jdbcexample.dao.WorkerDAO;
import com.springboot.workers.jdbcexample.model.Worker;
import com.springboot.workers.jdbcexample.util.DatabaseConnection;

@Repository
public class WorkerRepository implements WorkerDAO{
	Connection connection;


    public WorkerRepository() throws ClassNotFoundException, SQLException {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public int add(Worker worker) throws SQLException {
        String add = "INSERT INTO Worker VALUES (?,?,?,?,?,?,?)";
        int rowsEffected = 0;
        try (PreparedStatement statement = connection.prepareStatement(add);) {
            statement.setInt(1, worker.getWorkerId());
            statement.setString(2, worker.getFirstName());
            statement.setString(3, worker.getLastName());
            statement.setInt(4, worker.getSalary());
            statement.setDate(5, worker.getJoiningDate());
            statement.setString(6, worker.getDepartment());
            statement.setString(7, worker.getEmail());
            rowsEffected = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return rowsEffected;
    }

    @Override
    public void delete(int workerId) throws SQLException {
        // TODO Auto-generated method stub
        String delete = "DELETE FROM worker WHERE worker_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, workerId);
            int rowsDeleted = statement.executeUpdate();
            System.out.println(rowsDeleted + " row deleted");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Worker getWorker(int workerId) throws SQLException {
        Worker worker = null;
        String getData = "SELECT * FROM worker WHERE worker_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(getData)) {
            statement.setInt(1, workerId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                worker = new Worker(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
                        result.getDate(5), result.getString(6), result.getString(7));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return worker;
    }

    @Override
    public List<Worker> getWorkers() throws SQLException {
        List<Worker> workers = new ArrayList<Worker>();
        String allData = "SELECT * FROM worker";
        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(allData);
            while (result.next()) {
                workers.add(new Worker(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4),
                result.getDate(5), result.getString(6), result.getString(7)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return workers;
    }

    @Override
    public void update(Worker worker) throws SQLException {
        String update = "UPDATE worker SET first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
        try (PreparedStatement statement = connection.prepareStatement(update)) {
            statement.setString(1, worker.getFirstName());
            statement.setString(2, worker.getLastName());
            statement.setInt(3, worker.getSalary());
            statement.setDate(4, worker.getJoiningDate());
            statement.setString(5, worker.getDepartment());
            statement.setString(6, worker.getEmail());
            statement.setInt(7, worker.getWorkerId());

            int rowsUpdated = statement.executeUpdate();
            System.out.println(rowsUpdated + " rows updated");

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
