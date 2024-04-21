class Solution {
    boolean dfs(int s, int d, ArrayList<ArrayList<Integer>> adj, boolean vis[])
    {
        if(vis[s]) return false;
        if(s == d) return true;
        vis[s] = true;
        
        for(int n : adj.get(s))
        {
            if(dfs(n, d, adj, vis)) return true;
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int e[] : edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return dfs(source, destination, adj, new boolean[n]);
    }
}