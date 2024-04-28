class Solution {
    public boolean parseBoolExpr(String expression) {
        if(expression.length() == 1) return expression.charAt(0) == 't';
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(char ch : expression.toCharArray())
        {
            if(ch == ')')
            {
                boolean isFalsePresent = false;
                boolean isTruePresent = false;
                char res = '/';
                
                while(!stack.isEmpty() && stack.peek() != '(')
                {
                    if(stack.pop() == 't') isTruePresent = true;
                    else isFalsePresent = true;
                }
                stack.pop();
                char operator = stack.pop();
                if(operator == '&') res = isFalsePresent ? 'f' : 't';
                else if(operator == '|') res = isTruePresent ? 't' : 'f';
                else if(operator == '!') res = isTruePresent ? 'f' : 't';
                stack.push(res);
            }
            else if(ch != ',')
                stack.push(ch);
        }
        return stack.peek() == 't';
    }
}