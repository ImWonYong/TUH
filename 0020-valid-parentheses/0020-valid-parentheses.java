class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (stack.empty()) {
                if (bracket == ')' || bracket == '}' || bracket == ']') {
                    return false;
                } 
            }
            
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else {
                if (bracket == ')') {
                    if (stack.peek() != '(') {
                        return false;
                    }
                } else if (bracket == '}') {
                    if (stack.peek() != '{') {
                        return false;
                    }
                } else {
                    if (stack.peek() != '[') {
                        return false;
                    }
                }
                
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}