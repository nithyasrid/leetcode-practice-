import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        // Build adjacency list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses]; // 0=unvisited,1=visiting,2=visited

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] state) {
        if (state[node] == 1) return false; // cycle
        if (state[node] == 2) return true;  // already safe

        state[node] = 1; // mark visiting

        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, state)) {
                return false;
            }
        }

        state[node] = 2; // mark visited
        return true;
    }
}