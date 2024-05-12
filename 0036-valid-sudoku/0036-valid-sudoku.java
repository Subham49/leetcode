class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> h = new HashSet<>();
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j]=='.')
                {
                    continue;
                }
                else if(!h.add(board[i][j]+" row "+i) || !h.add(board[i][j]+" column "+j) || 
                !h.add(board[i][j]+" sub box "+i/3+j/3))
                    return false;
            }
        }
        return true;
    }
}