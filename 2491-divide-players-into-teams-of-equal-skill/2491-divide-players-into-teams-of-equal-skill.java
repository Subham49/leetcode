class Solution {
    public long dividePlayers(int[] skill) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(skill.length == 2)
        {
            return skill[0]*skill[1];
        }
        int sum = 0;
        for(int i : skill) 
        {
            sum += i;
        }
        int k = sum;
        sum /= (skill.length/2);
        if((sum * skill.length/2) != k) return -1;
        
        long ans = 0;
        for(int i : skill)
        {
            if(!map.containsKey(sum - i)){
                map.put(i, map.getOrDefault(i, 0)+1);
                continue;
            }
            ans += (long)(i * (sum-i));
            if(map.get(sum - i) == 1)
            {
                map.remove(sum-i);
            } else {
                map.put(sum-i, map.get(sum-i) - 1);
            }
        }
        return ans == 0 || !map.isEmpty() ? -1 : ans;
    }
}