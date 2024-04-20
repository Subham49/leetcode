class Solution:
    def fill(self, r, c, land):
        i = r
        while i < len(land) and land[i][c] == 1: i += 1
        j = c
        while j < len(land[0]) and land[r][j] == 1: j += 1
        for r1 in range(r, i):
            for c1 in range(c, j):
                land[r1][c1] = 2
        return [i-1, j-1]

    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        i, j = 0, 0
        r = len(land)
        c = len(land[0])

        ans = []
        for i in range(r):
            for j in range(c):
                if land[i][j] == 1:
                    temp = [i, j] + self.fill(i, j, land)
                    # print(land)
                    ans.append(temp)

        return ans
