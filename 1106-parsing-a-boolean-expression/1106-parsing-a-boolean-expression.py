class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        stack = []
        
        for ch in expression:
            if(ch == ')'):
                isTruePresent = False
                isFalsePresent = False
                
                while stack[-1] != '(':
                    if stack.pop() == 't': isTruePresent = True
                    else : isFalsePresent: isFalsePresent = True
                
                stack.pop()
                
                operator = stack.pop()
                res = None
                if operator == '&': res = 'f' if isFalsePresent else 't'
                elif operator == '|': res = 't' if isTruePresent else 'f'
                elif operator == '!': res = 'f' if isTruePresent else 't'
                    
                stack.append(res)
                
            elif(ch != ','):
                stack.append(ch)
                
        return stack[0] == 't'