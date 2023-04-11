class Solution {
    class Node implements Comparable<Node> {
    int num;
    int count;
    
    Node(int num, int count) {
        this.num = num;
        this.count = count;
    }
    
    public int compareTo(Node node) {
        return this.count - node.count;
    }
}
    
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        for (int key : map.keySet()) {
            queue.add(new Node(key, map.get(key)));
        }
        
        int i = 0;
        while (true) {
            int n = queue.peek().count;
            
            if (k < n) {
                return queue.size();
            }
            else if (k == n) {
                return queue.size() - 1;
            } else {
                k = k - n;
                queue.remove();
            }
        }
    
    }
}