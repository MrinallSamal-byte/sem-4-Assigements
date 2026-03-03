import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int[] arr = { 1, 2, 10, 8, 7, 3, 4, 6, 5, 9 };
        for (int i : arr) {
            pq.add(i);
        }
        System.out.println("Printing Priority Queue Heap : " + pq);
        System.out.print("remove elements of Priority Queue ::");
        while (pq.isEmpty() == false) {
            System.out.print(" " + pq.remove());
        }
    }
}