/**
 * https://leetcode.com/problems/course-schedule/
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];
        
        // Making an empty graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        // Adding all values
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        
        return BFS(graph, numCourses, inDegree); 
    }
    
    private boolean BFS(ArrayList<ArrayList<Integer>> graph, int numCourses, 
            int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            int current = queue.remove();
            
            for (int child:graph.get(current)) {
                inDegree[child]--;
                if (inDegree[child] == 0) queue.add(child);
            }
            numCourses--;
        }
        
        return numCourses == 0;
    }
}

