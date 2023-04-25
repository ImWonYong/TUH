class SmallestInfiniteSet {
    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        for (int i = 1; i <= 1000; i++) {
            set.add(i);
        }
    }
    
    public int popSmallest() {
        int ans = set.first();
        set.remove(ans);
        return ans;
    }
    
    public void addBack(int num) {
        if (!set.contains(num)) {
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */