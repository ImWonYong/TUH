import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>(Arrays.asList(1)));

        if (numRows == 1) {
            return result;
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> bottomList = new ArrayList<Integer>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    bottomList.add(1);
                } else {
                    bottomList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }

            result.add(bottomList);
        }

        return result;
    }
}