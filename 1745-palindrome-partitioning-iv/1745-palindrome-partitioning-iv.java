class Solution {
    Boolean dp[][];
    Boolean pal[][];
    
    boolean isPalindrome(String s,int i,int j){
        if(pal[i][j] != null) return pal[i][j];
        if(i >= j) return pal[i][j] = true;
        if(s.charAt(i) == s.charAt(j)) return pal[i][j] = isPalindrome(s,i+1,j-1);
        else return pal[i][j] = false;
    }
    
    boolean fun(int ind, String s, int par)
    {
        if(ind == s.length()) return false;
        if(par == 0) return isPalindrome(s, ind, s.length()-1);
        if(dp[ind][par] != null) return dp[ind][par];
        
        for(int i=ind; i<s.length()-1; i++)
        {
            if(isPalindrome(s, ind, i))
            {
                if(fun(i+1, s, par-1)) return dp[ind][par] = true;
            }
        }
        return dp[ind][par] = false;
    }
    public boolean checkPartitioning(String s) {
        dp = new Boolean[s.length()][3];
        pal = new Boolean[s.length()][s.length()];
        
        return fun(0, s, 2);
    }
}