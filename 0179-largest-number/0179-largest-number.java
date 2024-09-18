class Solution {
    public String largestNumber(int[] nums) {
        String a[] = new String[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            a[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(a, (c,b)->{
            return (b+c).compareTo(c+b);
        });
        String ans = "";
        for(String s : a)
        {
            ans = ans+s;
        }
        int i=0;
        while(i<ans.length() && ans.charAt(i) == '0')
            i++;
        if(i == ans.length())
            return "0";
        return ans.substring(i);
    }
}