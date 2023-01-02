class Solution {
    public boolean detectCapitalUse(String word) {
        char[] wordArr = word.toCharArray();
        boolean isLowercase = wordArr[0] >= 'a' && wordArr[0] <= 'z' ? true : false;
        for (int i = 1; i < wordArr.length; i++) {
            char preChar = wordArr[i - 1];
            if (isLowercase) {
                if (wordArr[i] < 'a') return false;
            } else {
                if (i > 1 && ((wordArr[i] <= 'Z' && preChar >= 'a') || (wordArr[i] >= 'a' && preChar <= 'Z'))) {
                    return false;
                }
            }
        } 
        return true;   
    }
}
