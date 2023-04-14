class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        
        Deque<String> stack = new ArrayDeque<>();
        String[] files = path.split("/");
        
        for (String file : files) {
            if (file.equals("") || file.equals(".")) {
                continue;
            }
            
            else if (file.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            
            else {
                stack.push(file);
            }
        }
        
        sb.append("/");
        
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
            sb.append("/");
        }
        if (sb.length() != 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
}