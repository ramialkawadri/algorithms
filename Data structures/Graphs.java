import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Graphs {
    public static void DFS(int vertex, int[][] adjacencylist, 
            ArrayList<Integer> values, boolean[] seen) {
        values.add(vertex);
        seen[vertex] = true;

        for (int neighbor:adjacencylist[vertex]) {
            if (!seen[neighbor]) DFS(neighbor, adjacencylist, values, seen);
        }
    }

    public static void DFS_matrix(int vertex, int[][] adjacencyMatrix, 
            ArrayList<Integer> values, boolean[] seen) {
        values.add(vertex);
        seen[vertex] = true;

        int[] neighbors = adjacencyMatrix[vertex];

        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i] == 1 && !seen[i])
                DFS_matrix(i, adjacencyMatrix, values, seen);
        }
    }

    public static ArrayList<Integer> BFS(int[][] adjacencylist) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] seen = new boolean[adjacencylist.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            seen[vertex] = true;
            ans.add(vertex);

            for (int num:adjacencylist[vertex]) {
                if (!seen[num]) queue.add(num);
            }
        }

        return ans;
    }

    public static ArrayList<Integer> BFS_matrix(int[][] adjacencyMatrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] seen = new boolean[adjacencyMatrix.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        while(!queue.isEmpty()) {
            int vertex = queue.remove();
            seen[vertex] = true;
            ans.add(vertex);

            for (int i = 0; i < adjacencyMatrix[vertex].length; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !seen[i])
                    queue.add(i);
            }
        }

        return ans;
    }
}

