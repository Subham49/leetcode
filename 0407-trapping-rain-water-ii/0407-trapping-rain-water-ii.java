class Solution {
    public int trapRainWater(int[][] heightMap) {
        int r = heightMap.length;
        int c = heightMap[0].length;
        
        // 0 - arr, 1-i, 2-j
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        boolean vis[][] = new boolean[r][c];
        
        for(int i=0; i<r; i++)
        {
            pq.add(new int[]{heightMap[i][0], i, 0});
            vis[i][0] = true;
            pq.add(new int[]{heightMap[i][c-1], i, c-1});
            vis[i][c-1] = true;
        }
        
        for(int i=1; i<c-1; i++)
        {
            pq.add(new int[]{heightMap[0][i], 0, i});
            vis[0][i] = true;
            pq.add(new int[]{heightMap[r-1][i], r-1, i});
            vis[r-1][i] = true;
        }
        
        int vol = 0;
        int minBounHeight = 0;
        
        int dir[][] = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(!pq.isEmpty())
        {
            int temp[] = pq.remove();
            
            int currHeight = temp[0];
            int row = temp[1];
            int col = temp[2];
            minBounHeight = Math.max(minBounHeight, currHeight);
            
            for(int i=0; i<4; i++)
            {
                int newr = row + dir[i][0];
                int newc = col + dir[i][1];
                if(newr<0 || newc<0 || newr>=r || newc>=c || vis[newr][newc]) continue;
                pq.add(new int[]{heightMap[newr][newc], newr, newc});
                vis[newr][newc] = true;
                
                if(heightMap[newr][newc] < minBounHeight){
                    vol += minBounHeight - heightMap[newr][newc];
                }
            }
            
        }

        return vol;
    }
}