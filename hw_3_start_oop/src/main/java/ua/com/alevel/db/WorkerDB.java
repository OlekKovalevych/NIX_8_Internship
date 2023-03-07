package ua.com.alevel.db;

import ua.com.alevel.entity.Worker;

import java.util.Objects;
import java.util.UUID;

public class WorkerDB {

    private static final int START_ARRAY_SIZE = 30;
    private static Worker[] workers = new Worker[START_ARRAY_SIZE];

    public void create(final Worker worker) {
        worker.setId(generateId());
        boolean dataRecordingCapability = false;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] == null) {
                workers[i] = worker;
                dataRecordingCapability = true;
                break;
            }
        }
        if (dataRecordingCapability) {
            return;
        }
        this.increasingArray(worker);
    }

    private void increasingArray(Worker worker) {
        final Worker[] newArray = new Worker[workers.length + START_ARRAY_SIZE];
        System.arraycopy(workers, 0, newArray, 0, workers.length);
        workers = newArray;
        workers[workers.length] = worker;
    }

    public void update(final Worker worker) {//worker
        Worker current = this.findById(worker.getId());
        if (current != null) {
            current.setFirstName(worker.getFirstName());
            current.setPatronymic(worker.getPatronymic());
            current.setLastName(worker.getLastName());
        }
    }

    public Worker findById(final String id) {
        int i;
        for (i = 0; i < workers.length; i++) {
            if (workers[i] == null) {
                break;
            }
            if (Objects.equals(workers[i].getId(), id)) {
                return workers[i];
            }
        }
        return null;
    }

    public Worker[] findAll() {
        int sizeResultArray = 0;
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] == null) {
                sizeResultArray = i;
                break;
            }
        }
        final Worker[] newResultArray = new Worker[sizeResultArray];
        System.arraycopy(workers, 0, newResultArray, 0, sizeResultArray);
        return newResultArray;
    }

    public void delete(final String id) {
        int workerDeletePoint = 0;
        for (int i = 0; i < workers.length; i++) {
            if (null != workers[i] && id.equals(workers[i].getId())) {
                workers[i] = null;
                workerDeletePoint = i;
                break;
            }
        }
        final Worker[] newArray = new Worker[workers.length];

        System.arraycopy(workers, 0, newArray, 0, workerDeletePoint);
        System.arraycopy(workers, workerDeletePoint + 1, newArray, workerDeletePoint, workers.length - (workerDeletePoint + 1));
        workers = newArray;

    }


    private String generateId() {
        String id;
        do {
            id = this.generateStringUUID();
        } while (this.existId(id));
        return id;
    }

    private boolean existId(final String id) {
        for (final Worker worker : workers) {
            if (null == worker) break;
            if (id.equals(worker.getId())) {
                return true;
            }
        }
        return false;
    }

    private String generateStringUUID() {
        return UUID.randomUUID().toString();
    }
}
