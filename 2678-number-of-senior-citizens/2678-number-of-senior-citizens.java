class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String str : details)
        {
            if(Integer.valueOf(str.substring(11, 13)) > 60)
                ans++;
        }
        return ans;
    }
}