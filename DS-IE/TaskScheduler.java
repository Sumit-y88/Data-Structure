import java.util.Scanner;

class Task {
    String name;
    int priority; // Higher number = higher priority

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

class PriorityQueueCustom {
    Task[] tasks;
    int size, capacity;

    PriorityQueueCustom(int capacity) {
        this.capacity = capacity;
        tasks = new Task[capacity];
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    void enqueue(Task task) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add task.");
            return;
        }
        tasks[size] = task;
        size++;
    }

    Task dequeueHighestPriority() {
        if (isEmpty()) {
            return null;
        }

        int highestPriorityIndex = 0;
        for (int i = 1; i < size; i++) {
            if (tasks[i].priority > tasks[highestPriorityIndex].priority) {
                highestPriorityIndex = i;
            }
        }

        Task highestTask = tasks[highestPriorityIndex];

        for (int i = highestPriorityIndex; i < size - 1; i++) {
            tasks[i] = tasks[i + 1];
        }

        size--;
        return highestTask;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("No tasks scheduled.");
            return;
        }
        System.out.println("Tasks in Scheduler:");
        for (int i = 0; i < size; i++) {
            System.out.println("- " + tasks[i].name + " (Priority: " + tasks[i].priority + ")");
        }
    }

    void rescheduleTask(String taskName, int newPriority) {
        for (int i = 0; i < size; i++) {
            if (tasks[i].name.equalsIgnoreCase(taskName)) {
                tasks[i].priority = newPriority;
                System.out.println("Task '" + taskName + "' rescheduled with new priority: " + newPriority);
                return;
            }
        }
        System.out.println("Task not found.");
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueueCustom scheduler = new PriorityQueueCustom(10);

        while (true) {
            System.out.println("\n=== Task Scheduler Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. Run Next Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Reschedule a Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter priority (higher = more important): ");
                    int priority = sc.nextInt();
                    scheduler.enqueue(new Task(name, priority));
                    System.out.println("Task added.");
                    break;

                case 2:
                    Task nextTask = scheduler.dequeueHighestPriority();
                    if (nextTask == null) {
                        System.out.println("No tasks to run.");
                    } else {
                        System.out.println("Running task: " + nextTask.name + " (Priority: " + nextTask.priority + ")");
                    }
                    break;

                case 3:
                    scheduler.display();
                    break;

                case 4:
                    System.out.print("Enter task name to reschedule: ");
                    String taskName = sc.nextLine();
                    System.out.print("Enter new priority: ");
                    int newPriority = sc.nextInt();
                    scheduler.rescheduleTask(taskName, newPriority);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
