class ProcessNode { 
    int processId, burstTime, priority, remainingTime; 
    ProcessNode next; 

    public ProcessNode(int processId, int burstTime, int priority) { 
        this.processId = processId; 
        this.burstTime = burstTime; 
        this.priority = priority; 
        this.remainingTime = burstTime; 
        this.next = null; 
    } 
} 

class RoundRobinSchedulingLinkedList { 
    private ProcessNode head, tail; 
    private int totalWaitingTime, totalTurnAroundTime, processCount; 

    public RoundRobinSchedulingLinkedList() { 
        this.head = null; 
        this.tail = null; 
        this.totalWaitingTime = 0; 
        this.totalTurnAroundTime = 0; 
        this.processCount = 0; 
    } 

    public void addProcess(int processId, int burstTime, int priority) { 
        ProcessNode newProcess = new ProcessNode(processId, burstTime, priority); 
        if (head == null) { 
            head = tail = newProcess; 
            newProcess.next = head; 
        } else { 
            tail.next = newProcess; 
            tail = newProcess; 
            tail.next = head; 
        } 
        processCount++; 
    } 

    public void removeProcess(int processId) { 
        if (head == null) return; 

        ProcessNode temp = head, prev = null; 
        while (temp != null && temp.processId != processId) { 
            prev = temp; 
            temp = temp.next; 
            if (temp == head) break; 
        } 

        if (temp == null || temp.processId != processId) { 
            System.out.println("Process not found."); 
            return; 
        } 

        if (temp == head) { 
            head = head.next; 
            tail.next = head; 
        } else if (temp == tail) { 
            prev.next = head; 
            tail = prev; 
        } else { 
            prev.next = temp.next; 
        } 
        processCount--; 
    } 

    public void scheduleProcesses(int timeQuantum) { 
        ProcessNode temp = head; 
        while (processCount > 0) { 
            if (temp.remainingTime > timeQuantum) { 
                temp.remainingTime -= timeQuantum; 
                temp = temp.next; 
            } else { 
                totalWaitingTime += (totalTurnAroundTime - temp.burstTime); 
                totalTurnAroundTime += temp.burstTime; 
                System.out.println("Process " + temp.processId + " completed."); 
                removeProcess(temp.processId); 
                temp = temp.next; 
            } 
            displayQueue(); 
        } 
    } 

    public void displayQueue() { 
        if (head == null) { 
            System.out.println("No processes in the queue."); 
            return; 
        } 
        ProcessNode temp = head; 
        do { 
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Remaining Time: " + temp.remainingTime); 
            temp = temp.next; 
        } while (temp != head); 
    } 

    public void calculateAverageTimes() { 
        if (processCount == 0) {
            System.out.println("No processes to calculate average times.");
            return;
        }
        double avgWaitingTime = (double) totalWaitingTime / processCount; 
        double avgTurnAroundTime = (double) totalTurnAroundTime / processCount; 
        System.out.println("Average Waiting Time: " + avgWaitingTime); 
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime); 
    } 
} 

public class RoundRobinScheduling { 
    public static void main(String[] args) { 
        RoundRobinSchedulingLinkedList rrScheduler = new RoundRobinSchedulingLinkedList(); 
        rrScheduler.addProcess(1, 10, 2); 
        rrScheduler.addProcess(2, 5, 1); 
        rrScheduler.addProcess(3, 8, 3); 
        rrScheduler.addProcess(4, 6, 2); 

        int timeQuantum = 4; 
        rrScheduler.scheduleProcesses(timeQuantum); 
        rrScheduler.calculateAverageTimes(); 
    } 
} 
