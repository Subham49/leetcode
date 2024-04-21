class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        HashMap<Integer, int[]> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '0')
            {
                map.putIfAbsent(0, new int[]{i, i});
                continue;
            }
            int num = 0;
            for(int j=i; j<s.length() && j<i+32; j++)
            {
                num += s.charAt(j)-'0';
                map.putIfAbsent(num, new int[]{i, j});
                num <<= 1;
            }
        }
        int ans[][] = new int[queries.length][2];
        int i = 0;
        for(int q[] : queries)
        {
            int t = q[0]^q[1];
            ans[i++] = map.getOrDefault(t, new int[]{-1, -1});
        }
        return ans;
    }
}