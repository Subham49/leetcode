class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char ch : s.toCharArray())
        {
            if("({[".indexOf(ch) != -1) stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                if(
                    !(stack.peek() == '(' && ch == ')') && 
                    !(stack.peek() == '[' && ch == ']') && 
                    !(stack.peek() == '{' && ch == '}')
                )
                    return false;
                stack.pop();
            }
        }
        System.out.println(stack);
        return stack.isEmpty();
    }
}