package com.springboot.workers.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.service.WorkerService;

@RestController
@RequestMapping("/api/v1")
public class WorkerController {
	@Autowired
	private WorkerService service;

	@GetMapping("/workers/{id}")
	public Worker getWorker(@PathVariable Integer id) {
		return service.read(id);
	}

	@GetMapping("/workers")
	public List<Worker> showWorkers() {
		return service.readAll();
	}

	@PostMapping("/workers")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Boolean create(@RequestBody Worker worker) {
		return (service.createWorker(worker));
	}

	@PatchMapping("/workers/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Boolean update(@PathVariable Integer id, @RequestBody Worker worker) {
		return (service.update(id, worker));

	}

	@DeleteMapping("/workers/{id}")
	public Boolean delete(@PathVariable Integer id) {
		return (service.delete(id));
	}

}
