class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int ans = 0;
        int left = 0, right = people.length - 1;
        
        while (left <= right) {
            
            if (people[right] + people[left] <= limit) {
                ans++;
                right--;
                left++;
            }
            
            else if (people[right] <= limit) {
                ans++;
                right--;
            }
        }
        
        
        return ans;
    }
}