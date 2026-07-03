class MedianFinder {
    PriorityQueue<Integer> smallHalf = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    PriorityQueue<Integer> largeHalf = new PriorityQueue<>(); // min heap

    public MedianFinder() {}

    public void addNum(int num) {
        smallHalf.add(num);
        if (!largeHalf.isEmpty() && smallHalf.peek() > largeHalf.peek()) {
            largeHalf.add(smallHalf.poll());
        }
        if (smallHalf.size() > largeHalf.size() + 1) {
            largeHalf.add(smallHalf.poll());
        }
        if (largeHalf.size() > smallHalf.size() + 1) {
            smallHalf.add(largeHalf.poll());
        }
    }

    public double findMedian() {
        if (smallHalf.size() == largeHalf.size()) {
            return (smallHalf.peek() + largeHalf.peek()) / 2.0;
        } else if (smallHalf.size() > largeHalf.size()) {
            return smallHalf.peek();
        } else {
            return largeHalf.peek();
        }
    }
}