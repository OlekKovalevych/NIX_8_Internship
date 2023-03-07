package ua.com.alevel.service;

import ua.com.alevel.dao.WorkerDao;
import ua.com.alevel.entity.Worker;

public class WorkerService {

    private final WorkerDao workerDao;
    public WorkerService(final WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    public void create(Worker worker) {
        workerDao.create(worker);
    }

    public Worker findById(String id) {
        return workerDao.findById(id);
    }

    public Worker[] findAll() {
        return workerDao.findAll();
    }

    public void update(Worker worker) {
        workerDao.update(worker);
    }

    public void delete(String id) {
        workerDao.delete(id);
    }
}
