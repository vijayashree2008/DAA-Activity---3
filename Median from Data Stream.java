import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> smaller;
    private PriorityQueue<Integer> larger;

    public MedianFinder() {
        smaller = new PriorityQueue<>(Collections.reverseOrder());
        larger = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smaller.offer(num);

        larger.offer(smaller.poll());

        if (larger.size() > smaller.size()) {
            smaller.offer(larger.poll());
        }
    }

    public double findMedian() {
        if (smaller.size() > larger.size()) {
            return smaller.peek();
        }

        return ((double) smaller.peek() + larger.peek()) / 2.0;
    }
}