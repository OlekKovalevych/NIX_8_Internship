package ua.com.alevel.dao;

import ua.com.alevel.db.WorkerDB;
import ua.com.alevel.entity.Worker;

public class WorkerDao {

    private final WorkerDB db;
    public WorkerDao(final WorkerDB db) {
        this.db = db;
    }

    public void create(Worker worker) {
        db.create(worker);
    }

    public Worker findById(String id) {
        return db.findById(id);
    }

    public Worker[] findAll() {
        return db.findAll();
    }

    public void update(Worker worker) {
        db.update(worker);
    }

    public void delete(String id) {
        db.delete(id);
    }
}
