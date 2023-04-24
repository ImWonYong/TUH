class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int stone : stones) {
            queue.add(stone);
        }
        
        while (queue.size() > 1) {
            int first = queue.remove();
            int second = queue.remove();
            
            if (first == second) continue;
            else {
                queue.add(first - second);
            }
        }
        
        return queue.size() == 0 ? 0 : queue.peek();
    }
}