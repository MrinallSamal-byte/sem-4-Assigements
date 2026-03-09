public class Q3 {
    public static void main(String[] args) {
        int[] numbers = {23, 4, 57, 82, 95, 13, 113, 24, 72, 18};
        int tableSize = 10;
        int[] hashTable = new int[tableSize];
        int collisions = 0;

        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = -1;
        }

        System.out.println("Inserting elements using Quadratic Probing (size = " + tableSize + ")");
        System.out.println("Hash Function: h(k, i) = (k % 10 + i^2) % 10");
        System.out.println("=".repeat(55));

        for (int num : numbers) {
            int originalIndex = num % tableSize;
            int index = originalIndex;
            int probe = 0;

            while (hashTable[index] != -1) {
                collisions++;
                probe++;
                index = Math.abs(originalIndex + probe * probe) % tableSize;
                System.out.printf("Inserting %3d → index %d occupied, probing index %d (i=%d)%n",
                        num, (originalIndex + (probe - 1) * (probe - 1)) % tableSize, index, probe);
            }

            hashTable[index] = num;

            if (probe == 0) {
                System.out.printf("Inserting %3d → index %d (no collision)%n", num, index);
            } else {
                System.out.printf("Inserting %3d → placed at index %d after %d probe(s)%n",
                        num, index, probe);
            }
        }

        System.out.println("=".repeat(55));
        System.out.println("\nFinal Hash Table:");
        System.out.println("-".repeat(30));

        for (int i = 0; i < tableSize; i++) {
            System.out.printf("Index %d: %s%n", i,
                    hashTable[i] == -1 ? "[ empty ]" : String.valueOf(hashTable[i]));
        }

        System.out.println("-".repeat(30));
        System.out.println("Total Collisions: " + collisions);
    }
}
