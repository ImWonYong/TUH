class Solution {
    public int firstUniqChar(String s) {
        int[] alphabets = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            alphabets[a - 97]++;
        }

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (alphabets[a - 97] == 1) {
                return i;
            }
        }

        return -1;
    }
}