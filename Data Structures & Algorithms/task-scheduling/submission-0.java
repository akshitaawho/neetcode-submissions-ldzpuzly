class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> count = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;

        for (char task:tasks){
            count.put(task, count.getOrDefault(task, 0) + 1);
        }

        for (int i : count.values()) {
            maxHeap.add(i);
        }

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if(maxHeap.size()!=0){
                int freq = maxHeap.poll(); 
                freq = freq - 1;
                if (freq > 0) {
                    cooldown.add(new int[]{freq, time + n});
                }
            }

            if (!cooldown.isEmpty() && cooldown.peek()[1] <= time) {
                maxHeap.add(cooldown.poll()[0]);
            }
        }

        return time;
    }
}
