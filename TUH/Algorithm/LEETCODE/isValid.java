class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();

        for (char c : charArr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.size() > 0){
                char top = stack.pop();

                if (!(c == ')' && top == '(') && !(c == '}' && top == '{') && !(c == ']' && top == '[')) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.size() != 0 ? false : true;
    }
}
