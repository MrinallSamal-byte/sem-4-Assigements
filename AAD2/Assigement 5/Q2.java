import java.util.*;

public class Q2 {
    static class E implements Comparable<E> {
        int u, v, w;
        E(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
        public int compareTo(E o) { return w - o.w; }
    }

    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n + 1];
            r = new int[n + 1];
            for (int i = 0; i <= n; i++) p[i] = i;
        }
        int find(int x) { return p[x] == x ? x : (p[x] = find(p[x])); }
        boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (r[a] < r[b]) p[a] = b;
            else if (r[b] < r[a]) p[b] = a;
            else { p[b] = a; r[a]++; }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<E> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) edges.add(new E(sc.nextInt(), sc.nextInt(), sc.nextInt()));

        Collections.sort(edges);
        DSU d = new DSU(n);
        List<E> mst = new ArrayList<>();
        int sum = 0;

        for (E e : edges) {
            if (!d.union(e.u, e.v)) continue;
            mst.add(e);
            sum += e.w;
            if (mst.size() == n - 1) break;
        }

        if (mst.size() != n - 1) System.out.println("MST not possible");
        else {
            for (E e : mst) System.out.println(e.u + " " + e.v + " " + e.w);
            System.out.println("Weight = " + sum);
        }
        sc.close();
    }
}
