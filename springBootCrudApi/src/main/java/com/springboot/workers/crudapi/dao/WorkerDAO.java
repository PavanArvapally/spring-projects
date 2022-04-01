package com.springboot.workers.crudapi.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.crudapi.model.Worker;

public interface WorkerDAO {
	public int add(Worker worker) throws SQLException;

	public int delete(int workerId) throws SQLException;

	public Worker getWorker(int workerId) throws SQLException;

	public List<Worker> getWorkers() throws SQLException;

	public int replace(Worker worker) throws SQLException;
	
	public boolean updateWorkerEmail(String email) throws SQLException;
}
