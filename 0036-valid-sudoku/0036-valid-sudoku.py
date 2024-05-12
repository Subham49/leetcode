class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        seen = set()
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    if (board[i][j] + " row " + str(i)) in seen or \
                       (board[i][j] + " column " + str(j)) in seen or \
                       (board[i][j] + " sub box " + str(i // 3) + str(j // 3)) in seen:
                        return False
                    seen.add(board[i][j] + " row " + str(i))
                    seen.add(board[i][j] + " column " + str(j))
                    seen.add(board[i][j] + " sub box " + str(i // 3) + str(j // 3))
        return True
