class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int ans[] = new int[nums.length];
        int arr = 0;
        for(int i : nums) arr ^= i;
        
        for(int i=nums.length-1; i>=0; i--)
        {  
            int k = 0;
            for(int j=0; j<maximumBit; j++)
            {
                int bit = (arr & (1<<j)) > 0 ? 1 : 0; // find the jth bit 
                bit ^= 1; //flid the bit 0 to 1 or 1 to 0
                k |= (bit<<j); //set jth bit to opp of bit
            }
            
            arr ^= nums[i]; // remove last no from the array
            ans[nums.length - i - 1] = k;
        }
        return ans;
    }
}