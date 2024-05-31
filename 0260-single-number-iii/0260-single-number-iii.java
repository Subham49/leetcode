class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i : nums) xor ^= i;
        int rightMostSetBit = xor & (-xor);

        int ans[] = new int[2];
        for(int num : nums)
        {
            if((num & rightMostSetBit) == 0) ans[0] ^= num;
            else ans[1] ^= num;
        }
        return ans;
    }
}