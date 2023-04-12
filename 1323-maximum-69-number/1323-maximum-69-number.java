class Solution {
    public int maximum69Number (int num) {
        String s = new String("" + num);
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == '6' && i == 0) {
                i++;
                c = '9';
            }
            sb.append(c);
        }
        
        
        
        return Integer.valueOf(sb.toString());
    }
}