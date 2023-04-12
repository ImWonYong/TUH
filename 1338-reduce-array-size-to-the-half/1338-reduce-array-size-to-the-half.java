class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int key : counts.keySet()) {
            ans.add(counts.get(key));
        }
        
        if (ans.size() == 1) {
            return 1;
        }
        
        Collections.sort(ans, Collections.reverseOrder());
        
        int sum = 0;
        int cnt = 0;
        for (int i : ans) {
            if (sum < arr.length / 2) {
                sum += i;
                cnt++;
            }
        }
        
        return cnt;
    }
}