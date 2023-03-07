package ua.com.alevel.cotroller;

import ua.com.alevel.entity.Worker;
import ua.com.alevel.service.WorkerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(final WorkerService workerService) {
        this.workerService = workerService;
    }

    public void create(Worker worker) {
        workerService.create(worker);
    }

    public Worker findById(String id) {
        return workerService.findById(id);
    }

    public Worker[] findAll() {
        return workerService.findAll();
    }

    public void update(Worker worker) {
        workerService.update(worker);
    }

    public void delete(String id) {
        workerService.delete(id);
    }
}
