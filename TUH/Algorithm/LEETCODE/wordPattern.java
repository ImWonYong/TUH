class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] strArr = s.split(" ");
        if (pattern.length() != strArr.length) return false;

        int patternIndex = 0;
        for (String word : strArr) {
            char c = pattern.charAt(patternIndex++);

            if (!map.containsKey(c)) {
                if (map.containsValue(word)) return false;
                map.put(c, word);
            } else {
                if (!map.get(c).equals(word)) {
                    return false;
                }
            }
        }

        return true;
    }
}
