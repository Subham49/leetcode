class Solution {
    boolean fun(int ind, int i, int j, char[][] b, boolean vis[][], char a[])
    {
        if(ind == a.length)
            return true;
        if(ind > a.length || i<0 || j<0 || i>=b.length || j>=b[0].length || vis[i][j])
            return false;
        if(a[ind]!=b[i][j])
            return false;
        vis[i][j] = true;
        boolean x = fun(ind+1, i+1, j, b, vis, a) || fun(ind+1, i-1, j, b, vis, a) || fun(ind+1, i, j+1, b, vis, a) 
        || fun(ind+1, i, j-1, b, vis, a);
        vis[i][j] = false;
        return x;
    }
    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(!vis[i][j] && word.charAt(0) == board[i][j])
                {
                    if(fun(0, i, j, board, vis, word.toCharArray()))
                        return true;
                }
            }
        }
        return false;
    }
}