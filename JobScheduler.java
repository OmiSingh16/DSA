/* import java.util.*;

// Job class to represent each job
class Job {
    char id;
    int deadline;
    int profit;
    
    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing1 {
    
    public static void jobSequence(Job[] jobs) {
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        
        // Find maximum deadline to determine time slots
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        
        // Array to track free time slots
        boolean[] slots = new boolean[maxDeadline + 1];
        // Min-heap to store selected jobs (based on profit)
        PriorityQueue<Character> result = new PriorityQueue<>();
        int totalProfit = 0;
        
        // Iterate through all jobs
        for (Job job : jobs) {
            // Find a free slot for this job (starting from the last possible slot)
            for (int i = Math.min(maxDeadline, job.deadline); i > 0; i--) {
                if (!slots[i]) {
                    // Slot found, assign job to this slot
                    slots[i] = true;
                    result.offer(job.id); // Add to result queue
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        // Print the result
        System.out.print("Selected Jobs: ");
        while (!result.isEmpty()) {
            System.out.print(result.poll());
            if (!result.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
    
    // Alternative approach using Priority Queue for sorting
    public static void jobSequenceWithPQ(Job[] jobs) {
        // Max-heap to store jobs based on profit (highest profit first)
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        
        // Add all jobs to priority queue
        for (Job job : jobs) {
            pq.offer(job);
        }
        
        // Find maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        
        // Array to track scheduled jobs
        char[] result = new char[maxDeadline + 1];
        boolean[] occupied = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        
        // Process jobs in order of decreasing profit
        while (!pq.isEmpty()) {
            Job job = pq.poll();
            
            // Try to schedule job at the latest possible time
            for (int i = Math.min(maxDeadline, job.deadline); i > 0; i--) {
                if (!occupied[i]) {
                    occupied[i] = true;
                    result[i] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        // Print the sequence
        System.out.print("Selected Jobs: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (occupied[i]) {
                System.out.print(result[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
    
    public static void main(String[] args) {
        // Sample input from the problem
        Job[] jobs = {
            new Job('a', 4, 20),
            new Job('b', 1, 10),
            new Job('c', 1, 40),
            new Job('d', 1, 30)
        };
        
        System.out.println("=== Method 1: Using Array Sorting ===");
        jobSequence(jobs);
        
        System.out.println("\n=== Method 2: Using Priority Queue ===");
        jobSequenceWithPQ(jobs);
    }
} */

//  Better Optimize Code snippet.

import java.util.*;

class Job {
    char id;
    int deadline;
    int profit;
    
    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduler {
    
    public static void jobSequenceWithPQ(Job[] jobs) {
        // Max-heap to store jobs based on profit (highest profit first)
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        
        // Add all jobs to priority queue
        for (Job job : jobs) {
            pq.offer(job);
        }
        
        // Find maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        
        // Array to track scheduled jobs
        char[] result = new char[maxDeadline + 1];
        boolean[] occupied = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        
        // Process jobs in order of decreasing profit
        while (!pq.isEmpty()) {
            Job job = pq.poll();
            
            // Try to schedule job at the latest possible time
            for (int i = Math.min(maxDeadline, job.deadline); i > 0; i--) {
                if (!occupied[i]) {
                    occupied[i] = true;
                    result[i] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        
        // Print the sequence
        System.out.print("Selected Jobs: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (occupied[i]) {
                System.out.print(result[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
    
    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 4, 20),
            new Job('b', 1, 10),
            new Job('c', 1, 40),
            new Job('d', 1, 30)
        };
        
        jobSequenceWithPQ(jobs);
    }
}