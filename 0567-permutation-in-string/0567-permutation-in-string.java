class Solution {
    boolean equal(int a[], int b[])
    {
        for(int i=0; i<26; i++)
        {
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int freq[] = new int[26];
        for(char ch : s1.toCharArray()) freq[ch-'a']++;
        int f[] = new int[26];
        for(int i=0; i<s1.length(); i++) f[s2.charAt(i)-'a']++;
        if(equal(freq, f)) return true;
        int l = 0;
        for(int i=s1.length(); i<s2.length(); i++)
        {
            f[s2.charAt(l++)-'a']--;
            f[s2.charAt(i)-'a']++;
            if(equal(freq, f)) return true;
        }
        return false;
    }
}