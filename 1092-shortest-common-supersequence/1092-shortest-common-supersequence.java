class Solution {
    int dp[][];
    void lcs(String str1, String str2)
    {
        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();
        int n=str1.length();
        int m=str2.length();

        // base case
        for(int i=0; i<=n; i++) dp[i][0]=0;
        for(int j=0; j<=m; j++) dp[0][j]=0;

        // filling dp table and length of lcs
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(s[i-1]==t[j-1])
                dp[i][j]=1+dp[i-1][j-1];
                
                else 
                dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    
    public String shortestCommonSupersequence(String str1, String str2) {
        dp = new int[str1.length()+1][str2.length()+1];
        lcs(str1, str2);
        
        StringBuilder ans = new StringBuilder();
        int i = str1.length(), j = str2.length();
        
        while(i>0 && j>0)
        {
            if(str1.charAt(i-1) == str2.charAt(j-1))
            {
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i][j-1] >= dp[i-1][j])
            {
                ans.append(str2.charAt(j-1));
                j--;
            }
            else
            {
                ans.append(str1.charAt(i-1));
                i--;
            }
        }
        while(i-- > 0) ans.append(str1.charAt(i));        
        while(j-- > 0) ans.append(str2.charAt(j));
        
        ans.reverse();
        return ans.toString();
    }
}