class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // for (int i = 0; i < graph.length; i++) { // 방문 순서를 위해 오름차순 정렬
        //     Arrays.sort(graph[i]);
        // }

        boolean[] checked = new boolean[graph.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> road = new ArrayList<>();
        DFS(graph, 0, road, result);

        return result;
    }

    public void DFS(int[][] graph, int n, List<Integer> road, List<List<Integer>> result) {
        if (n == graph.length - 1) {
            road.add(n);
            List<Integer> rightRoad = new ArrayList<>();
            for (int v : road) {
                rightRoad.add(v);
            }

            result.add(rightRoad);
            return;
        }

        road.add(n);
        for (int i = 0; i < graph[n].length; i++) {
            DFS(graph, graph[n][i], road, result);
            road.remove(road.size() - 1);
        }
    }
}