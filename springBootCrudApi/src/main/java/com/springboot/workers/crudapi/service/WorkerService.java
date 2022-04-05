package com.springboot.workers.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;

	public Worker read(Integer id) {
		return repository.getWorker(id);
	}

	public List<Worker> readAll() {
		return repository.getWorkers();
	}

	public Boolean createWorker(Worker worker) {
		return (repository.add(worker) == 1);
	}

	public Boolean update(Integer id, Worker worker) {
		return (repository.replace(worker) == 1);

	}

	public Boolean delete(Integer id) {
		return (repository.delete(id) == 1);
	}

}
