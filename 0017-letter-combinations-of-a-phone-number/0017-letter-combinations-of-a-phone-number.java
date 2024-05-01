class Solution {
    String[] key = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    List<String> fun(int ind, String str)
    {
        if(ind == str.length()) return new ArrayList<>(Arrays.asList(""));

        List<String> l = fun(ind+1, str);
        int ch = str.charAt(ind) - '0';
        List<String> ans = new ArrayList<>();
        for(char c : key[ch].toCharArray()){
            for(String s : l){
                ans.add(c+s);
            }
        }
        return ans;
    }
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        return fun(0, digits);
    }
}