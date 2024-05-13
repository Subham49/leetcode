class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        
        prev_str = self.countAndSay(n - 1)
        count = 0
        result = []
        
        for i in range(len(prev_str)):
            count += 1
            if i == len(prev_str) - 1 or prev_str[i] != prev_str[i + 1]:
                result.append(str(count))
                result.append(prev_str[i])
                count = 0
                
        return ''.join(result)
