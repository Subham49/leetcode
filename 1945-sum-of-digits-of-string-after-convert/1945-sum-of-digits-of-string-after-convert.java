class Solution {
    public int getLucky(String s, int k) {
        String digit = "";
        for(int i=0; i<s.length(); i++)
        {
            digit += (s.charAt(i)-'a'+1);
        }
        
        for(int i=0; i<k; i++)
        {
            int sum = 0;
            for(int j=0; j<digit.length(); j++)
            {
                sum += (digit.charAt(j)-'0');
            }
            digit = Integer.toString(sum);
        }
        return Integer.valueOf(digit);
    }
}