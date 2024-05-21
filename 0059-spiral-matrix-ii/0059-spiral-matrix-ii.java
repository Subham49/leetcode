class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][] = new int[n][n];
        int row = n-1;
        int col = n-1;
        int sr = 0;
        int sc = 0;
        int c = 0, end = n*n;
        while(c<end)
        {
            for(int i=sc; i<=col && c<end; i++)
            {
                c++;
                ans[sr][i] = c;
            }
            sr++;
            for(int i=sr; i<=row && c<end; i++)
            {
                c++;
                ans[i][col] = c;
            }
            col--;
            for(int i=col; i>=sc && c<end; i--)
            {
                c++;
                ans[row][i] = c;
            }
            row--;
            for(int i=row; i>=sr && c<end; i--)
            {
                c++;
                ans[i][sc] = c;
            }
            sc++;
        }
        return ans;
    }
}