class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Pair<Integer, Double>>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(new Pair<>(edges[i][1], succProb[i]));
            adj[edges[i][1]].add(new Pair<>(edges[i][0], succProb[i]));
        }

        double[] prob = new double[n];
        Arrays.fill(prob, 0);
        prob[start] = 1.0;

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        pq.add(new Pair<>(1.0, start));

        while (!pq.isEmpty()) {
            Pair<Double, Integer> curr = pq.poll();
            double currProb = curr.getKey();
            int node = curr.getValue();

            if (node == end)
                return currProb;

            for (Pair<Integer, Double> neighbor : adj[node]) {
                int adjNode = neighbor.getKey();
                double edgeProb = neighbor.getValue();

                if (prob[adjNode] < currProb * edgeProb) {
                    prob[adjNode] = currProb * edgeProb;
                    pq.add(new Pair<>(prob[adjNode], adjNode));
                }
            }
        }

        return 0.0;
    }
}