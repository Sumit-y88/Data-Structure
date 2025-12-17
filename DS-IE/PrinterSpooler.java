import java.util.Scanner;

class PrintJob {
    String fileName;
    int pages;

    PrintJob(String fileName, int pages) {
        this.fileName = fileName;
        this.pages = pages;
    }
}

class JobQueue {
    PrintJob[] jobs;
    int front, rear, size, capacity;

    JobQueue(int capacity) {
        this.capacity = capacity;
        jobs = new PrintJob[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    void enqueue(PrintJob job) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add job: " + job.fileName);
            return;
        }
        rear = (rear + 1) % capacity;
        jobs[rear] = job;
        size++;
    }

    PrintJob dequeue() {
        if (isEmpty()) {
            return null;
        }
        PrintJob job = jobs[front];
        front = (front + 1) % capacity;
        size--;
        return job;
    }

    void skipFront() {
        if (!isEmpty()) {
            PrintJob job = dequeue();
            enqueue(job);
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("No jobs in queue.");
            return;
        }
        System.out.print("Jobs: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(jobs[index].fileName + " (" + jobs[index].pages + " pages), ");
        }
        System.out.println();
    }
}

public class PrinterSpooler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JobQueue queue = new JobQueue(10);

        while (true) {
            System.out.println("\n=== Printer Spooler Menu ===");
            System.out.println("1. Add Print Job");
            System.out.println("2. Process Next Job");
            System.out.println("3. View Jobs");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter file name: ");
                    String fileName = sc.nextLine();
                    System.out.print("Enter number of pages: ");
                    int pages = sc.nextInt();
                    queue.enqueue(new PrintJob(fileName, pages));
                    System.out.println("Job added: " + fileName);
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("No jobs to print.");
                    } else {
                        PrintJob current = queue.jobs[queue.front];
                        System.out.println("Next job: " + current.fileName + " (" + current.pages + " pages)");
                        System.out.print("Print / Skip / Cancel? (p/s/c): ");
                        char action = sc.next().toLowerCase().charAt(0);
                        if (action == 'p') {
                            queue.dequeue();
                            System.out.println("Printing job........");
                        } else if (action == 's') {
                            queue.skipFront();
                            System.out.println("Job skipped to end of queue.");
                        } else if (action == 'c') {
                            queue.dequeue();
                            System.out.println("Job cancelled");
                        } else {
                            System.out.println("Invalid input");
                        }
                    }
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again!");
                    break;
            }
        }
    }
}
