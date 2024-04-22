class Solution {
    int fun(int n)
    {
        if(n%4 == 1) return 1;
        if(n%4 == 2) return n+1;
        if(n%4 == 3) return 0;
        return n;
    }
    
    public int[] decode(int[] encoded) {
        int n = encoded.length+1;
        int xor = fun(n);
        
        int temp = 0;
        for(int i=0; i<n-1; i+=2)
        {
            temp ^= encoded[i];
        }
        int last = xor ^ temp;
        int ans[] = new int[n];
        ans[n-1] = last;
        for(int i=n-2; i>=0; i--)
        {
            ans[i] = ans[i+1]^encoded[i];
        }
        return ans;
    }
}