class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] prerequisite : prerequisites){
            int prereq = prerequisite[1];
            int course = prerequisite[0];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i<numCourses; i++){
            if (indegree[i] == 0){
                queue.offer(i);
            }
        }

        int processed = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            processed++;

            for (int neighbor : graph.get(current)){
                indegree[neighbor]--;
                if (indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        return processed == numCourses;
    }
}
