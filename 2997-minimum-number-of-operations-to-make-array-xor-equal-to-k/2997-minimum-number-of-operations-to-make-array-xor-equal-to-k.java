class Solution {
    int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
    public int minOperations(int[] nums, int k) {
        int all = 0;
        for(int i : nums) all ^= i;
        int t = all^k;
        return countSetBits(t);
    }
}