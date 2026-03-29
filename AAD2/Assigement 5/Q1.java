import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] g = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = sc.nextInt();

        boolean[] vis = new boolean[n];
        int[] key = new int[n];
        int[] parent = new int[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;

        for (int c = 0; c < n - 1; c++) {
            int u = -1, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!vis[i] && key[i] < min) {
                    min = key[i];
                    u = i;
                }
            }

            vis[u] = true;

            for (int v = 0; v < n; v++) {
                if (g[u][v] != 0 && !vis[v] && g[u][v] < key[v]) {
                    key[v] = g[u][v];
                    parent[v] = u;
                }
            }
        }

        int cost = 0;
        System.out.println("Edges in MST:");
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + " : " + g[i][parent[i]]);
            cost += g[i][parent[i]];
        }
        System.out.println("Total cost = " + cost);
    }
}