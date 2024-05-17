class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n): 
            for j in range(i, n): 
                t = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = t
        
        for i in range(n):
            for j in range(n//2): 
                t = matrix[i][j]
                matrix[i][j] = matrix[i][n-j-1]
                matrix[i][n-j-1] = t