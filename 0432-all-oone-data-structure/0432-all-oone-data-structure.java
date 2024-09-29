class AllOne {
    HashMap<String, Integer> map;
    String res;
    int op;
    public AllOne() {
        this.map = new HashMap<>();
        this.res = "";
        this.op = 0;
    }
    
    public void inc(String key) {
        this.op = 0;
        this.map.put(key, map.getOrDefault(key, 0)+1);
    }
    
    public void dec(String key) {
        this.op = 0;
        map.put(key, map.get(key)-1);
        if(map.get(key) == 0) map.remove(key);
    }
    
    public String getMaxKey() {
        if(this.op == 1)
        {
            return this.res;
        }
        this.op = 1;
        int max = 0;
        String ans = "";
        for(String key : this.map.keySet())
        {
            if(max < this.map.get(key))
            {
                max = this.map.get(key);
                ans = key;
            }
        }
        this.res = ans;
        return ans;
    }
    
    public String getMinKey() {
        if(this.op == 2)
        {
            return this.res;
        }
        this.op = 2;
        int min = Integer.MAX_VALUE;
        String ans = "";
        for(String key : this.map.keySet())
        {
            if(min > this.map.get(key))
            {
                min = this.map.get(key);
                ans = key;
            }
        }
        this.res = ans;
        return ans;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */