class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int p[] = new int[n+1];
        
        for(int i=1; i<n+1; i++) p[i] = p[i-1]^arr[i-1];
        
        int ans = 0;
        for(int i=1; i<n+1; i++)
        {
            for(int j=i+1; j<n+1; j++)
            {
                for(int k=j; k<n+1; k++)
                {
                    if((p[i-1]^p[j-1]) == (p[j-1]^p[k])) ans++;
                }
            }
        }
        return ans;
    }
}