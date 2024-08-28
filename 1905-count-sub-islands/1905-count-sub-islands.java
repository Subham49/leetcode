class Solution {
    int dir[][] = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    void fun(int[][] grid1, int[][] grid2, int i, int j, boolean[] flag)
    {
        if(i<0 || j<0 || i>=grid1.length || j>=grid1[0].length || grid2[i][j] == 0) return;
        if(grid1[i][j] == 0){
            flag[0] = false;
            return;
        }
        grid2[i][j] = 0;

        for(int k=0; k<4; k++)
        {
            int ni = i+dir[k][0];
            int nj = j+dir[k][1];
            fun(grid1, grid2, ni, nj, flag);
        }
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        int r = grid1.length;
        int c = grid1[0].length;

        for(int i=0; i<r; i++)
        {
            boolean flag[] = {true};
            for(int j=0; j<c; j++)
            {
                if(grid2[i][j] == 1)
                {
                    fun(grid1, grid2, i, j, flag);
                    if(flag[0]) ans++;
                    flag[0] = true;
                }
            }
        }

        return ans;
    }
}