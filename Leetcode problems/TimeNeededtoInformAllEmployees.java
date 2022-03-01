/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        
        // Making empty lists
        for (int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        
        // Making the graph
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            graph.get(manager[i]).add(i);
        }
        
        return DFS(headID, graph, informTime);
    }
    
    public int DFS(int vertex, ArrayList<ArrayList<Integer>> graph, int[] informTime) {
        int time = informTime[vertex], maxTime = 0;
        
        for (int child:graph.get(vertex)) 
            maxTime = Math.max(maxTime, DFS(child, graph, informTime));
        
        return time + maxTime;
    }
}