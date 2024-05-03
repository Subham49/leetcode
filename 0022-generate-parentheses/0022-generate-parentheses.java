class Solution {
    void fun(int n, List<String> ans, String s, int c, int o)
    {
        if(s.length() == 2*n)
        {
            ans.add(s);
            return;
        }
        if(o<n)
        {
            fun(n, ans, s+'(', c, o+1);
        }
        if(c<o)
        {
            fun(n, ans, s+')', c+1, o);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        fun(n, list, "", 0, 0);
        return list;
    }
}