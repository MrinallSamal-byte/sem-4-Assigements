import java.util.LinkedList;

public class Q4 {

    static LinkedList<Integer>[] hashTable;
    static int tableSize = 10;

    static void insert(int num) {
        int index = num % tableSize;
        if (!hashTable[index].isEmpty()) {
            System.out.printf("Inserting %3d → index %d *** COLLISION (chain has: %s)%n",
                    num, index, hashTable[index]);
        } else {
            System.out.printf("Inserting %3d → index %d (no collision)%n", num, index);
        }
        hashTable[index].add(num);
    }

    static int countCollisions() {
        int collisions = 0;
        for (LinkedList<Integer> chain : hashTable) {
            if (chain.size() > 1) {
                collisions += chain.size() - 1;
            }
        }
        return collisions;
    }

    static void display() {
        System.out.println("\nFinal Hash Table:");
        System.out.println("-".repeat(35));
        for (int i = 0; i < tableSize; i++) {
            if (hashTable[i].isEmpty()) {
                System.out.printf("Index %d: [ empty ]%n", i);
            } else {
                StringBuilder chain = new StringBuilder();
                for (int j = 0; j < hashTable[i].size(); j++) {
                    chain.append("[").append(hashTable[i].get(j)).append("]");
                    if (j < hashTable[i].size() - 1) chain.append(" → ");
                }
                System.out.printf("Index %d: %s%n", i, chain);
            }
        }
        System.out.println("-".repeat(35));
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int[] numbers = {23, 4, 57, 82, 95, 13, 113, 24, 72, 18};

        hashTable = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = new LinkedList<>();
        }

        System.out.println("Inserting elements using Separate Chaining (size = " + tableSize + ")");
        System.out.println("Hash Function: h(k) = k % " + tableSize);
        System.out.println("=".repeat(55));

        for (int num : numbers) {
            insert(num);
        }

        System.out.println("=".repeat(55));
        display();
        System.out.println("Total Collisions: " + countCollisions());
    }
}
