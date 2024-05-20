class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ans = []
        row = len(matrix) - 1
        col = len(matrix[0]) - 1
        sr = 0
        sc = 0
        c = 0
        end = len(matrix) * len(matrix[0])
        
        while c < end:
            for i in range(sc, col + 1):
                if c < end:
                    c += 1
                    ans.append(matrix[sr][i])
            sr += 1
            for i in range(sr, row + 1):
                if c < end:
                    c += 1
                    ans.append(matrix[i][col])
            col -= 1
            for i in range(col, sc - 1, -1):
                if c < end:
                    c += 1
                    ans.append(matrix[row][i])
            row -= 1
            for i in range(row, sr - 1, -1):
                if c < end:
                    c += 1
                    ans.append(matrix[i][sc])
            sc += 1
        
        return ans
