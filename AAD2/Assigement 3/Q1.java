import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        int[] numbers = {23, 4, 57, 82, 95, 13, 113, 24, 72, 18};
        int tableSize = 10;
        int collisions = 0;

        ArrayList<Integer>[] hashTable = new ArrayList[tableSize];

        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new ArrayList<>();
        }

        System.out.println("Inserting elements into hash table (size = " + tableSize + ")");
        System.out.println("Hash Function: h(k) = k % " + tableSize);
        System.out.println("=".repeat(45));

        for (int num : numbers) {
            int index = num % tableSize;

            if (!hashTable[index].isEmpty()) {
                collisions++;
                System.out.printf("Inserting %3d → index %d  *** COLLISION (slot has: %s)%n",
                        num, index, hashTable[index]);
            } else {
                System.out.printf("Inserting %3d → index %d%n", num, index);
            }

            hashTable[index].add(num);
        }

        System.out.println("=".repeat(45));
        System.out.println("\nFinal Hash Table:");
        System.out.println("-".repeat(30));

        for (int i = 0; i < tableSize; i++) {
            System.out.printf("Index %d: %s%n", i, hashTable[i].isEmpty() ? "[ empty ]" : hashTable[i]);
        }

        System.out.println("-".repeat(30));
        System.out.println("Total Collisions: " + collisions);
    }
}