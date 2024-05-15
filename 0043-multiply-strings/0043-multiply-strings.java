class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int ans[] = new int[n1+n2];
        
        Arrays.fill(ans, 0);
        if(num1.equals("0") || num2.equals("0"))
                return  "0";
        for(int i=n1-1; i>=0; i--)
        {
            for(int j=n2-1; j>=0; j--)
            {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int sum = mul + ans[i+j+1];

                ans[i+j] += sum / 10;
                ans[i+j+1] = (sum) % 10;
            }
        }
        String res = "";
        int i = 0;
        while(ans[i]==0 && i<n1+n2)
            i++;
        while(i<n1+n2)
        {
            res+=ans[i++];
        }
        return res;
    }
}