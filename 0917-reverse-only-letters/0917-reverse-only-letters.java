class Solution {
    public String reverseOnlyLetters(String s) {
        int left = 0, right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left < right) {
            if (!Character.isLetter(arr[left])) {
                left++;
                continue;
            }
            
            if (!Character.isLetter(arr[right])) {
                right--;
                continue;
            }
            
            char c = arr[left];
            arr[left] = arr[right];
            arr[right] = c;
            
            left++;
            right--;
        }
        
        return new String(arr);
    }
}