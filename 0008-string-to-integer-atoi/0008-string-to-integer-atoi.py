class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if not s: return 0
        pos = s[0] == '+'       
        neg = s[0] == '-'

        ind = 1 if pos or neg else 0
        ans = 0
        
        while ind<len(s):

            if s[ind]<'0' or s[ind]>'9': break;
            
            if ans > (2**31-1) // 10 or (ans == (2**31-1) // 10 and int(s[ind]) > (2**31-1) % 10): 
                return -2**31 if neg else 2**31-1
            
            ans = ans*10 + int(s[ind])
            ind += 1
        
        return -ans if neg else ans