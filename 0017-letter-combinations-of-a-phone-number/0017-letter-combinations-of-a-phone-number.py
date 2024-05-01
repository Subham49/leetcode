class Solution:
    key = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]

    def fun(self, ind, string):
        if ind == len(string):
            return [""]

        l = self.fun(ind + 1, string)
        ch = int(string[ind])
        ans = []
        for c in self.key[ch]:
            for s in l:
                ans.append(c + s)
        return ans

    def letterCombinations(self, digits: str) -> List[str]:
        if digits == "":
            return []
        return self.fun(0, digits)
