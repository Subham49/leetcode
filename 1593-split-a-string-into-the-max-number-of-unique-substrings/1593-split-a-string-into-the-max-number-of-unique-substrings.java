class Solution {
    HashSet<String> vis = new HashSet<>();
    
    int fun(int ind, String s)
    {
        if(ind >= s.length()) return 0;
        
        String temp = "";
        int ans = 0;
        for(int k=ind; k<s.length(); k++)
        {
            temp = temp + s.charAt(k);
            if(!vis.contains(temp))
            {
                vis.add(temp);
                ans = Math.max(ans, 1 + fun(k+1, s));
                vis.remove(temp);
            }
        }
        return ans;
    }
    public int maxUniqueSplit(String s) {
        vis.add("");
        return fun(0, s);
    }
}