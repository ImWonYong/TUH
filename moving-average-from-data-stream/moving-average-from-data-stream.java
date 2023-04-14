class MovingAverage {
    int size, sum = 0;
    Deque queue = new ArrayDeque<Integer>();
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        queue.add(val);
        
        int tail = queue.size() > size ? (int)queue.poll() : 0;
        
        sum = sum - tail + val;
        
        return sum * 1.0 / Math.min(queue.size(), size);
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */