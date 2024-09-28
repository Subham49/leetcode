class MyCircularDeque {
    int s;
    ArrayDeque q;
    public MyCircularDeque(int k) {
        this.s = k;
        this.q = new ArrayDeque<>();
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        q.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        q.addLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        q.removeFirst();
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        q.removeLast();
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return (int)q.getFirst();
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return (int)q.getLast();
    }
    
    public boolean isEmpty() {
        return q.size() == 0;
    }
    
    public boolean isFull() {
        return q.size() == s;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */