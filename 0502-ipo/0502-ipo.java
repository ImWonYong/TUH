class Solution {
    class Project implements Comparable<Project> {
        int capital, profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        public int compareTo(Project project) {
            return this.profit - project.profit;
        }
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        Project[] projects = new Project[n];
        
        for (int i = 0; i < n ; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects, (a, b) -> {return a.capital - b.capital;});
        PriorityQueue<Integer> queue = new PriorityQueue<>(n, Collections.reverseOrder());
        
        int j = 0;
        for (int i = 0; i < k; i++) {
            while(j < n && projects[j].capital <= w) {
                queue.add(projects[j++].profit);
                
            }
            
            if (queue.isEmpty()) {
                    return w;
                }
                
            w += queue.remove();
        }
        
        return w;
    }
}