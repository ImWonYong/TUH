class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] alphabets = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int num = magazine.indexOf(c, alphabets[c - 'a']);

            if (num == -1) return false;

            alphabets[c - 'a'] = num + 1;
        }

        return true;
    }
}