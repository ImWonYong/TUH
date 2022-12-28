class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = searchArray(matrix, target, 0, matrix.length - 1);
        return search(matrix[index], target, 0, matrix[index].length - 1);
    }

    public boolean search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] > target) {
            return search(arr, target, start, mid - 1);
        } else {
            return search(arr, target, mid + 1, end);
        }
    }

    public int searchArray(int[][] matrix, int target, int start, int end) {
        if (start >= end) {
            return start;
        }

        int mid = (start + end) / 2;

        if (matrix[mid][0] == target) {
            return mid;
        } else if (matrix[mid][0] > target) {
            return searchArray(matrix, target, start, mid - 1);
        } else {
            int endValue = matrix[mid][matrix[mid].length - 1];
            if (endValue >= target) {
                return mid;
            }
            return searchArray(matrix, target, mid + 1, end);
        }
    }
}