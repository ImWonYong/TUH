class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        int output = 0;
        for (int i : tasks) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        for( Integer key : map.keySet() ){
            int num = map.get(key);
            System.out.print(key + " " + num);

            while(num > 2 && (num % 3 == 0 || num % 3 == 2)) {
                num -= 3;
                output++;
            }

            while(num > 0 && num % 2 == 0) {
                num -= 2;
                output++;
            }

            if (num == 1) {
                return -1;
            }

            System.out.println(" : " + output);
        }

        return output;
    }
}
