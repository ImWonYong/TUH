class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int n : pushed) {
            stack.push(n);
            
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }
        
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            System.out.println(pop);
            if (idx < popped.length && popped[idx] != pop) {
                return false;
            }
            
            idx++;
        }
                
        return true;
    }
}