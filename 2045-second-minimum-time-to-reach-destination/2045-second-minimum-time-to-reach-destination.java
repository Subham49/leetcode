class Solution {
    class Pair {
        int node;
        int wei;

        Pair(int node, int wei) {
            this.node = node;
            this.wei = wei;
        }
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dist1[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.wei - y.wei);
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int node = curr.node;
            int currTime = curr.wei;

            for (int neigh : adj.get(node)) {
                int nextTime = currTime + time;
                if ((currTime / change) % 2 == 1) {
                    nextTime += (change - (currTime % change));
                }

                if (nextTime < dist1[neigh]) {
                    dist2[neigh] = dist1[neigh];
                    dist1[neigh] = nextTime;
                    pq.add(new Pair(neigh, nextTime));
                }

                else if (nextTime > dist1[neigh] && nextTime < dist2[neigh]) {
                    dist2[neigh] = nextTime;
                    pq.add(new Pair(neigh, nextTime));
                }
            }
        }
        return dist2[n] == Integer.MAX_VALUE ? -1 : dist2[n];
    }
}