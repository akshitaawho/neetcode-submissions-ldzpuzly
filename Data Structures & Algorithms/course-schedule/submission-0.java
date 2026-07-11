class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Build indegree array
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 3: Add all indegree-0 nodes to queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 4: Kahn's Algorithm
        int processed = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            processed++;

            for (int neighbor : graph.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processed == numCourses;
    }
}