class Solution {
    public int minDeletionSize(String[] strs) {
        int output = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char preChar = '0';
            for (int j = 0; j < strs.length; j++) {
                char c = strs[j].charAt(i);
                if (c < preChar) {
                    output++;
                    break;
                }
                preChar = c;
            }
        }

        return output;
    }
}
