class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []

        def fun(string, open, close, n):
            if len(string) == 2*n:
                ans.append(string)
                return
            
            if(open < n): fun(string+"(", open+1, close, n)
            if(open > close): fun(string+")", open, close+1, n)

        fun("", 0, 0, n)
        return ans