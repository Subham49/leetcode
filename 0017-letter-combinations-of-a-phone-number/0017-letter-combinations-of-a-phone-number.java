class Solution {
    List<String> fun(String s, int i, char a[][])
    {
        if(i == s.length())
        {
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        List<String> temp = fun(s, i+1, a);
        List<String> ans = new ArrayList<>();
        int x = s.charAt(i)-'0';
        for(int j=0; j<a[x].length; j++)
        {
            char ch = a[x][j];
            for(int k=0; k<temp.size(); k++)
            {
                ans.add(ch+temp.get(k));
            }
        }
        return ans;
    }
    public List<String> letterCombinations(String digits) {
        char a[][] = {
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
            };
        if(digits.length() == 0)
            return new ArrayList<>();
        return fun(digits, 0, a);
    }
}