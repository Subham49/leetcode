class Solution {
    void dfs(int node, List<List<Integer>> adj, int[] vis, List<Integer> order, boolean[] hasCycle)
    {
        vis[node] = 1;
        for(int child : adj.get(node))
        {
            if(vis[child] == 0)
            {
                dfs(child, adj, vis, order, hasCycle);
                if(hasCycle[0]) return;
            } else if(vis[child] == 1){
                hasCycle[0] = true;
                return;
            }
        }
        vis[node] = 2;
        order.add(node);
    }
    List<Integer> fun_toposort(int arr[][], int k)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=k; i++) adj.add(new ArrayList<>());
        for(int[] edge : arr)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        List<Integer> topo = new ArrayList<>();
        int vis[] = new int[k+1];
        boolean[] hasCycle = {false};
        for(int i=1; i<=k; i++)
        {
            if(vis[i] == 0)
            {
                dfs(i, adj, vis, topo, hasCycle);
                if(hasCycle[0]) return new ArrayList<>();
            }
        }
        Collections.reverse(topo);
        return topo;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowTop = fun_toposort(rowConditions, k);
        List<Integer> colTop = fun_toposort(colConditions, k);
        if(rowTop.isEmpty() || colTop.isEmpty()) return new int[0][0];
        int ans[][] = new int[k][k];
        for(int i=0; i<k; i++)
        {
            for(int j=0; j<k; j++)
            {
                if(rowTop.get(i).equals(colTop.get(j))){
                    ans[i][j] = colTop.get(j);
                }
            }
        }
        return ans;
    }
}