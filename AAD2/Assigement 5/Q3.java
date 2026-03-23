import java.util.*;

public class Q3 {
    static class E {
        int v, w;
        E(int v, int w) { this.v = v; this.w = w; }
    }

    static class S implements Comparable<S> {
        int u, d;
        S(int u, int d) { this.u = u; this.d = d; }
        public int compareTo(S o) { return d - o.d; }
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
        int src = sc.nextInt();

        int INF = Integer.MAX_VALUE / 4;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        PriorityQueue<S> pq = new PriorityQueue<>();
        pq.add(new S(src, 0));

        while (!pq.isEmpty()) {
            S cur = pq.poll();
            if (cur.d != dist[cur.u]) continue;
            for (E e : g.get(cur.u)) {
                int nd = cur.d + e.w;
                if (nd >= dist[e.v]) continue;
                dist[e.v] = nd;
                pq.add(new S(e.v, nd));
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + (dist[i] == INF ? "INF" : dist[i]));
        }
        sc.close();
    }
}
