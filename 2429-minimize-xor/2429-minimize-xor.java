class Solution {
    public int minimizeXor(int num1, int num2) {
        int n = Integer.bitCount(num2);
        int p = Integer.bitCount(num1);
        if(n == p) return num1;
        
        n -= p;
        int x = num1;
        int c = 1;
        while(n!=0)
        {
            if(n>0 && (x&c) == 0) {
                x |= c;
                n--;
            }
            else if(n<0 && (x&c) != 0) {
                x ^= c;
                n++;
            }
            c= c << 1;
        }
        return x;
    }
}