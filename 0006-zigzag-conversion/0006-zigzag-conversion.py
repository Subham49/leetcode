class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        lists = [[] for _ in range(numRows)]
        i, k = 0, 0
        flag = True

        while i < len(s):
            if flag:
                while i < len(s) and k < numRows:
                    lists[k].append(s[i])
                    i += 1
                    k += 1
                k = numRows - 2
            else:
                while i < len(s) and k >= 0:
                    lists[k].append(s[i])
                    i += 1
                    k -= 1
                k = 1
            flag = not flag

        ans = ''.join([''.join(row) for row in lists])
        return ans