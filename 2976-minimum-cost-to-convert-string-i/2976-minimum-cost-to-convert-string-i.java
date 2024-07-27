class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int INF = Integer.MAX_VALUE / 2;

        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) 
        {
            for (int j = 0; j < 26; j++) 
            {
                dist[i][j] = INF;
            }
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) 
        {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        for (int k = 0; k < 26; k++) 
        {
            for (int i = 0; i < 26; i++) 
            {
                for (int j = 0; j < 26; j++) 
                {
                    if (dist[i][k] < INF && dist[k][j] < INF) 
                    {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) 
        {
            int srcChar = source.charAt(i) - 'a';
            int tgtChar = target.charAt(i) - 'a';

            if (dist[srcChar][tgtChar] == INF) {
                return -1;
            }

            totalCost += dist[srcChar][tgtChar];
        }

        return totalCost;
    }
}