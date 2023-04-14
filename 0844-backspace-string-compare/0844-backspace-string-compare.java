class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        
        for (char c : s.toCharArray()) {  
            if (c != '#') {
                stackS.push(c);                    
            } else {
                if (!stackS.empty()) {
                    stackS.pop();
                }
            }
        }
        
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stackT.push(c);
            } else {
                if (!stackT.empty()) {
                    stackT.pop();
                }
            }
        }
        
       if (stackS.size() != stackT.size()) {
           return false;
       }
        
        while (!stackS.empty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        
        return true;
    }
}