class Solution:
    def __init__(self):
        self.vis = set()  
    
    def maxUniqueSplit(self, s: str) -> int:
        
        def fun(ind: int, string: str) -> int:
            if ind >= len(string):
                return 0
            
            temp = ""
            ans = 0
            for i in range(ind, len(string)):
                temp += string[i]
                if temp not in self.vis:  
                    self.vis.add(temp)
                    ans = max(ans, 1 + fun(i+1, string))
                    self.vis.remove(temp)  
            return ans
        
        return fun(0, s)  
