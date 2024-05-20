class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int sr = 0;
        int sc = 0;
        int c = 0, end = matrix.length*matrix[0].length;
        while(c<end)
        {
            for(int i=sc; i<=col && c<end; i++)
            {
                c++;
                ans.add(matrix[sr][i]);
            }
            sr++;
            for(int i=sr; i<=row && c<end; i++)
            {
                c++;
                ans.add(matrix[i][col]);
            }
            col--;
            for(int i=col; i>=sc && c<end; i--)
            {
                c++;
                ans.add(matrix[row][i]);
            }
            row--;
            for(int i=row; i>=sr && c<end; i--)
            {
                c++;
                ans.add(matrix[i][sc]);
            }
            sc++;
        }
        return ans;
    }
}