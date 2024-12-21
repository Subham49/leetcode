class Solution {
    int fun(int curr, int par, ArrayList<ArrayList<Integer>> adj, int val[], int k, int[] com) {
        int sum = 0;
        for(int ch : adj.get(curr)) {
            if(ch != par) {
                sum += fun(ch, curr, adj, val, k, com);
            }
            sum %= k;
        }
        sum += val[curr];
        sum %= k;
        if(sum == 0) com[0]++;
        return sum;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int e[] : edges){
            adj.get(e[1]).add(e[0]);
            adj.get(e[0]).add(e[1]);
        }
        int com[] = new int[]{0};
        fun(0, -1, adj, values, k, com);
        return com[0];
    }
}