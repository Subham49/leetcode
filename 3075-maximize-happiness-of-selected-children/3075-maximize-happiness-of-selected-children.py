class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        n = len(happiness)
        happiness.sort()
        temp = 0
        
        for i in range(k): 
            if happiness[n-i-1] - i < 0: break
            temp = temp + (happiness[n-i-1]) - i
        
        return temp