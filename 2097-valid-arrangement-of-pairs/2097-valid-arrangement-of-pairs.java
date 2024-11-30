class Solution {
    List<Integer> res = new ArrayList<>();
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();
        for(int pair[] : pairs) {
            if(!map.containsKey(pair[0])) {
                map.put(pair[0], new ArrayDeque<>());
            }
            map.get(pair[0]).add(pair[1]);
            out.put(pair[0], out.getOrDefault(pair[0], 0)+1);
            in.put(pair[1], in.getOrDefault(pair[1], 0)+1);
        }
        int start = -1;
        for(Integer key : map.keySet()) {
            if(out.get(key) == in.getOrDefault(key, 0)+1) {
                start = key;
                break;
            }
        }
        if(start == -1) {
            start = pairs[0][0];
        }
        
        dfs(start, map);

        System.out.println(res);
        for(int i=0; i<pairs.length; i++) {
            pairs[i][0] = res.get(pairs.length-i);
            pairs[i][1] = res.get(pairs.length-1-i);
        }
        return pairs;
    }

    void dfs(int node, HashMap<Integer, ArrayDeque<Integer>> map) {
        ArrayDeque<Integer> queue = map.get(node);
        while(queue!=null && !queue.isEmpty()) {
            int child = queue.remove();
            dfs(child, map);
        }
        res.add(node);
    }
}