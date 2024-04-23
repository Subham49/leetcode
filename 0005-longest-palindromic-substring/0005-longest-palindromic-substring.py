class Solution:
    def expand(self, s, i, j):
        while i>=0 and j<len(s) and s[i] == s[j]:
            i-=1
            j+=1
        return [i+1, j-1]
    
    def longestPalindrome(self, s: str) -> str:
        ans = [0,0]
        for i in range(len(s)): 
            temp = self.expand(s, i, i)
            if temp[1]-temp[0]+1>ans[1]-ans[0]+1: ans = temp

            temp = self.expand(s, i, i+1)
            if temp[1]-temp[0]+1>ans[1]-ans[0]+1: ans = temp
                
        return s[ans[0]: ans[1]+1]