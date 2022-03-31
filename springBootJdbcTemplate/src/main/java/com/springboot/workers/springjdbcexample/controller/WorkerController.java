package com.springboot.workers.springjdbcexample.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.springjdbcexample.model.Worker;
import com.springboot.workers.springjdbcexample.repository.WorkerRepository;


@RestController
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepository repository;

	@GetMapping("/showWorker")
	public Worker showWorker() {
		return repository.getWorker(1);
	}

	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		return repository.getWorkers();
	}

	@GetMapping("/create")
	public String create() {
		repository.add(
				new Worker(10, "Pavan", "Arvapally", 10000, Date.valueOf("2022-03-31"), "IT", "pavan.a@gmail.com"));
		return "Worker Created Successfully";
	}

	@GetMapping("/update")
	public String update() {
		repository.update(new Worker(10, "Pavan", "Arvapally", 10000, Date.valueOf("2022-03-31"), "IT",
				"mfs.akash@gmail.com"));

		return "Record Updated Successfully";
	}
	
	@GetMapping("/delete")
	public String delete() {
		repository.delete(10);
		return "Record deleted successfully";
	}

}
