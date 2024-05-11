class Solution {
    int stackApproach(String s)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        stack.push(-1);

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                ans = Math.max(ans, i-stack.peek());
            }
        }
        return ans;
    }
    public int longestValidParentheses(String s) {
        return stackApproach(s);
    }
}