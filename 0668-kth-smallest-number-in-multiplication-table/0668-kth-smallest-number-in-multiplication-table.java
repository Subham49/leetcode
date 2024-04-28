class Solution {
    int countNoLessThanMid(int mid, int m, int n)
    {
        int count = 0;
        for(int i=1; i<=m; i++)
        {
            count += Math.min(mid/i, n); 
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int lo = 0;
        int hi = m*n;
        while (lo < hi) 
        {
            int mid = (lo+hi)/2;
            int count = countNoLessThanMid(mid, m, n);
            
            if (count >= k) 
                hi = mid;
            else  
                lo = mid+1;
        }
        return lo;
    }
}