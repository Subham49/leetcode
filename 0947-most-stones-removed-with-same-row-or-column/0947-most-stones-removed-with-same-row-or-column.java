class Solution {
    void fun(boolean vis[], int node, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = true;
        for(Integer child : adj.get(node))
        {
            if(!vis[child])
            {
                fun(vis, child, adj);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int com = 0;
        for(int i=0; i<n; i++)
        {
            if(!vis[i])
            {
                com++;
                fun(vis, i, adj);
            }
        }
        return n - com;
    }
}