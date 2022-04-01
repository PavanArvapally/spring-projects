package com.springboot.workers.crudapi.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.mapper.WorkerMapper;

@Repository
public class WorkerRepository implements WorkerDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int add(Worker worker) {
		String query = "INSERT INTO Worker VALUES (?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(query, worker.getWorkerId(), worker.getFirstName(), worker.getLastName(),
				worker.getSalary(), worker.getJoiningDate(), worker.getDepartment(), worker.getEmail());
	}

	@Override
	public int delete(int workerId) {
		String query = "DELETE FROM Worker where worker_id = ?";
		return jdbcTemplate.update(query, workerId);
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public Worker getWorker(int workerId) {
		String query = "SELECT * FROM Worker WHERE Worker_id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { workerId }, new WorkerMapper());
	}

	@Override
	public List<Worker> getWorkers() {
		String query = "SELECT * FROM Worker";
		List<Worker> list = jdbcTemplate.query(query, new WorkerMapper());
		return list;
	}

	@Override
	public int replace(Worker emp) {
		String query = "UPDATE worker SET first_name=?,last_name=?,salary=?,joining_date=?,department=?,email=? where worker_id=?";
		;
		return jdbcTemplate.update(query, emp.getFirstName(), emp.getLastName(), emp.getSalary(),
				emp.getJoiningDate(), emp.getDepartment(), emp.getEmail(), emp.getWorkerId());
		
	}

	@Override
	public boolean updateWorkerEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}

