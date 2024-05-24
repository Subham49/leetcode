class Solution {

    int fun(int ind, String words[], int score[], int freq[])
    {
        if(ind == words.length)
            return 0;
        
        int nale = fun(ind+1, words, score, freq);

        String str = words[ind];
        int sc = 0;
        boolean valid = true;

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(freq[ch-'a'] == 0)
            {
                valid = false;
            }
            sc += score[ch-'a'];
            freq[ch-'a']--;
        }

        int le = 0;
        if(valid)
        {
            le = sc + fun(ind+1, words, score, freq);
        }

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            freq[ch-'a']++;
        }

        return Math.max(le, nale);
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[] = new int[26];
        for(int i=0; i<letters.length; i++)
        {
            char ch = letters[i];
            freq[ch-'a']++;
        }
        return fun(0, words, score, freq);
    }
}