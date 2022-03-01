/**
 * https://leetcode.com/problems/network-delay-time/
 */

class Pair {
    public int target;
    public int time;
    
    public Pair(int target, int time) {
        this.target = target;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>(n);
        
        // Making an empty graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }
        
        // Making the graph using adjacency list
        for (int i = 0; i < times.length; i++) {
            // indexing start at 1
            Pair current = new Pair(times[i][1] - 1, times[i][2]); 
            graph.get(times[i][0] - 1).add(current);
        }
        
        return dijkstra(graph, k - 1);
    }
    
    private int dijkstra(ArrayList<ArrayList<Pair>> graph, int startNode) {
        boolean[] seen = new boolean[graph.size()];
        int times[] = new int[graph.size()];
        
        // Intailizing the default time to maximum value
        Arrays.fill(times, Integer.MAX_VALUE);
        times[startNode] = 0;
        
        int currentVertex = startNode;
        while (currentVertex != -1) {
            seen[currentVertex] = true;
            
            for (Pair connections:graph.get(currentVertex)) {
                int totalTime = connections.time + times[currentVertex];
                times[connections.target] = 
                    Math.min(times[connections.target], totalTime);
            }
            
            currentVertex = minIndex(times, seen);
        }
        
        int time = maxValue(times);
        if (time == Integer.MAX_VALUE) return -1;
        else return time;
    }
    
    private int minIndex(int times[], boolean[] seen) {
        int index = -1, value = Integer.MAX_VALUE;
        
        for (int i = 0; i < times.length; i++) {
            if (times[i] < value && !seen[i]) {
                index = i;
                value = times[i];
            }
        }
        
        return index;
    }
    
    private int maxValue(int[] times) {
        int max = 0;
        for (int time:times) max = Math.max(max, time);
        return max;
    }
}