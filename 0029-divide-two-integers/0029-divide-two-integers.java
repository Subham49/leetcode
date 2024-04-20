class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        
        boolean sign = false;
        if(dividend>=0 && divisor<0) sign = true;        
        if(dividend<=0 && divisor>0) sign = true;
        
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long ans = 0;

        while(d <= n)
        {
            int c = 0;
            while(n >= d<<(c+1))
            {
                c++;
            }
            ans += 1<<c;
            n -= d<<c;
            System.out.println(ans+" "+n);
        }
        if(ans == (1<<31) && sign) return Integer.MIN_VALUE;
        if(ans == (1<<31) && !sign) return Integer.MAX_VALUE;
        return sign?-1*(int)ans:(int)ans;
    }
}