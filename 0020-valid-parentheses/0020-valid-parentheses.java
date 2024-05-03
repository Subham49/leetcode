class Solution {
    boolean match(char a, char b)
    {
        if(b == '(' && a == ')')
            return true;
        else if(b == '[' && a == ']')
            return true;
        else if(b == '{' && a == '}')
            return true;
        return false;
    }
    public boolean isValid(String s) {
        ArrayDeque<Character> S = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                S.push(ch);
            else{
                if(S.isEmpty() || !match(ch, S.peek()))
                    return false;
                else
                    S.pop();;
            }
        }
        if(S.isEmpty())
            return true;
        return false;
    }
}