class Solution:
    def romanToInt(self, s: str) -> int:
        mydict = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        
        ans = 0
        for i in range(len(s)-1):
            curr = s[i]
            nextc = s[i+1]
            if mydict[curr] < mydict[nextc]:
                ans -= mydict[curr]
            else:
                ans += mydict[curr]
        
        ans += mydict[s[-1]];
        return ans