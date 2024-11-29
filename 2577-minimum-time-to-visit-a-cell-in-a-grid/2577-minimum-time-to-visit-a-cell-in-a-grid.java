class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[1][0]>1 && grid[0][1]>1)  return -1;
        int r = grid.length;
        int c = grid[0].length;
        int time[][] = new int[r][c];
        for(int i[] : time) {
            Arrays.fill(i, 1000000);
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.add(new int[]{0, 0, 0});
        time[0][0] = 0;

        int dir[] = new int[]{-1, 0, 1, 0, -1};
        while(!pq.isEmpty()) {
            int top[] = pq.remove();
            if(top[1] == r-1 && top[2] == c-1) {
                return top[0];
            }
            for(int i=0; i<4; i++) {
                int dr = top[1]+dir[i];
                int dc = top[2]+dir[i+1];
                if(dr < 0 || dc < 0 || dr >= r || dc >= c) {
                    continue;
                }
                int t = ((grid[dr][dc] - top[0])&1) != 0 ? 0 : 1;
                int nextTime = Math.max(top[0]+1, grid[dr][dc] + t);
                if(nextTime < time[dr][dc]) {
                    time[dr][dc] = nextTime;
                    pq.add(new int[]{nextTime, dr, dc});
                }
            }
        }
        return -1;
    }
}