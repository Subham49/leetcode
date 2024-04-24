class TrieNode:
    def __init__(self):
        self.children = [None, None]
        
class Solution:
    
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, n):
        curr = self.root
        
        for i in range(31,-1,-1):
            bit = (n>>i)&1
            if curr.children[bit] == None: curr.children[bit] = TrieNode()
            curr = curr.children[bit]
    
    def fun(self, n):
        curr = self.root
        ans = 0
        for i in range(31,-1,-1):
            bit = (n>>i)&1
            
            if curr.children[bit^1] != None:
                ans = ans | 1<<i
                curr = curr.children[bit^1]
            elif curr.children[bit] != None:
                curr = curr.children[bit]
            else: return -1
            
        return ans
    
    def maximizeXor(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        n = len(nums)
        q = len(queries)
        
        ans = [0]*q
        
        nums.sort()
        
        temp = [[0] * 3 for _ in range(q)]
        
        i = 0
        for q in queries:
            temp[i][0] = q[0]
            temp[i][1] = q[1]
            temp[i][2] = i
            i += 1
        
        temp.sort(key=lambda x: x[1])
        
        i = 0
        for q in temp:
            while i < n and nums[i]<=q[1]: 
                self.insert(nums[i])
                i+=1
                
            ans[q[2]] = self.fun(q[0])
        return ans