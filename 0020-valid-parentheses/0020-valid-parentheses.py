class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for i in s:
            if i in "({[": stack.append(i)
            else:
                if not stack: return False
                if (stack[-1] == '(' and i == ')') or \
                (stack[-1] == '[' and i == ']') or \
                (stack[-1] == '{' and i == '}'):
                    stack.pop()
                else: return False
        
        return not stack