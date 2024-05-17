class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<List<Character>, List<String>> map =new HashMap<>();
        for(String str : strs)
        {
            List<Character> l = new ArrayList<>();
            for(Character ch : str.toCharArray()) l.add(ch);
            Collections.sort(l);
            if(!map.containsKey(l)) map.put(l, new ArrayList<>());
            map.get(l).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<List<Character>, List<String>> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
}