class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alpabets = new int[26];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for (int i = 0; i < sArray.length; i++) {
            alpabets[sArray[i] - 'a']++;
            alpabets[tArray[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alpabets[i] != 0) {
                return false;
            }
        }

        return true;
    }
}