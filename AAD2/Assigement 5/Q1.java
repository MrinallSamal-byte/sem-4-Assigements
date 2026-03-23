import java.util.*;

class Q1 {
    static class E {
        int v, w;
        E(int v, int w) { this.v = v; this.w = w; }
    }

    static class S implements Comparable<S> {
        int u, p, w;
        S(int u, int p, int w) { this.u = u; this.p = p; this.w = w; }
        public int compareTo(S o) { return w - o.w; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        List<List<E>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            g.get(u).add(new E(v, w));
            g.get(v).add(new E(u, w));
        }

        boolean[] vis = new boolean[n + 1];
        PriorityQueue<S> pq = new PriorityQueue<>();
        List<int[]> mst = new ArrayList<>();
        int sum = 0, seen = 0;
        pq.add(new S(1, -1, 0));

        while (!pq.isEmpty()) {
            S cur = pq.poll();
            if (vis[cur.u]) continue;
            vis[cur.u] = true;
            seen++;
            if (cur.p != -1) {
                mst.add(new int[] {cur.p, cur.u, cur.w});
                sum += cur.w;
            }
            for (E e : g.get(cur.u)) if (!vis[e.v]) pq.add(new S(e.v, cur.u, e.w));
        }

        if (seen != n) System.out.println("MST not possible");
        else {
            for (int[] e : mst) System.out.println(e[0] + " " + e[1] + " " + e[2]);
            System.out.println("Weight = " + sum);
        }
        sc.close();
    }
}