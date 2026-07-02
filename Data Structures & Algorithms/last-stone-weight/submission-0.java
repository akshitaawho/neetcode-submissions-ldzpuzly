class Solution {
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public int lastStoneWeight(int[] stones) {
        for (int i = 0; i<stones.length; i++){
            maxHeap.add(stones[i]);
        }

        while(maxHeap.size() >1){
            int max = maxHeap.poll();
            int secondmax = maxHeap.poll();

            if(max != secondmax){
                if (max > secondmax){
                    maxHeap.add(max -secondmax);
                }

                else if(max < secondmax){
                    maxHeap.add(secondmax- max);
                }
            }
        }

        if (maxHeap.size()==0){
            return 0;
        }
        
        return maxHeap.peek();
    }
}
