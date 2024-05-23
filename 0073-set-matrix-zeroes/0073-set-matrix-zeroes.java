class Solution {
    void row(int ind, int a[][])
    {
        for(int i=0; i<a[0].length; i++)
            a[ind][i] = 0;
    }
    void col(int ind, int a[][])
    {
        for(int i=0; i<a.length; i++)
            a[i][ind] = 0;
    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(matrix[i][j] == 0)
                {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(row.contains(i) || col.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}