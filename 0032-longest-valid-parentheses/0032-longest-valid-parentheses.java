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
    int withoutStackApproach(String s)
    {
        int o = 0;
        int c = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') o++;
            else c++;

            if(o == c)
            {
                ans = Math.max(ans, o+c);
            }
            else if(c>o){
                o = c = 0;
            }
        }

        o = c = 0;
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == '(') o++;
            else c++;
            
            if(o == c)
            {
                ans = Math.max(ans, o+c);
            }
            else if(c<o){
                o = c = 0;
            }
        }
        return ans;
    }
    public int longestValidParentheses(String s) {
        return withoutStackApproach(s);
    }
}