class CustomStack {
    int s;
    ArrayDeque<Integer> q;
    public CustomStack(int maxSize) {
        this.s = maxSize;
        this.q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if(this.q.size() == this.s) return;
        this.q.add(x);
    }
    
    public int pop() {
        if(this.q.size() == 0) return -1;
        return this.q.removeLast();
    }
    
    public void increment(int k, int val) {
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        while(!q.isEmpty())
        {
            temp.add(q.remove());
        }
        for(int i=0; i<k && !temp.isEmpty(); i++)
        {
            q.add(temp.remove() + val);
        }
        while(!temp.isEmpty()) q.add(temp.remove());
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */