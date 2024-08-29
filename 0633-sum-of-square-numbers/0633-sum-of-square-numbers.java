class Solution {
    public boolean judgeSquareSum(int c) {
        long lo = 0;
        long hi = (long)Math.sqrt(c);
        while(lo <= hi)
        {
            long mid = lo*lo + hi*hi;
            if(mid == c) return true;
            else if(mid > c) hi--;
            else lo++;
        }
        return false;
    }
}