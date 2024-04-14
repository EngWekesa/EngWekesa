import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String name) {
        Task task = new Task(name);
        tasks.add(task);
        System.out.println("Task added: " + name);
    }

    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
            System.out.println("Task completed: " + task.getName());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        System.out.println("ToDo List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isCompleted() ? "[X]" : "[ ]";
            System.out.println(i + ". " + status + " " + task.getName());
        }
    }
}

public class ToDoApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nToDo App Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Complete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter the task name: ");
                scanner.nextLine(); // Consume the newline character
                String taskName = scanner.nextLine();
                toDoList.addTask(taskName);
            } else if (choice == 2) {
                System.out.print("Enter the task index: ");
                int taskIndex = scanner.nextInt();
                toDoList.completeTask(taskIndex);
            } else if (choice == 3) {
                toDoList.displayTasks();
            } else if (choice == 4) {
                System.out.println("Exiting ToDo App...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}