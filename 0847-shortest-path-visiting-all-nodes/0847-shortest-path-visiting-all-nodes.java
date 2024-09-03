class Solution {
    public int shortestPathLength(int[][] graph) {
        //node mask
        int n = graph.length;
        ArrayDeque<int []> q = new ArrayDeque<>();
        boolean vis[][] = new boolean[n][1<<n];
        for(int i=0; i<n; i++)
        {
            q.add(new int[]{i, 1<<i});
            vis[i][1<<i] = true;
        }

        int ans = 0;
        while(!q.isEmpty())
        {
            int s = q.size();
            ans++;
            for(int i=0; i<s; i++)
            {
                int[] curr = q.remove();
                if(curr[1] == (1<<n)-1)
                    return ans-1;

                for(int child : graph[curr[0]])
                {
                    if(vis[child][curr[1] | 1<<child])
                        continue;
                    q.add(new int[]{child, curr[1] | 1<<child});
                    vis[child][curr[1] | 1<<child] = true;
                }
            }
        }
        return -1;
    }
}