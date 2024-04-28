class Solution {
    int dis[];
    int count[];
    ArrayList<ArrayList<Integer>> adj;
    
    void dfs1(int root, int prev)
    {
        for(int i : adj.get(root))
        {
            if(i == prev) continue;
            dfs1(i, root);
            count[root] = count[i]+count[root];
            dis[root] += dis[i] + count[i];
        }
    }
    void dfs2(int root, int prev)
    {
        for(int i : adj.get(root))
        {
            if(i == prev) continue;
            dis[i] = dis[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        count = new int[n];
        dis = new int[n];
        Arrays.fill(count, 1);
        adj = new ArrayList<>();
        
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int e[] : edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        dfs1(0, -1);
        // for(int i : dis) System.out.print(i+" ");
        dfs2(0, -1);
        return dis;
    }
}