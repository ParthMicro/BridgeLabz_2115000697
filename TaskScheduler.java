class TaskNode {
    int taskId, priority;
    String taskName, dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskSchedulerLinkedList {
    private TaskNode head, tail, currentTask;

    public TaskSchedulerLinkedList() {
        this.head = this.tail = this.currentTask = null;
    }

    public void addTask(int taskId, String taskName, int priority, String dueDate, Integer position) {
        TaskNode newTask = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
            currentTask = head;
            return;
        }

        if (position == null || position == 0) {
            newTask.next = head;
            head = newTask;
            tail.next = head;
            return;
        }

        TaskNode temp = head;
        int count = 0;
        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
            tail.next = head;
        }
    }

    public void removeTask(int taskId) {
        if (head == null) return;

        TaskNode temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev;
                        tail.next = head;
                    }
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName);
            currentTask = currentTask.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void displayTasks() {
        if (head == null) return;

        TaskNode temp = head;
        System.out.println("Task List:");
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                               ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTaskByPriority(int priority) {
        if (head == null) return;

        TaskNode temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Task Found: " + temp.taskName);
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("No task found with priority: " + priority);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskSchedulerLinkedList scheduler = new TaskSchedulerLinkedList();
        scheduler.addTask(1, "Task A", 2, "2025-02-15", null);
        scheduler.addTask(2, "Task B", 1, "2025-02-16", null);
        scheduler.addTask(3, "Task C", 3, "2025-02-17", 1);
        scheduler.displayTasks();
        scheduler.viewCurrentTask();
        scheduler.searchTaskByPriority(1);
        scheduler.removeTask(2);
        scheduler.displayTasks();
    }
}
