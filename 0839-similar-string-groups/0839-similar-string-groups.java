class Solution {
    Map<Integer, List<Integer>> seen;
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        seen = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    seen.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                    seen.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
            }
        }
        
        boolean[] visit = new boolean[n];
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, visit);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int node, boolean[] visit) {
        
        if (!seen.containsKey(node)) {
            return;
        }
        
        for (int nei : seen.get(node)) {
            if (!visit[nei]) {
                visit[nei] = true;
                dfs(nei, visit);
            }
        }
    }
    
    public boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 0 || diff == 2;
    }
}

/*
    tars - atrs, rats, sart
         - tras, tsra
         - tasr

*/