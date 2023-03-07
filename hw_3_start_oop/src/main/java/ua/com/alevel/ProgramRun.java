package ua.com.alevel;

import ua.com.alevel.cotroller.WorkerController;
import ua.com.alevel.dao.WorkerDao;
import ua.com.alevel.db.WorkerDB;
import ua.com.alevel.entity.Worker;
import ua.com.alevel.service.WorkerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramRun {

    public void run() {
        WorkerController controller = new WorkerController(new WorkerService(new WorkerDao(new WorkerDB())));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader, controller);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader, controller);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create worker, please enter 1");
        System.out.println("if you want update worker, please enter 2");
        System.out.println("if you want delete worker, please enter 3");
        System.out.println("if you want findById worker, please enter 4");
        System.out.println("if you want findAll worker, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader, WorkerController controller) {
        switch (position) {
            case "1":
                create(reader, controller);
                break;
            case "2":
                update(reader, controller);
                break;
            case "3":
                delete(reader, controller);
                break;
            case "4":
                findById(reader, controller);
                break;
            case "5":
                findAll(reader, controller);
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader, WorkerController controller) {
        System.out.println("WorkerController.create");
        try {
            String name = getString(reader, "Please, enter your Name:");
            String surname = getString(reader, "Please, enter your Surname:");
            String patronymic = getString(reader, "Please, enter your Patronymic:");
            Worker worker = new Worker();
            worker.setFirstName(name);
            worker.setLastName(surname);
            worker.setPatronymic(patronymic);
            controller.create(worker);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader, WorkerController controller) {
        System.out.println("WorkerController.update");
        try {
            String id = getString(reader, "Please, enter id");
            String name = getString(reader, "Please, enter your Name:");
            String surname = getString(reader, "Please, enter your Surname:");
            String patronymic = getString(reader, "Please, enter your Patronymic:");
            Worker worker = new Worker();
            worker.setId(id);
            worker.setLastName(surname);
            worker.setFirstName(name);
            worker.setPatronymic(patronymic);
            controller.update(worker);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader, WorkerController controller) {
        System.out.println("WorkerController.delete");
        try {
            String id = getString(reader, "Please, enter id");
            controller.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader, WorkerController controller) {
        System.out.println("WorkerController.findById");
        try {
            String id = getString(reader, "Please, enter id");
            Worker worker = controller.findById(id);
            if (worker == null) {
                System.out.println("worker = not found");
            } else {
                System.out.println("worker = " + worker);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader, WorkerController controller) {
        System.out.println("WorkerController.findAll");
        Worker[] workers = controller.findAll();
        if (workers != null && workers.length != 0) {
            for (int i = 0; i < workers.length; i++) {
                System.out.println("worker = " + workers[i]);
            }
        } else {
            System.out.println("worker empty");
        }
    }

    private String getString(BufferedReader reader, String messageLine) throws IOException {
        System.out.println(messageLine);
        return reader.readLine();
    }
}
