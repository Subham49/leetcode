class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        int j = 0;
        while(i<str1.length() && j<str2.length())
        {
            int ch1 = str1.charAt(i)-'a';
            int ch2 = str2.charAt(j)-'a';
            if(ch1 == ch2 || (ch1+1)%26 == ch2){
                i++;
                j++;
            } else{
                i++;
            }
        }
        return j == str2.length();
    }
}